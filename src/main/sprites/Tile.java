package main.sprites;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;
import main.Settings;
import main.sprites.entity.Sprite;
import main.utils.Utils;

public class Tile extends Sprite {

    private Settings settings = new Settings();
    
    public int x;
    public int y;
    public String id;
    public boolean solid;
    public boolean dangerous;
    public BufferedImage image;
    public Rectangle rect;

    public boolean destroyed;

    public Tile(int x, int y, String id, boolean solid, boolean dangerous, BufferedImage image, GamePanel gp) {

        super(gp);

        this.x = x;
        this.y = y;
        this.drawX = this.x;
        this.drawY = this.y + this.scrollDiff;
        this.width = settings.TILE_SIZE;
        this.height = settings.TILE_SIZE;
        this.lastUpdate = 0f;
        this.scrollDiff = 0;
        this.id = id;
        this.solid = solid;
        this.dangerous = dangerous;
        this.image = image;

        this.rect = new Rectangle();
        this.rect.x = this.x;
        this.rect.y = this.y;
        this.rect.width = settings.TILE_SIZE;
        this.rect.height = settings.TILE_SIZE;

        // If the tile is a platform
        if (this.id.equals("60")) {

            this.rect.width = settings.TILE_SIZE;
            this.rect.height = 2 * settings.TILE_SCALE;

        }

        // If the tile is a rope
        if (this.id.equals("59")) {

            this.rect.x = this.x + 3 * settings.TILE_SCALE;
            this.rect.y = this.y;
            this.rect.width = 2 * settings.TILE_SCALE;
            this.rect.height = settings.TILE_SIZE;

        }
        
        this.destroyed = false;

    }


    
    public void kill() {

        this.destroyed = true;
        this.x = -(settings.TILE_SIZE * 2);
        this.y = -(settings.TILE_SIZE * 2);
        this.rect.x = this.x;
        this.rect.y = this.y;
        this.rect.width = this.image.getWidth() * settings.TILE_SCALE;
        this.rect.height = this.image.getHeight() * settings.TILE_SCALE;

    }



    public void update() {

        this.drawX = this.x - gp.controllerManager.getPlayer(1).x + gp.controllerManager.getPlayer(1).drawX;
        this.drawY = this.y - gp.controllerManager.getPlayer(1).y + gp.controllerManager.getPlayer(1).drawY;

        // If the tile is a platform
        if (this.id.equals("60")) {

            this.rect.x = this.x;
            this.rect.y = this.y;
            this.rect.width = settings.TILE_SIZE;
            this.rect.height = 2 * settings.TILE_SCALE;

        }

        // If the tile is a rope
        if (this.id.equals("59")) {

            this.rect.x = this.x + 3 * settings.TILE_SCALE;
            this.rect.y = this.y;
            this.rect.width = 2 * settings.TILE_SCALE;
            this.rect.height = settings.TILE_SIZE;

        }

        if (!this.id.equals("60") && !this.id.equals("59")) {

            this.rect.x = this.x;
            this.rect.y = this.y;
            this.rect.width = settings.TILE_SIZE;
            this.rect.height = settings.TILE_SIZE;

        }

    }
    


    public void draw(Graphics2D g2) {
        
        if (Utils.inRange(this.drawX, 0, settings.SCREEN_WIDTH) && Utils.inRange(this.drawY, 0, settings.SCREEN_HEIGHT)) {

            g2.drawImage(this.image, this.drawX, this.drawY, settings.TILE_SIZE, settings.TILE_SIZE, null);

        }

    }

}
