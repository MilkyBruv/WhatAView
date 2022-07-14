package main.sprites.entity;

import main.GamePanel;
import main.Settings;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Enemy extends Sprite {

    BufferedImage image;
    
    public Enemy(GamePanel gp, int x, int y, int width, int height, String id) {

        super(gp);

        this.x = x;
        this.y = y;
        this.drawX = this.x;
        this.drawY = this.y;

        // TODO: Set images reletive to id

    }

    public void draw(Graphics2D g2) {

        g2.drawImage(this.image, this.drawX, this.drawY, Settings.TILE_SIZE, Settings.TILE_SIZE, null);

    }

}
