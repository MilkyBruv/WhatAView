package main.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.net.URL;

public class SoundManager {
    
    private Clip clip;
    private Sounds sounds = new Sounds();

    public void setFile(String name) {

        URL dir = sounds.soundsDict.get(name);

        try {

            AudioInputStream ais = AudioSystem.getAudioInputStream(dir);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }



    public void play() {
        
        clip.start();

    }



    public void loop() {

        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }



    public void stop() {

        clip.stop();

    }

}
