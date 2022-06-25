package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import main.controller.ControllerManager;
import main.sprites.Tile;
import main.sprites.SpriteManager;
import main.sprites.Spritesheet;
import main.sprites.entity.Player;

public class GamePanel extends JPanel implements Runnable {

    // Init classes
    private Settings settings = new Settings();
    BufferedImage testImage;
    public float scrollWait = settings.SCROLLWAIT;
    String line;
    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler(this);
    public ControllerManager controllerManager = new ControllerManager(this);
    public Spritesheet spritesheet = new Spritesheet();
    public SpriteManager spriteManager = new SpriteManager(this);
    public ScreenShake screenShake = new ScreenShake(this);
    public MenuManager menuManager = new MenuManager(this);

    public GamePanel() {

        this.setPreferredSize(new Dimension(settings.SCREENWIDTH, settings.SCREENHEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

    }



    public void startgameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }



    @Override
    public void run() {

        //* Main game loop

        double drawInterval = 1000000000 / settings.FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {

                // UPDATE
                update();

                // DRAW
                //? Uses built-in method to call the other overridden methods
                repaint();

                delta--;

            }

        }

    }



    public void updateSprites() {

        if (!menuManager.inMenu) {

            for (Tile tile : spriteManager.allTiles) {

                tile.update();

            }

            for (Player player : controllerManager.players) {

                player.update();

            }

        }

    }



    public void update() {

        updateSprites();

    }



    //? Default method overridden
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;


        
        
        for (Tile sprite : spriteManager.allTiles) {
            
            if (!sprite.destroyed) {

                if (sprite.drawX > -settings.TILESIZE && sprite.drawX <= settings.SCREENWIDTH) {
                    
                    if (sprite.drawY > -settings.TILESIZE && sprite.drawY <= settings.SCREENHEIGHT) {
                        
                        if (sprite.id.equals("66") && !sprite.destroyed) {

                            sprite.draw(g2);

                        }

                        if (!sprite.id.equals("66")) {

                            sprite.draw(g2);

                        }
                        
                    } 
                    
                }

            }
            
        }
        
        for (Player player : controllerManager.players) {

            player.draw(g2);

        }

        spritesheet.drawText(g2, "Players: " + controllerManager.playerCount, 0, 0, new String[] {"center", "top"});

        String charPressedStr = Character.toString(keyHandler.charPressed);

        menuManager.draw(g2);


        g2.dispose();

    }

}
