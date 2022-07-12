package main.sprites.entity;

import java.awt.image.BufferedImage;

import main.GamePanel;
import main.Settings;
import main.sprites.Tile;

import java.awt.Rectangle;

public class PlayerProjectile extends Sprite {
    
    private Settings settings = new Settings();
    private GamePanel gp;

    public BufferedImage image;
    public BufferedImage[] images;

    public Rectangle rect;
    public int width;
    public int height;

    private int speed;
    
    public boolean collided = false;

    private boolean[] dir;

    public PlayerProjectile(boolean[] dir, int playerNum, int x, int y, BufferedImage[] images, GamePanel gp) {
        
        super(gp);

        this.gp = gp;


        this.x = x;
        this.y = y;
        this.drawX = this.x;
        this.drawY = this.y;
        this.width = 4 * settings.TILE_SCALE;
        this.height = 4 * settings.TILE_SCALE;
        this.scrollDiff = 0;
        this.lastUpdate = 0f;

        this.collided = false;

        this.speed = 10;

        this.images = images;

        this.dir = dir;

        if (this.dir[0]) {

            this.image = this.images[0];
            this.y -= settings.TILE_SIZE / 2;
            this.x += settings.TILE_SIZE / 4;

        } else if (this.dir[1]) {

            this.image = this.images[1];
            this.y += settings.TILE_SIZE;
            this.x += settings.TILE_SIZE / 4;

        } else if (this.dir[2]) {

            this.image = this.images[2];
            this.y += settings.TILE_SIZE / 4;

        } else if (this.dir[3]) {

            this.image = this.images[3];
            this.x += settings.TILE_SIZE;
            this.y += settings.TILE_SIZE / 4;

        }

        this.width = this.image.getWidth() * settings.TILE_SCALE;
        this.height = this.image.getHeight() * settings.TILE_SCALE;

        this.rect = new Rectangle();
        this.rect.x = this.x;
        this.rect.y = this.y;
        this.rect.width = this.width;
        this.rect.height = this.height;

    }


    
    public void kill() {

        this.collided = true;

        this.x = -settings.TILE_SIZE;
        this.y = -settings.TILE_SIZE;
        this.speed = 0;

        this.rect.x = this.x;
        this.rect.y = this.y;
        this.rect.width = 1;
        this.rect.height = 1;

    }



    public void applyScroll() {

        long now = System.nanoTime();

        if (now - this.lastUpdate > settings.SCROLL_WAIT) {

            this.lastUpdate = now;

            this.scrollDiff += settings.SCROLL_SPEED;

        }

    }



    public void update() {

        this.applyScroll();

        this.drawX = this.x;
        this.drawY = this.y + this.scrollDiff;

        if (!this.collided) {

            this.width = this.image.getWidth() * settings.TILE_SCALE;
            this.height = this.image.getHeight() * settings.TILE_SCALE;

            this.rect = new Rectangle();
            this.rect.x = this.x;
            this.rect.y = this.y;
            this.rect.width = this.width;
            this.rect.height = this.height;

            if (this.dir[0]) {

                this.y -= this.speed;

            } if (this.dir[1]) {

                this.y += this.speed;

            } if (this.dir[2]) {

                this.x -= this.speed;

            } if (this.dir[3]) {

                this.x += this.speed;

            }

            for (Tile tile : gp.spriteManager.allTiles) {
                if (tile != null) {
    
                    if (!tile.id.equals("65") && tile.solid && this.rect.intersects(tile.rect)) {
                        
                        if (tile.id.equals("66")) {

                            tile.kill();

                        }

                        this.kill();
    
                    }
    
                }
    
            }

        }

    }

}
