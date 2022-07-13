package main;

public class Settings {

    // File settings
    public final String baseDir = System.getProperty("user.dir");

    // Screen settings
    public final int FPS = 60;

    final int baseTileSize = 8;
    public final int TILE_SCALE = 4;
    public final int TILE_SIZE = baseTileSize * TILE_SCALE; //? 32

    public final int TILED_WIDTH = 32;
    public final int TILED_HEIGHT = 20;
    public final int SCREEN_WIDTH = TILED_WIDTH * TILE_SIZE;   //? 256 (base size)
    public final int SCREEN_HEIGHT = TILED_HEIGHT * TILE_SIZE; //? 224 (base size)

    public final int SCROLL_WAIT = 300000000;
    public float SCROLL_SPEED = TILE_SCALE;

    public final int PARTICLE_WAIT = 10000000;

    public final int SHAKE_WAIT = 20000000;
    public final int SHAKE_AMT = 3;

    public int PLAYER_SPEED = 5;
    public int PLAYER_JUMP = 10;
    public int PLAYER_DOUBLE_JUMP = 10;
    public float PLAYER_GRAVITY = 1f;
    public float PLAYER_MAX_FALL_SPEED = 10;

}
