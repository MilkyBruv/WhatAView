package main.sprites;

import main.GamePanel;
import main.Settings;
import main.sprites.entity.Player;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Menu {
    
    public String title;
    public String[] items;
    public int[][] itemPositions;
    public int itemCount;

    public int currentSelection = 0;

    public BufferedImage image;

    private GamePanel gp;
    private Settings settings = new Settings();

    public Menu(GamePanel gp, String title, int itemCount) {

        this.gp = gp;

        this.title = title;
        this.itemPositions = new int[][] {

            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0}
    
        };
        this.items = new String[] {"", "", "", "", ""};
        this.itemCount = itemCount;

        this.getItemPositions();
        this.image = this.getImage();

    }

    

    public void getItemPositions() {

        int cy = 0;
        int cx = 0;
        int count = 0;

        for (String item : this.items) {
            
            cx = (settings.SCREENWIDTH / 2) - (item.length() * settings.TILESIZE);

            this.itemPositions[count][0] = cx;
            this.itemPositions[count][1] = cy;

            if (count == 0) {

                cy += settings.TILESIZE * 2;

            } else {

                cy += settings.TILESIZE;

            }

            count++;

        }

    }



    public void setImage() {

        BufferedImage baseDisplay = new BufferedImage(settings.SCREENWIDTH, settings.SCREENHEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = baseDisplay.getGraphics();

        for (int i = 0 ; i < this.itemCount ; i++) {

            BufferedImage textImage = this.gp.spritesheet.getText(this.items[i]);

            g.drawImage(textImage, this.itemPositions[i][0], this.itemPositions[i][1], textImage.getWidth(), textImage.getHeight(), null);

        }

    }



    public BufferedImage getImage() {

        BufferedImage baseDisplay = new BufferedImage(settings.SCREENWIDTH, settings.SCREENHEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = baseDisplay.getGraphics();

        for (int i = 0 ; i < this.itemCount ; i++) {

            BufferedImage textImage = this.gp.spritesheet.getText(this.items[i]);

            g.drawImage(textImage, this.itemPositions[i][0], this.itemPositions[i][1], textImage.getWidth(), textImage.getHeight(), null);

        }

        return baseDisplay;

    }



    public void draw(Graphics2D g2) {

        g2.drawImage(this.image, 0, 0, this.image.getWidth(), this.image.getHeight(), null);

    }

}
