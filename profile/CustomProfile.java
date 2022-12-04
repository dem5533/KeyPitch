package profile;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

/**
 * CustomProfile.java
 * The main profile which calls code to pitch shift wav files
 *
 * @author Caleb Henry
 */
public class CustomProfile implements Profile {
    private final byte[] buffer = new byte[1024];
    private URL path;
    private AudioInputStream stream;

    public CustomProfile(File file) {
        URI fileURI = file.toURI();
        try {
            path = fileURI.toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try {
            stream = AudioSystem.getAudioInputStream(Objects.requireNonNull(file));
        } catch (UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void play(int note) {
        // TODO Call Danny's code here
        // The int note is based on MIDI standards so 60 is middle C.
        // getPath() for the URL of the file

        /* This works for testing
        int bytesRead;

        while (true) {
            try {
                if ((bytesRead = stream.read(buffer)) == -1) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Frame size is 4 bytes so bytesRead must be a multiple of 4
            bytesRead -= (bytesRead % 4);

            PlaySound.writeBuffer(buffer, 0, bytesRead);
        }
         */
    }

    public URL getPath() {
        return path;
    }
}