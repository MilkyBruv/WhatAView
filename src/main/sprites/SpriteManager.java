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

    public int currentMapX = 1;
    public int currentMapY = 0;

    public int mapBoundsLeft;
    public int mapBoundsRight;
    public int mapBoundsTop;
    public int mapBoundsBottom;

    public boolean lockedLeft = false;
    public boolean lockedRight = false;
    public boolean lockedTop = false;
    public boolean lockedBottom = false;

    private String mapStr = "";

    
    private Spritesheet spritesheet = new Spritesheet();
    private GamePanel gp;

    public int mapWidth = 0;
    public int mapHeight = 0;
    public int totalMapWidth = 0;
    public int totalMapHeight = 0;

    public SpriteManager(GamePanel gp) {

        this.gp = gp;

        this.currentMapX = 1;
        this.currentMapY = 0;
        this.mapWidth = 0;
        this.mapHeight = 0;

        getMapStr();
        parseMapData();
        createSprites();

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

        // #endregion

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

        // #endregion

        // #region 3rd row

        if (id.equals("33")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("34")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("35")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("36")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("37")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("38")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("39")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("40")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("41")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("42")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("43")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("44")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("45")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("46")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("47")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 2), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("48")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 2), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 4th row

        if (id.equals("49")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("50")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("51")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("52")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("53")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("54")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("55")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("56")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("57")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("58")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("59")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("60")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("61")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("62")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("63")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("64")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 3), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 5th row

        if (id.equals("65")) {

            Tile newTile = new Tile(x, y, id, false, true, spritesheet.getSubTile(0, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("66")) {

            Tile newTile = new Tile(x, y, id, false, true, spritesheet.getSubTile(1, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("67")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("68")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("69")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("70")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("71")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("72")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("73")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("74")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("75")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("76")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("77")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("78")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("79")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("80")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 4), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 6th row

        if (id.equals("81")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("82")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("83")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("84")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("85")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("86")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("87")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("88")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("89")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("90")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("91")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("92")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("93")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("94")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("95")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 5), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("96")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 5), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 7th row

        if (id.equals("97")) {

            for (Player player : this.gp.controllerManager.players) {

                if (player.playerNum == 1) {

                    player.x = x;
                    player.y = y;
                    player.speedX = 0;
                    player.speedY = 0;

                }

            }

        } if (id.equals("98")) {

            for (Player player : this.gp.controllerManager.players) {

                if (player.playerNum == 2) {

                    player.x = x;
                    player.y = y;
                    player.speedX = 0;
                    player.speedY = 0;

                }

            }

        } if (id.equals("99")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("100")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("101")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("102")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("103")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("104")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("105")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("106")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("107")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("108")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("109")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("110")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("111")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("112")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 6), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 8th row

        if (id.equals("113")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("114")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("115")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("116")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("117")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("118")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("119")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("120")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("121")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("122")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("123")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("124")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("125")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("126")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("127")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("128")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 7), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 9th row

        if (id.equals("129")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("130")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("131")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(2, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("132")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(3, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("133")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(4, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("134")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(5, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("135")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(6, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("136")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(7, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("137")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(8, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("138")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(9, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("139")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(10, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("140")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(11, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("141")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(12, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("142")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(13, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("143")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(14, 8), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("144")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(15, 8), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

    }



    public void getMapStr() {

        try {

            File file = new File("src/res/maps/tiledfiles/map" + "0-1" + ".txt");
            Scanner reader = new Scanner(file);
            String line = "amongus";
            boolean gotWidth = false;

            while (reader.hasNext()) {

                line = new String(reader.next());
                mapStr += line;
                mapHeight += 1;

                if (!gotWidth) {

                    String[] lineCounter = line.split(",");
                    mapWidth = lineCounter.length;
                    gotWidth = true;

                }

            }

            reader.close();

            // Remove 2 for border tiles space
            totalMapWidth = mapWidth * Settings.TILE_SIZE;
            totalMapHeight = mapHeight * Settings.TILE_SIZE;

            mapBoundsLeft = 0;
            mapBoundsRight = totalMapWidth;
            mapBoundsTop = 0;
            mapBoundsBottom = totalMapHeight;

        } catch (IOException e) {
            
            e.printStackTrace();

        }

    }



    public void parseMapData() {

        gp.controllerManager.createPlayers();

        for (int y = 0; y < mapHeight; y++) {
            
            for (int x = 0; x < mapWidth; x++) {
                
                mapPositionData.add(new int[] {x * Settings.TILE_SIZE, y * Settings.TILE_SIZE});

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

        if (Utils.inRange(ox, xBounds[0], xBounds[1]) || Utils.inRange(ox + ow, xBounds[0], xBounds[1])) {

            if (Utils.inRange(oy, yBounds[0], yBounds[1]) || Utils.inRange(oy + oh, yBounds[0], yBounds[1])) {

                return true;

            }

        }

        return false;

    }

}
