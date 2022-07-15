package main;

import main.settings.Settings;
import main.sprites.Tile;
import main.sprites.entity.player.Player;

public class ScreenShake {

    GamePanel gp;
    

    private float lastUpdate;
    public int shakeStage;

    public ScreenShake(GamePanel gp) {

        this.gp = gp;
        this.lastUpdate = 0f;
        this.shakeStage = 1;

    }

    public void shake() {

        if (this.shakeStage == 1) {

            this.shakeStage = 2;

        }

    }



    public void update() {

        if (this.shakeStage == 2) {

            long now = System.nanoTime();

            if (now - this.lastUpdate > Settings.SHAKE_WAIT) {
                
                this.lastUpdate = now;

                for (Player player : this.gp.controllerManager.players) {
        
                    player.drawX += Settings.SHAKE_AMT;
        
                }

                for (Tile tile : this.gp.spriteManager.allTiles) {

                    tile.drawX += Settings.SHAKE_AMT;
        
                }

                this.shakeStage = 3;

            }

        }

        if (this.shakeStage == 3) {

            long now = System.nanoTime();

            if (now - this.lastUpdate > Settings.SHAKE_WAIT) {
                
                this.lastUpdate = now;

                for (Player player : this.gp.controllerManager.players) {
        
                    player.drawY += Settings.SHAKE_AMT;
        
                }

                for (Tile tile : this.gp.spriteManager.allTiles) {

                    tile.drawY += Settings.SHAKE_AMT;
        
                }
        

                this.shakeStage = 4;

            }

        }

        if (this.shakeStage == 4) {

            long now = System.nanoTime();

            if (now - this.lastUpdate > Settings.SHAKE_WAIT) {
                
                this.lastUpdate = now;
                
                for (Player player : this.gp.controllerManager.players) {
        
                    player.drawX -= Settings.SHAKE_AMT;
        
                }

                for (Tile tile : this.gp.spriteManager.allTiles) {

                    tile.drawX -= Settings.SHAKE_AMT;
        
                }
        

                this.shakeStage = 5;

            }

        }

        if (this.shakeStage == 5) {

            long now = System.nanoTime();

            if (now - this.lastUpdate > Settings.SHAKE_WAIT) {
                
                this.lastUpdate = now;
                
                for (Player player : this.gp.controllerManager.players) {
        
                    player.drawY -= Settings.SHAKE_AMT;
        
                }

                for (Tile tile : this.gp.spriteManager.allTiles) {

                    tile.drawY -= Settings.SHAKE_AMT;
        
                }
        

                this.shakeStage = 1;

            }

        }

    }

}
