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

        }

        //#endregion

        // #region 3rd row

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

            // Player 1

            for (Player player : this.gp.controllerManager.players) {

                if (player.playerNum == 1) {

                    player.x = x;
                    player.y = y;
                    player.speedX = 0;
                    player.speedY = 0;

                }

            }

        } if (id.equals("42")) {

            // Player 2

            for (Player player : this.gp.controllerManager.players) {

                if (player.playerNum == 2) {

                    player.x = x;
                    player.y = y;
                    player.speedX = 0;
                    player.speedY = 0;

                }

            }

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

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(2, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("52")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(3, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("53")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(4, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("54")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(5, 3), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("55")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(6, 3), this.gp);
            this.allTiles.add(newTile);

        }

        // #endregion

        // #region 5th row

        if (id.equals("65")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(0, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("66")) {

            Tile newTile = new Tile(x, y, id, true, false, spritesheet.getSubTile(1, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("67")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(2, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("68")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(3, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("69")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(4, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("70")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(5, 4), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("71")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(6, 4), this.gp);
            this.allTiles.add(newTile);

        }

        //#endregion

        // #region 6th row

        if (id.equals("81")) {

            Tile newTile = new Tile(x, y, id, true, true, spritesheet.getSubTile(0, 5), this.gp);
            this.allTiles.add(newTile);
            this.allDangerousTiles.add(newTile);

        } if (id.equals("82")) {

            Tile newTile = new Tile(x, y, id, true, true, spritesheet.getSubTile(1, 5), this.gp);
            this.allTiles.add(newTile);
            this.allDangerousTiles.add(newTile);

        } if (id.equals("83")) {

            Tile newTile = new Tile(x, y, id, true, true, spritesheet.getSubTile(2, 5), this.gp);
            this.allTiles.add(newTile);
            this.allDangerousTiles.add(newTile);

        } if (id.equals("84")) {

            Tile newTile = new Tile(x, y, id, true, true, spritesheet.getSubTile(3, 5), this.gp);
            this.allTiles.add(newTile);
            this.allDangerousTiles.add(newTile);

        } if (id.equals("85")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(4, 5), this.gp);
            this.allTiles.add(newTile);
            this.allRopeTiles.add(newTile);

        }

        //#endregion

        // #region 7th row

        if (id.equals("97")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(0, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("98")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(1, 6), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("99")) {

            Tile newTile = new Tile(x, y, id, true, true, spritesheet.getSubTile(2, 6), this.gp);
            this.allTiles.add(newTile);
            this.allDangerousTiles.add(newTile);

        } if (id.equals("100")) {

            Tile newTile = new Tile(x, y, id, true, true, spritesheet.getSubTile(3, 6), this.gp);
            this.allTiles.add(newTile);
            this.allDangerousTiles.add(newTile);

        }

        //#endregion

        // #region 8th row

        if (id.equals("113")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(0, 7), this.gp);
            this.allTiles.add(newTile);

        } if (id.equals("114")) {

            Tile newTile = new Tile(x, y, id, false, false, spritesheet.getSubTile(1, 7), this.gp);
            this.allTiles.add(newTile);

        }

        //#endregion

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
