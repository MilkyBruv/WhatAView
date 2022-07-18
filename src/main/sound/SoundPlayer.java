package main.sound;

public class SoundPlayer {

    public static void playMusic(String name) {
    
        SoundManager soundManager = new SoundManager();

        soundManager.setFile(name);
        soundManager.play();
        soundManager.loop();

    }



    public static void stopMusic() {
    
        SoundManager soundManager = new SoundManager();

        soundManager.stop();

    }



    public static void playEffect(String name) {
    
        SoundManager soundManager = new SoundManager();

        soundManager.setFile(name);
        soundManager.play();

    }

}
