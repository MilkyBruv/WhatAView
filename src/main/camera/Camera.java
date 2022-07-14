package main.camera;

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
        this.x = 0;
        this.y = 0;
        this.width = Settings.SCREEN_WIDTH;
        this.height = Settings.SCREEN_HEIGHT;

    }



    public void setPos() {

        this.x = (this.player.drawX + (this.player.width / 2)) - (this.width / 2);
        this.y = (this.player.drawY + (this.player.height / 2)) - (this.height / 2);

    }



    public void checkBounds() {

        this.setPos();

        if (this.x <= gp.spriteManager.mapBoundsLeft) {

            gp.spriteManager.lockedLeft = true;

        }  else { gp.spriteManager.lockedLeft = true; }


        if (this.x + this.width <= gp.spriteManager.mapBoundsRight) {

            gp.spriteManager.lockedRight = true;

        }  else { gp.spriteManager.lockedRight = true; }


        if (this.y >= gp.spriteManager.mapBoundsTop) {

            gp.spriteManager.lockedTop = true;

        }  else { gp.spriteManager.lockedTop = true; }


        if (this.y + this.height >= gp.spriteManager.mapBoundsBottom) {

            gp.spriteManager.lockedBottom = true;

        }  else { gp.spriteManager.lockedBottom = true; }

    }



    public void update() {

        this.checkBounds();

    }

}
