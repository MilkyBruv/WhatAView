package main.settings;

public class Settings {

    // File settings
    public static final String baseDir = System.getProperty("user.dir");

    // Screen settings
    public static final int FPS = 60;

    public static final int baseTileSize = 8;
    public static final int TILE_SCALE = 4;
    public static final int TILE_SIZE = baseTileSize * TILE_SCALE; //? 32

    public static final int TILED_WIDTH = 32;
    public static final int TILED_HEIGHT = 20;
    public static final int SCREEN_WIDTH = TILED_WIDTH * TILE_SIZE;   //? 256 (base size)
    public static final int SCREEN_HEIGHT = TILED_HEIGHT * TILE_SIZE; //? 224 (base size)

    public static final int SCROLL_WAIT = 300000000;
    public static float SCROLL_SPEED = TILE_SCALE;

    public static final int PARTICLE_WAIT = 10000000;

    public static final int SHAKE_WAIT = 20000000;
    public static final int SHAKE_AMT = 3;

    public static int PLAYER_SPEED = 2 * TILE_SCALE;
    public static int PLAYER_JUMP = 14;
    public static int PLAYER_DOUBLE_JUMP = 12;
    public static float PLAYER_GRAVITY = 0.725f;
    public static float PLAYER_MAX_FALL_SPEED = 14;
    public static float PLAYER_ACCELERATION = 0.005f;
    public static float PLAYER_FRICTION = -0.002f;

}
