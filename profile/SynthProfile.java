package profile;

/**
 * SynthProfile.java
 * Synth default profile. Uses sine function to synthesize notes
 *
 * @author Caleb Henry
 */
public class SynthProfile implements Profile {
    private static final int SAMPLE_RATE = 44100; // Samples per second

    private double calculatePitch(int note) {
        double power = (note - 69) / 12.0;
        return Math.pow(2, power) * 440;
    }

    public void play(int note) {
        //final int AMPLITUDE = 8000;
        final int AMPLITUDE = 32000 / (note - 35);

        byte[] buffer = new byte[1024];

        int bufferPosition = 0;

        double pitch = calculatePitch(note);

        for (int dt = 0; dt < 50000; dt++) {
            short sample = (short) (Math.sin(2 * Math.PI * pitch * dt / SAMPLE_RATE) * AMPLITUDE);

            // We are using 16-bit audio samples, but the line.write() method requires a byte array
            // Solution: split each sample into two halves and store them individually

            sample = Short.reverseBytes(sample); // Convert to little-endian

            buffer[bufferPosition] = (byte) (sample >>> 8); // First half

            bufferPosition++;

            buffer[bufferPosition] = (byte) (sample & 0xff); // Second half

            bufferPosition++;

            // If the buffer is full, send it to output
            if (bufferPosition >= buffer.length) {
                PlaySound.writeBuffer(buffer, 0, buffer.length);
                bufferPosition = 0;
            }
        }
    }
}
