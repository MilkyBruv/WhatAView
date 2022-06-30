package main.sprites;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.GamePanel;
import main.Settings;
import main.sprites.entity.Player;
import main.sprites.entity.Sprite;
import main.utils.Utils;

public class SpriteManager {
    
    public List<Tile> allTiles = new ArrayList<Tile>() {};
    public List<Tile> allRopeTiles = new ArrayList<Tile>() {};
    public List<Tile> allDangerousTiles = new ArrayList<Tile>() {};

    public List<int[]> mapPositionData = new ArrayList<int[]>() {};
    public List<Object[]> mapIdData = new ArrayList<Object[]>() {};

    public int currentMap = 1;

    private String mapStr = "";

    private Settings settings = new Settings();
    private Spritesheet spritesheet = new Spritesheet();
    private GamePanel gp;
    private Utils utils = new Utils();

    private int mapHeight = 120;

    public SpriteManager(GamePanel gp) {

        this.gp = gp;

        getMapStr();
        parseMapData();
        createSprites();

        currentMap = 1;

    }



    public void createSprite(String id, int x, int y) {

        // #region 1st row

        if (id.equals("1")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("2")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("3")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("4")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("5")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("6")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("7")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("8")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("9")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("10")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("11")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("12")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("13")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("14")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("15")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 0), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("16")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 0), this.gp);
            this.allTiles.add(newTile);

        }

        //#endregion

        // #region 2nd row

        if (id.equals("17")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("18")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("19")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("20")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("21")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("22")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("23")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("24")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("25")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("26")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("27")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("28")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("29")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("30")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("31")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 1), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("32")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 1), this.gp);
            this.allTiles.add(newTile);

        }

        //#endregion

        // #region 3rd row

        if (id.equals("33")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("34")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("35")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(2, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("36")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(3, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("37")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(4, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("38")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(5, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("39")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(6, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("40")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(6, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("41")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(25, 2), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("42")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(26, 2), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("43")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(27, 2), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("44")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(28, 2), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("45")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(29, 2), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("46")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(30, 2), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("47")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(31, 2), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("48")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(32, 2), this.gp);
            this.allTiles.add(newTile);
    
        }

        // #endregion

        // #region 4th row

        if (id.equals("49")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("50")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("51")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("52")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("53")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("54")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("55")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("56")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("57")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("58")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("59")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("60")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("61")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("62")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("63")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 4), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("64")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 4), this.gp);
            this.allTiles.add(newTile);
    
        }

        // #endregion

        // #region 5th row

        if (id.equals("65")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("66")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("67")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("68")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("69")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("70")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("71")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("72")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("73")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("74")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("75")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("76")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("77")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("78")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("79")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 5), this.gp);
            this.allTiles.add(newTile);
    
        } if (id.equals("80")) {
    
            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 5), this.gp);
            this.allTiles.add(newTile);
    
        }

        //#endregion

        // #region 6th row

        if (id.equals("81")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("82")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("83")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("84")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("85")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("86")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("87")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("88")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("89")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("90")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("91")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("92")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("93")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("94")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("95")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("96")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 6), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 7th row

        if (id.equals("97")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("98")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("99")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("100")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("101")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("102")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("103")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("104")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("105")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("106")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("107")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("108")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("109")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("110")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("111")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("112")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 7), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 8th row

        if (id.equals("113")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("114")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("115")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("116")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("117")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("118")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("119")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("120")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("121")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("122")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("123")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("124")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("125")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("126")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("127")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("128")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 8), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 9th row

        if (id.equals("129")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("130")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("131")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("132")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("133")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("134")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("135")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("136")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("137")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("138")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("139")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("140")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("141")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("142")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("143")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 9), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("144")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 9), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 10th row

        if (id.equals("145")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("146")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("147")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("148")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("149")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("150")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("151")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("152")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("153")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("154")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("155")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("156")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("157")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("158")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("159")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 10), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("160")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 10), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 11th row

        if (id.equals("161")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("162")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("163")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("164")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("165")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("166")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("167")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("168")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("169")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("170")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("171")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("172")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("173")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("174")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("175")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 11), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("176")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 11), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 12th row

        if (id.equals("177")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("178")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("179")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("180")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("181")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("182")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("183")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("184")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("185")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("186")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("187")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("188")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("189")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("190")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("191")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 12), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("192")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 12), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 13th row

        if (id.equals("193")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("194")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("195")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("196")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("197")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("198")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("199")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("200")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("201")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("202")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("203")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("204")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("205")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("206")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("207")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 13), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("208")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 13), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 14th row

        if (id.equals("209")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("210")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("211")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("212")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("213")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("214")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("215")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("216")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("217")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("218")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("219")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("220")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("221")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("222")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("223")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 14), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("224")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 14), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 15th row

        if (id.equals("225")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("226")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("227")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("228")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("229")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("230")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("231")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("232")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("233")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("234")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("235")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("236")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("237")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("238")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("239")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 15), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("240")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 15), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 16th row

        if (id.equals("241")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("242")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("243")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("244")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("245")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("246")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("247")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("248")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("249")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("250")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("251")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("252")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("253")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("254")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("255")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 16), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("256")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 16), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

    }



    public void getMapStr() {

        try {

            File file = new File("src/res/maps/tiledfiles/map" + currentMap + ".tmx");
            Scanner reader = new Scanner(file);

            for (int i = 0; i < 147; i++) {
                
                String line = new String(reader.next());

                mapStr += line;

            }

            reader.close();

            mapStr = mapStr.replace("<?xmlversion=\"1.0\"encoding=\"UTF-8\"?><mapversion=\"1.4\"tiledversion=\"1.4.3\"orientation=\"orthogonal\"renderorder=\"right-down\"width=\"32\"height=\"" + mapHeight + "\"tilewidth=\"8\"tileheight=\"8\"infinite=\"0\"nextlayerid=\"2\"nextobjectid=\"1\"><tilesetfirstgid=\"1\"source=\"JavaTileset.tsx\"/><layerid=\"1\"name=\"TileLayer1\"width=\"32\"height=\"28\"><dataencoding=\"csv\">", "");
            
        } catch (IOException e) {
            
            e.printStackTrace();

        }

    }



    public void parseMapData() {

        gp.controllerManager.createPlayers();

        for (int y = 0; y < mapHeight; y++) {
            
            for (int x = 0; x < settings.TILEDWITDH; x++) {
                
                mapPositionData.add(new int[] {x * settings.TILESIZE, (y * settings.TILESIZE) - ((mapHeight * settings.TILESIZE) - settings.SCREENHEIGHT)});

            }

        }

    }



    public void createSprites() {

        String[] mapIdData = mapStr.split(",");

        for (int i = 0; i < mapIdData.length; i++) {

            if (!mapIdData[i].equals("0")) {

                createSprite(mapIdData[i], mapPositionData.get(i)[0], mapPositionData.get(i)[1]);

            }

        }

    }



    public boolean isInRange(Sprite base_entity, Sprite other_entity, int bounds) {

        int bx = base_entity.x;
        int by = base_entity.y;
        int bw = base_entity.width;
        int bh = base_entity.height;

        int[] xBounds = new int[] {bx - bounds, bx + bw + bounds};
        int[] yBounds = new int[] {by - bounds, by + bh + bounds};

        int ox = other_entity.x;
        int oy = other_entity.y;
        int ow = other_entity.width;
        int oh = other_entity.height;

        if (utils.inRange(ox, xBounds[0], xBounds[1]) || utils.inRange(ox + ow, xBounds[0], xBounds[1])) {

            if (utils.inRange(oy, yBounds[0], yBounds[1]) || utils.inRange(oy + oh, yBounds[0], yBounds[1])) {

                return true;

            }

        }

        return false;

    }

}
