import be.tarsos.dsp.*;
import be.tarsos.dsp.io.TarsosDSPAudioFloatConverter;
import be.tarsos.dsp.io.TarsosDSPAudioFormat;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.io.jvm.AudioPlayer;
import be.tarsos.dsp.resample.RateTransposer;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Class to model a simple audio player that play's and pause's audio.
 * <p>
 *     It achieves this using the TarsosDSP library. To shift the pitch, it utilizes an overlap-add technique wave form
 *     similarity (WSOLA) to speed and pitch up the audio, then a rate transposer to return it to the original length
 *     while maintaining the pitch.
 * </p>
 * @author Daniel Molnar
 * @version 1.1
 */
public class AudioPitcher implements AudioProcessor {

    private double pitchFactor;
    private double gainFactor;
    private File audioFile;
    private AudioInputStream audioInputStream;
    private WaveformSimilarityBasedOverlapAdd wsola;
    private RateTransposer rateTransposer;
    private GainProcessor gainProcessor;
    private AudioDispatcher dispatcher;
    private AudioPlayer audioPlayer;
    AudioFormat format;

    /**
     * Constructor for the SimpleAudioPlayer class.
     * <p>
     *     Creates necessary audio processors, dispatcher to play said audio, and adds the processor to the dispatcher.
     *     Also reformats pitching factor to more logical orientation.
     * </p>
     * <p>
     *    pitchFactor works based on an exponential with base 2, i.e. 2 = first octave, 4 = second octave, ect.
     * </p>
     * @param filePath String: location path of file.
     * @param pitchFactor double: pitching factor, must be between .25 and 10; 1.0 is original pitch.
     * @param gainFactor double: volume factor; 1.0 is original volume.
     */
    public AudioPitcher(String filePath, double pitchFactor, double gainFactor) {

        this.gainFactor = gainFactor;
        this.pitchFactor = 1 / pitchFactor;

        try {
            audioFile = new File(filePath);
            audioInputStream = AudioSystem.getAudioInputStream(audioFile);

            if (audioFile != null) {
                format = AudioSystem.getAudioFileFormat(audioFile).getFormat();
            } else
                format = new AudioFormat(44100, 16, 1, true, false);

            audioPlayer = new AudioPlayer(format);
            wsola = new WaveformSimilarityBasedOverlapAdd(
                    WaveformSimilarityBasedOverlapAdd.Parameters.musicDefaults(this.pitchFactor, format.getSampleRate()));
            rateTransposer = new RateTransposer(this.pitchFactor);
            gainProcessor = new GainProcessor(this.gainFactor);

            if (format.getChannels() != 1) {
                dispatcher = AudioDispatcherFactory.fromFile(audioFile,
                        wsola.getInputBufferSize() * format.getChannels(),
                        wsola.getOverlap() * format.getChannels());
                dispatcher.addAudioProcessor(new MultichannelToMono(format.getChannels(), true));
            } else
                dispatcher = AudioDispatcherFactory.fromFile(audioFile, wsola.getInputBufferSize(), wsola.getOverlap());

            wsola.setDispatcher(dispatcher);

            dispatcher.addAudioProcessor(wsola);
            dispatcher.addAudioProcessor(rateTransposer);
            dispatcher.addAudioProcessor(gainProcessor);
            dispatcher.addAudioProcessor(audioPlayer);
            dispatcher.addAudioProcessor(this);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Forced implementation from AudioProcessor interface. Unmodified and unused.
     * @param audioEvent The audio event that contains audio data.
     * @return boolean representing if processing was finished
     */
    @Override
    public boolean process(AudioEvent audioEvent) {
        return false;
    }

    /**
     * Forced implementation from AudioProcessor interface. Not utilized.
     */
    @Override
    public void processingFinished() {
    }

    /**
     * Method to start thread pitching the audio for live playback.
     */
    public void start(){
        Thread thread = new Thread(dispatcher);
        thread.start();
    }

    /**
     * Method to pitch shift audio using the raw data stored as a byte array.
     * @param buffer byte array holding the audio data
     * @return byte array holding the pitch shifted data
     */
    public byte[] pitchShiftBytes(byte [] buffer) {


        TarsosDSPAudioFormat tarsosFormat = new TarsosDSPAudioFormat(this.format.getSampleRate(),
                this.format.getSampleSizeInBits(), this.format.getChannels(),true, this.format.isBigEndian());
        AudioEvent event = new AudioEvent(tarsosFormat);

        TarsosDSPAudioFloatConverter converter = TarsosDSPAudioFloatConverter.getConverter(tarsosFormat);
        float[] floatBuff = new float[buffer.length / 2];
        event.setFloatBuffer(converter.toFloatArray(buffer, floatBuff));

        this.wsola.process(event);
        this.rateTransposer.process(event);

        return event.getByteBuffer();
    }
}