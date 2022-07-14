package main.camera;

import java.awt.Graphics2D;

import main.GamePanel;
import main.Settings;
import main.sprites.entity.Player;

public class Camera {
    
    public int x;
    public int y;
    public int width;
    public int height;
    private GamePanel gp;
    private Player player;

    public Camera(GamePanel gp) {

        this.gp = gp;
        
        this.player = gp.controllerManager.getPlayer(1);
        this.width = Settings.SCREEN_WIDTH;
        this.height = Settings.SCREEN_HEIGHT;
        this.x = (this.player.x + (this.player.width / 2)) - (this.width / 2);
        this.y = (this.player.y + (this.player.height / 2)) - (this.height / 2);

    }



    public void setPos() {

        this.x = (this.player.x + (this.player.width / 2)) - (this.width / 2);
        this.y = (this.player.y + (this.player.height / 2)) - (this.height / 2);

    }



    public void checkBounds() {

        this.setPos();

        if (this.x <= gp.spriteManager.mapBoundsLeft) {

            gp.spriteManager.lockedLeft = true;

        }  else { gp.spriteManager.lockedLeft = false; }


        if (this.x + this.width >= gp.spriteManager.mapBoundsRight) {

            gp.spriteManager.lockedRight = true;

        }  else { gp.spriteManager.lockedRight = false; }


        if (this.y <= gp.spriteManager.mapBoundsTop) {

            gp.spriteManager.lockedTop = true;

        }  else { gp.spriteManager.lockedTop = false; }


        if (this.y + this.height >= gp.spriteManager.mapBoundsBottom) {

            gp.spriteManager.lockedBottom = true;

        }  else { gp.spriteManager.lockedBottom = false; }

    }



    public void update() {

        this.checkBounds();

    }

}
