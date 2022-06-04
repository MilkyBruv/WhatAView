package main.sprites.entity;

import main.GamePanel;

public class Sprite {
    
    public int x;
    public int y;
    public int width;
    public int height;
    public int drawX;
    public int drawY;
    public int scrollDiff;
    public float lastUpdate;

    public GamePanel gp;

    public Sprite(GamePanel gp) {

        this.gp = gp;

    }

}
