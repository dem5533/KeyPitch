package profile;

import javax.sound.midi.*;
import java.util.Objects;

/**
 * PianoProfile.java
 * MIDI piano default profile
 *
 * @author Caleb Henry
 */
public class PianoProfile implements Profile {
    MidiChannel channel;

    public PianoProfile() {
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();

            synth.open();

            synth.loadAllInstruments(synth.getDefaultSoundbank());

            Instrument[] instruments = synth.getLoadedInstruments();

            MidiChannel[] channels = synth.getChannels();

            for (MidiChannel midiChannel : channels) {
                if (midiChannel != null) {
                    channel = midiChannel;
                    break;
                }
            }

            for (int i = 0; i < instruments.length; i++) {
                if (instruments[i].toString().startsWith("Instrument MidiPiano")) {
                    Objects.requireNonNull(channel).programChange(i);
                    break;
                }
            }

        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void noteOn(int note) {
        channel.noteOn(note, 100);
    }

    public void noteOff(int note) {
        channel.noteOff(note, 0);
    }

    public void play(int note) {
        // There's definitely a better way to do this but for now it works
        noteOn(note);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        noteOff(note);
    }

    public void stop(int note) {
        noteOff(note);
    }
}
