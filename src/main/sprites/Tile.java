package main.sprites;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;
import main.Settings;
import main.sprites.entity.Sprite;

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
        this.width = settings.TILESIZE;
        this.height = settings.TILESIZE;
        this.lastUpdate = 0f;
        this.scrollDiff = 0;
        this.id = id;
        this.solid = solid;
        this.dangerous = dangerous;
        this.image = image;

        this.rect = new Rectangle();
        this.rect.x = this.x;
        this.rect.y = this.y;
        this.rect.width = settings.TILESIZE;
        this.rect.height = settings.TILESIZE;

        // If the tile is a platform
        if (this.id.equals("60")) {

            this.rect.width = settings.TILESIZE;
            this.rect.height = 2 * settings.tileScale;

        }

        // If the tile is a rope
        if (this.id.equals("59")) {

            this.rect.x = this.x + 3 * settings.tileScale;
            this.rect.y = this.y;
            this.rect.width = 2 * settings.tileScale;
            this.rect.height = settings.TILESIZE;

        }
        
        this.destroyed = false;

    }



    public void applyScroll() {

        long now = System.nanoTime();

        if (now - this.lastUpdate > this.gp.scrollWait) {

            this.lastUpdate = now;

            this.scrollDiff += settings.SCROLLSPEED;

        }

    }


    
    public void kill() {

        this.destroyed = true;
        this.x = -(settings.TILESIZE * 2);
        this.y = -(settings.TILESIZE * 2);
        this.rect.x = this.x;
        this.rect.y = this.y;
        this.rect.width = this.image.getWidth() * settings.tileScale;
        this.rect.height = this.image.getHeight() * settings.tileScale;

    }



    public void update() {

        this.applyScroll();

        this.drawX = this.x;
        this.drawY = this.y + this.scrollDiff;

        // If the tile is a platform
        if (this.id.equals("60")) {

            this.rect.x = this.x;
            this.rect.y = this.y;
            this.rect.width = settings.TILESIZE;
            this.rect.height = 2 * settings.tileScale;

        }

        // If the tile is a rope
        if (this.id.equals("59")) {

            this.rect.x = this.x + 3 * settings.tileScale;
            this.rect.y = this.y;
            this.rect.width = 2 * settings.tileScale;
            this.rect.height = settings.TILESIZE;

        }

        if (!this.id.equals("60") && !this.id.equals("59")) {

            this.rect.x = this.x;
            this.rect.y = this.y;
            this.rect.width = settings.TILESIZE;
            this.rect.height = settings.TILESIZE;

        }

    }
    


    public void draw(Graphics2D g2) {
        
        g2.drawImage(this.image, this.drawX, this.drawY, settings.TILESIZE, settings.TILESIZE, null);

    }

}
