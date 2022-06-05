package main.sprites;

import main.GamePanel;

import java.awt.image.BufferedImage;

public class SpeechText {
    
    GamePanel gp;

    public SpeechText(GamePanel gp) {

        this.gp = gp;

    }



    public void drawSpeechText(String text, int entityX, int entityY) {

        BufferedImage textImage = this.gp.spritesheet.getText(text);

        int width = 4 + textImage.getWidth() + 2;
        int height = textImage.getWidth();

        BufferedImage baseImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    }

}
