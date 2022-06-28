package main.sprites;

import main.GamePanel;
import main.Settings;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Menu {
    
    public String title;
    public String[] items;
    public int[][] itemPositions;
    public int itemCount;
    public int selectedItem;

    public int currentSelection = 0;

    public BufferedImage image;

    private GamePanel gp;
    private Settings settings = new Settings();

    public Menu(GamePanel gp, String title, String[] items) {

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
        this.items = items;
        this.itemCount = this.items.length;
        this.selectedItem = 0;

        this.getItemPositions();
        this.image = this.getImage();

        System.out.println(this.title);

    }



    public void setItemSelection() {

        for (int i = 0; i < itemCount; i++) {
            
            if (i == this.currentSelection && !this.items[this.currentSelection].contains(">")) {

                String currentItem = this.items[this.currentSelection];
                String newCurrentItem = "> ";

                newCurrentItem += currentItem + " <";

                this.items[this.currentSelection] = newCurrentItem;

            }

            if (i != this.currentSelection) {

                this.items[i] = this.items[i].replace("> ", "");
                this.items[i] = this.items[i].replace(" <", "");

            }

        }

    }

    

    public void getItemPositions() {

        int cy = 0;
        int cx = 0;
        int count = 0;

        for (String item : this.items) {
            
            cx = (settings.SCREENWIDTH / 2) - ((item.length() * settings.TILESIZE) / 2);

            this.itemPositions[count][0] = cx;
            this.itemPositions[count][1] = cy;

            cy += settings.TILESIZE * 2;

            count++;

        }

    }



    public void setImage() {

        BufferedImage baseDisplay = new BufferedImage(settings.SCREENWIDTH, settings.SCREENHEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = baseDisplay.getGraphics();

        BufferedImage titleTextImage = this.gp.spritesheet.getText(this.title);
        
        int x = (settings.SCREENWIDTH / 2) - (titleTextImage.getWidth() / 2);
        int y = 5 * settings.TILESIZE;
        
        g.drawImage(titleTextImage, x, y, titleTextImage.getWidth(), titleTextImage.getHeight(), null);

        y += 5 * settings.TILESIZE;

        for (int i = 0 ; i < this.itemCount ; i++) {

            if (!this.items[i].equals("ph")) {

                BufferedImage textImage = this.gp.spritesheet.getText(this.items[i]);

                g.drawImage(textImage, this.itemPositions[i][0], this.itemPositions[i][1] + y, textImage.getWidth(), settings.TILESIZE, null);

            }

            y += settings.TILESIZE;

        }

        this.image = baseDisplay;

    }



    public BufferedImage getImage() {

        BufferedImage baseDisplay = new BufferedImage(settings.SCREENWIDTH, settings.SCREENHEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = baseDisplay.getGraphics();

        BufferedImage titleTextImage = this.gp.spritesheet.getText(this.title);
        
        int x = (settings.SCREENWIDTH / 2) - (titleTextImage.getWidth() / 2);
        int y = 6 * settings.TILESIZE;
        
        g.drawImage(titleTextImage, x, y, titleTextImage.getWidth(), titleTextImage.getHeight(), null);

        y += 2 * settings.TILESIZE;

        for (int i = 0 ; i < this.itemCount ; i++) {

            if (!this.items[i].equals("ph")) {

                BufferedImage textImage = this.gp.spritesheet.getText(this.items[i]);

                g.drawImage(textImage, this.itemPositions[i][0], this.itemPositions[i][1] + y, textImage.getWidth(), settings.TILESIZE, null);

            }

            y += 2 * settings.TILESIZE;

        }

        return baseDisplay;

    }

}
