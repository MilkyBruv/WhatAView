package main;

public class Settings {

    // File settings
    public final String baseDir = System.getProperty("user.dir");

    // Screen settings
    public final int FPS = 60;

    final int baseTileSize = 8;
    public final int tileScale = 4;
    public final int TILESIZE = baseTileSize * tileScale; //? 32

    public final int TILEDWITDH = 32;
    public final int TILEDHEIGHT = 28;
    public final int SCREENWIDTH = TILEDWITDH * TILESIZE;   //? 256 (base size)
    public final int SCREENHEIGHT = TILEDHEIGHT * TILESIZE; //? 224 (base size)

    public final int SCROLLWAIT = 300000000 / 4 * 2;
    public float SCROLLSPEED = tileScale;

    public final int PARTICLEWAIT = 10000000;

    public final int SHAKEWAIT = 20000000;
    public final int SHAKEAMT = 5;

    public int PLAYERSPEED = 6;
    public int PLAYERJUMP = 16;
    public int PLAYERDOUBLEJUMP = 13;
    public float PLAYERGRAVITY = 1f;

}
