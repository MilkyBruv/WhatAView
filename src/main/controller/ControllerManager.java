package main.controller;

import java.util.List;
import java.util.ArrayList;

import java.awt.image.BufferedImage;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controllers;

import main.GamePanel;
import main.sprites.Spritesheet;
import main.sprites.entity.Player;

public class ControllerManager {

    public List<Player> players = new ArrayList<Player>() {};
    public int playerCount = 0;

    private Spritesheet spritesheet = new Spritesheet();
    
    BufferedImage player1Image;
    BufferedImage player2Image;

    BufferedImage player1ProjectileImageUp;
    BufferedImage player1ProjectileImageDown;
    BufferedImage player1ProjectileImageLeft;
    BufferedImage player1ProjectileImageRight;
    
    BufferedImage player2ProjectileImageUp;
    BufferedImage player2ProjectileImageDown;
    BufferedImage player2ProjectileImageLeft;
    BufferedImage player2ProjectileImageRight;

    BufferedImage[][] playerProjectileImages;
    GamePanel gp;

    public ControllerManager(GamePanel gp) {

        this.gp = gp;

        player1ProjectileImageUp = spritesheet.getSubImage(98,     32, 4, 4);
        player1ProjectileImageDown = spritesheet.getSubImage(90,   32, 4, 4);
        player1ProjectileImageLeft = spritesheet.getSubImage(112,  34, 4, 4);
        player1ProjectileImageRight = spritesheet.getSubImage(104, 34, 4, 4);

        player2ProjectileImageUp = spritesheet.getSubImage(98,     40, 4, 4);
        player2ProjectileImageDown = spritesheet.getSubImage(90,   40, 4, 4);
        player2ProjectileImageLeft = spritesheet.getSubImage(112,  42, 4, 4);
        player2ProjectileImageRight = spritesheet.getSubImage(104, 42, 4, 4);
        
        playerProjectileImages = new BufferedImage[][] {

            new BufferedImage[] {

                player1ProjectileImageUp,
                player1ProjectileImageDown,
                player1ProjectileImageLeft,
                player1ProjectileImageRight

            },

            new BufferedImage[] {

                player2ProjectileImageUp,
                player2ProjectileImageDown,
                player2ProjectileImageLeft,
                player2ProjectileImageRight

            }

        };

        try {

            Controllers.create();

        } catch (LWJGLException e) {

            e.printStackTrace();

        }

        Controllers.poll();

        for (int i = 0; i < Controllers.getControllerCount(); i++) {
            
            if (Controllers.getController(i).getName().equals("Wireless Controller")) {

                players.add(new Player(

                    100, 
                    100, 
                    playerProjectileImages[playerCount], 
                    new PlayerController(i), 
                    playerCount + 1, 
                    gp

                ));
                
                playerCount++;

            }

        }

        playerCount = players.size();
        
    }

}
