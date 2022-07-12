package main.camera;

import java.awt.Rectangle;

import main.Settings;
import main.sprites.Tile;
import main.sprites.entity.Player;

public class Camera {
    
    private Rectangle rect;
    private Settings settings = new Settings();

    private int width;
    private int height;

    public Camera(int width, int height) {

        this.rect = new Rectangle(0, 0, settings.SCREEN_WIDTH, settings.SCREEN_HEIGHT);
        this.width = width;
        this.height = height;

    }



    public void apply(Tile sprite) {

        sprite.rect.x += this.rect.x;
        sprite.rect.y += this.rect.y;

    }



    public void update(Player target) {

        int x = 0;
        int y = 0;

        x = -target.rect.x + (settings.SCREEN_WIDTH / 2);
        y = -target.rect.y + (settings.SCREEN_HEIGHT / 2);

        x = Math.min(0, x);
        y = Math.min(0, y);
        x = Math.max(-(this.width - settings.SCREEN_WIDTH), x);
        y = Math.max(-(this.height - settings.SCREEN_HEIGHT), y);

        this.rect = new Rectangle(x, y, settings.SCREEN_WIDTH, settings.SCREEN_HEIGHT);

    }

}
