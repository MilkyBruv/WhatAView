package main.sprites.particle;

import java.awt.image.BufferedImage;

import main.GamePanel;
import main.Settings;
import main.sprites.Spritesheet;
import main.sprites.entity.Player;
import main.sprites.entity.Sprite;

public class Particle extends Sprite {
    
    public BufferedImage image;
    private Spritesheet spritesheet;
    private Settings settings = new Settings();
    private Player player;
    public boolean active;
    public String type;
    private float lastParticleUpdate;

    private float lastUpdate;

    public Particle(Player player, String type, GamePanel gp) {

        super(gp);

        spritesheet = new Spritesheet();

        this.lastUpdate = 0f;
        this.lastParticleUpdate = 0f;
        this.active = false;
        this.player = player;
        this.type = type;

        this.x = -settings.TILE_SIZE;
        this.y = -settings.TILE_SIZE;
        this.drawX = this.x;
        this.drawY = this.y;
        this.setImage();
        this.width = this.image.getWidth() * settings.TILE_SCALE;
        this.height = this.image.getHeight() * settings.TILE_SCALE;
        this.scrollDiff = 0;

    }



    private void setImage() {

        if (this.type.equals("jump")) {

            this.image = spritesheet.getSubImage(80, 32, 3, 4);

        }

        if (this.type.equals("land")) {

            this.image = spritesheet.getSubImage(80, 37, 6, 3);

        }

    }



    public void applyScroll() {

        long now = System.nanoTime();

        if (now - this.lastUpdate > this.gp.scrollWait) {

            this.lastUpdate = now;

            this.scrollDiff += settings.SCROLL_SPEED;

        }

    }



    public void update() {

        this.applyScroll();

        this.drawX = this.x;
        this.drawY = this.y + this.scrollDiff;
        
        this.width = this.image.getWidth() * settings.TILE_SCALE;
        this.height = this.image.getHeight() * settings.TILE_SCALE;

        this.setImage();

        if (this.active) {

            long now = System.nanoTime();

            if (now - this.lastParticleUpdate >= settings.PARTICLE_WAIT) {

                this.lastParticleUpdate = now;

                this.x = -settings.TILE_SIZE;
                this.y = -settings.TILE_SIZE;
                this.active = false;

            }

        }

    }



    public void create() {

        this.active = true;
        this.x = player.x;
        this.y = player.y;

    }

}
