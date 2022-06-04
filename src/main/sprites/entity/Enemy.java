package main.sprites.entity;

import main.GamePanel;

public class Enemy extends Sprite {
    
    public Enemy(GamePanel gp, int x, int y, int width, int height, String id) {

        super(gp);

        this.x = x;
        this.y = y;
        this.drawX = this.x;
        this.drawY = this.y;

    }

}
