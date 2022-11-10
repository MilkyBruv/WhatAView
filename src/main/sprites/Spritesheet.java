package main.sprites;

import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.settings.Settings;

import java.util.Hashtable;

public class Spritesheet {
    
    public BufferedImage spritesheetImage;
    public BufferedImage tilesheetImage;
    public BufferedImage altImage;
    public BufferedImage image;
    public Hashtable<String, String> charsDict = new Hashtable<String, String>();

    public Spritesheet() {

        // #region Dictionary characters

        charsDict.put("a", "1, 0");
        charsDict.put("b", "2, 0");
        charsDict.put("c", "3, 0");
        charsDict.put("d", "4, 0");
        charsDict.put("e", "5, 0");
        charsDict.put("f", "6, 0");
        charsDict.put("g", "7, 0");
        charsDict.put("h", "8, 0");
        charsDict.put("i", "9, 0");
        charsDict.put("j", "10, 0");
        charsDict.put("k", "11, 0");
        charsDict.put("l", "12, 0");
        charsDict.put("m", "13, 0");
        charsDict.put("n", "14, 0");
        charsDict.put("o", "15, 0");

        charsDict.put("p", "1, 1");
        charsDict.put("q", "2, 1");
        charsDict.put("r", "3, 1");
        charsDict.put("s", "4, 1");
        charsDict.put("t", "5, 1");
        charsDict.put("u", "6, 1");
        charsDict.put("v", "7, 1");
        charsDict.put("w", "8, 1");
        charsDict.put("x", "9, 1");
        charsDict.put("y", "10, 1");
        charsDict.put("z", "11, 1");
        charsDict.put("1", "12, 1");
        charsDict.put("2", "13, 1");
        charsDict.put("3", "14, 1");
        charsDict.put("4", "15, 1");

        charsDict.put("#", "1, 2");
        charsDict.put("!", "2, 2");
        charsDict.put("\"", "3, 2");
        charsDict.put("\'", "4, 2");
        charsDict.put(",", "5, 2");
        charsDict.put(".", "6, 2");
        charsDict.put("=", "7, 2");
        charsDict.put("?", "8, 2");
        charsDict.put("_", "9, 2");
        charsDict.put("-", "10, 2");
        charsDict.put(" ", "11, 2");
        charsDict.put("5", "12, 2");
        charsDict.put("6", "13, 2");
        charsDict.put("7", "14, 2");
        charsDict.put("8", "15, 2");

        charsDict.put("☻", "1, 3");
        charsDict.put("☺", "2, 3");
        charsDict.put("◘", "3, 3");
        charsDict.put(">", "4, 3");
        charsDict.put("<", "5, 3");
        charsDict.put("(", "6, 3");
        charsDict.put(")", "7, 3");
        charsDict.put("/", "8, 3");
        charsDict.put("\\", "9, 3");
        charsDict.put("+", "10, 3");
        charsDict.put("*", "11, 3");
        charsDict.put("9", "12, 3");
        charsDict.put("0", "13, 3");
        charsDict.put(":", "14, 3");
        charsDict.put("%", "15, 3");
        
        charsDict.put("$", "1, 4");
        charsDict.put("@", "2, 4");
        charsDict.put("|", "3, 4");
        charsDict.put("[", "4, 4");
        charsDict.put("]", "5, 4");
        charsDict.put("{", "6, 4");
        charsDict.put("}", "7, 4");
        charsDict.put("^", "8, 4");
        charsDict.put("ඞ", "9, 4");

        // #endregion

        try {

            spritesheetImage = ImageIO.read(getClass().getResource("../../res/tiles/tilesetSprites.png"));
            tilesheetImage = ImageIO.read(getClass().getResource("../../res/tiles/tilesetTiles2.png"));
            altImage = ImageIO.read(getClass().getResource("../../res/tiles/alt.png"));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


    
    public BufferedImage getSubImage(int x, int y, int width, int height) {

        try {  

            image = spritesheetImage.getSubimage(x, y, width, height);
            return image;

        } catch (RasterFormatException e) {

            e.printStackTrace();

        }

        return altImage;

    }



    public BufferedImage getSubTile(int x, int y) {

        try {  

            image = tilesheetImage.getSubimage(x * 8, y * 8, 8, 8);
            return image;

        } catch (RasterFormatException e) {

            e.printStackTrace();

        }

        return altImage;

    }



    // Normal size text

    public BufferedImage getText(String _text) {

        String text = _text.toLowerCase();
        String fitText;
        
        // Limit characters in string to 32 (32 tiles wide)
        if (text.length() > Settings.TILED_WIDTH) {
            
            fitText = text.substring(0, Settings.TILED_WIDTH - 1);
            
        } else {
            
            fitText = text;
            
        }
        
        BufferedImage baseDisplay = new BufferedImage(fitText.length() * Settings.TILE_SIZE, Settings.TILE_SIZE, BufferedImage.TYPE_INT_RGB);
        Graphics g = baseDisplay.getGraphics();

        for (int i = 0 ; i < fitText.length() ; i++) {

            // Get nums as seperate strings
            String[] tileData = charsDict.get(Character.toString(fitText.charAt(i))).split(", ");

            // Convert strings to int[]
            int[] tileCoords = {

                Integer.parseInt(tileData[0]),
                Integer.parseInt(tileData[1])

            };

            BufferedImage charImage = getSubImage(tileCoords[0] * 8, tileCoords[1] * 8, 8, 8);
            g.drawImage(charImage, i * Settings.TILE_SIZE, 0, Settings.TILE_SIZE, Settings.TILE_SIZE, null);

        }

        return baseDisplay;

    }



    public void drawText(Graphics2D g2, String text, int x, int y, String[] pos) {

        BufferedImage textImage = getText(text);
        int xDes = 0;
        int yDes = 0;

        // #region X

        if (pos[0].equals("left")) {

            xDes = 0 + x;

        }

        if (pos[0].equals("right")) {

            xDes = (Settings.SCREEN_WIDTH - text.length() * Settings.TILE_SIZE) + x;

        }

        if (pos[0].equals("center")) {

            xDes = ((Settings.SCREEN_WIDTH - text.length() * Settings.TILE_SIZE) / 2) + x;

        }

        if (pos[0].equals("custom")) {

            xDes = x;

        }

        // #endregion

        // #region Y

        if (pos[1].equals("top")) {

            yDes = 0 + y;

        }

        if (pos[1].equals("bottom")) {

            yDes = Settings.SCREEN_HEIGHT - Settings.TILE_SIZE + y;

        }

        if (pos[1].equals("center")) {

            yDes = 13 * Settings.TILE_SIZE + y;

        }

        if (pos[1].equals("custom")) {

            yDes = y;

        }

        // #endregion

        g2.drawImage(textImage, xDes, yDes, textImage.getWidth(), textImage.getHeight(), null);

    }



    public BufferedImage getTextNoBG(String _text) {

        String text = _text.toLowerCase();
        String fitText;
        
        // Limit characters in string to 32 (32 tiles wide)
        if (text.length() > Settings.TILED_WIDTH) {
            
            fitText = text.substring(0, Settings.TILED_WIDTH - 1);
            
        } else {
            
            fitText = text;
            
        }
        
        BufferedImage baseDisplay = new BufferedImage(fitText.length() * Settings.TILE_SIZE, Settings.TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics g = baseDisplay.getGraphics();

        for (int i = 0 ; i < fitText.length() ; i++) {

            // Get nums as seperate strings
            String[] tileData = charsDict.get(Character.toString(fitText.charAt(i))).split(", ");

            // Convert strings to int[]
            int[] tileCoords = {

                Integer.parseInt(tileData[0]),
                Integer.parseInt(tileData[1])

            };

            BufferedImage charImage = getSubImage(tileCoords[0] * 8, tileCoords[1] * 8, 8, 8);
            g.drawImage(charImage, i * Settings.TILE_SIZE, 0, Settings.TILE_SIZE, Settings.TILE_SIZE, null);

        }

        return baseDisplay;

    }



    public void drawTextNoBG(Graphics2D g2, String text, int x, int y, String[] pos) {

        BufferedImage textImage = getTextNoBG(text);
        int xDes = 0;
        int yDes = 0;

        // #region X

        if (pos[0].equals("left")) {

            xDes = 0 + x;

        }

        if (pos[0].equals("right")) {

            xDes = (Settings.SCREEN_WIDTH - text.length() * Settings.TILE_SIZE) + x;

        }

        if (pos[0].equals("center")) {

            xDes = ((Settings.SCREEN_WIDTH - text.length() * Settings.TILE_SIZE) / 2) + x;

        }

        if (pos[0].equals("custom")) {

            xDes = x;

        }

        // #endregion

        // #region Y

        if (pos[1].equals("top")) {

            yDes = 0 + y;

        }

        if (pos[1].equals("bottom")) {

            yDes = Settings.SCREEN_HEIGHT - Settings.TILE_SIZE + y;

        }

        if (pos[1].equals("center")) {

            yDes = 13 * Settings.TILE_SIZE + y;

        }

        if (pos[1].equals("custom")) {

            yDes = y;

        }

        // #endregion

        g2.drawImage(textImage, xDes, yDes, textImage.getWidth(), textImage.getHeight(), null);

    }



    // Smaller size text

    public BufferedImage getSmallText(String _text) {

        String text = _text.toLowerCase();
        String fitText;
        
        // Limit characters in string to 32 (32 tiles wide)
        if (text.length() > Settings.TILED_WIDTH) {
            
            fitText = text.substring(0, Settings.TILED_WIDTH - 1);
            
        } else {
            
            fitText = text;
            
        }
        
        BufferedImage baseDisplay = new BufferedImage(fitText.length() * Settings.TILE_SIZE, Settings.TILE_SIZE, BufferedImage.TYPE_INT_RGB);
        Graphics g = baseDisplay.getGraphics();

        for (int i = 0 ; i < fitText.length() ; i++) {

            // Get nums as seperate strings
            String[] tileData = charsDict.get(Character.toString(fitText.charAt(i))).split(", ");

            // Convert strings to int[]
            int[] tileCoords = {

                Integer.parseInt(tileData[0]),
                Integer.parseInt(tileData[1])

            };

            BufferedImage charImage = getSubImage(tileCoords[0] * 8, tileCoords[1] * 8, 8, 8);
            g.drawImage(charImage, i * Settings.TILE_SIZE, 0, Settings.TILE_SIZE, Settings.TILE_SIZE, null);

        }

        return baseDisplay;

    }

}
