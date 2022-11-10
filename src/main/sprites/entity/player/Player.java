package main.sprites.entity.player;

import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;
import main.controller.PlayerController;
import main.settings.Settings;
import main.sound.SoundPlayer;
import main.sprites.Tile;
import main.sprites.entity.Sprite;
import main.sprites.Spritesheet;

public class Player extends Sprite {
    
    public BufferedImage image;
    public BufferedImage[] projectileImages;
    public float speedX;
    public float speedY;
    public float speed;
    public float gravity;
    public int jump;
    public int doubleJump;
    public float maxFallSpeed;
    public float acc;
    public float friction;

    public int playerNum;

    private Spritesheet spritesheet = new Spritesheet();
    private PlayerController controller;
    private GamePanel gp;
    

    public boolean hasShotDown;

    private boolean hasPressedX;
    private boolean hasPressedSquare;
    private boolean hasPressedOptions;
    private boolean hasPressedCircle;

    private boolean hasMovedContY;

    public boolean collidedTop;
    public boolean collidedBottom;
    public boolean collidedLeft;
    public boolean collidedRight;

    public boolean facingUp;
    public boolean facingDown;
    public boolean facingLeft;
    public boolean facingRight;

    public boolean idle;
    public boolean onGround;
    public boolean isShooting;
    public boolean collidesWithPlatforms;
    public boolean collidesWithRopes;
    public boolean onRope;

    public List<Boolean> ropeCollisions;
    public int ropeRectX;

    public boolean dead;

    public String lastXDir;

    public Rectangle rect;
    public Rectangle platformRect;
    public Rectangle ropeRect;

    // #region Images

    BufferedImage running1ImageLeft;
    BufferedImage running2ImageLeft;
    BufferedImage running3ImageLeft;
    BufferedImage running1ImageRight;
    BufferedImage running2ImageRight;
    BufferedImage running3ImageRight;
    BufferedImage jumpingImageLeft;
    BufferedImage jumpingImageRight;
    BufferedImage fallingImageLeft;
    BufferedImage fallingImageRight;
    BufferedImage shootingImageLeft;
    BufferedImage shootingImageRight;
    BufferedImage idleImageLeft;
    BufferedImage idleImageRight;
    BufferedImage deadImage;

    BufferedImage[] runningImagesLeft;
    BufferedImage[] runningImagesRight;

    // #endregion

    public List<PlayerProjectile> projectiles;

    public Player(int x, int y, BufferedImage[] projectileImages, PlayerController controller, int playerNum, GamePanel gp) {

        super(gp);

        this.gp = gp;

        this.x = x;
        this.y = y;
        this.drawX = this.x;
        this.drawY = this.y;
        this.width = Settings.TILE_SIZE;
        this.height = Settings.TILE_SIZE;
        this.scrollDiff = 0;
        this.projectileImages = projectileImages;
        this.speedX = 0f;
        this.speedY = 0f;
        this.speed = Settings.PLAYER_SPEED;
        this.acc = Settings.PLAYER_ACCELERATION;
        this.friction = Settings.PLAYER_FRICTION;

        this.gravity = Settings.PLAYER_GRAVITY;
        this.jump = Settings.PLAYER_JUMP;
        this.doubleJump = Settings.PLAYER_DOUBLE_JUMP;
        this.maxFallSpeed = Settings.PLAYER_MAX_FALL_SPEED;
        
        this.dead = false;

        this.playerNum = playerNum;

        this.hasShotDown = false;
        this.hasPressedX = false;
        this.hasPressedCircle = false;
        this.hasPressedSquare = false;
        this.hasPressedOptions = false;

        this.hasMovedContY = false;

        this.collidedTop = false;
        this.collidedBottom = false;
        this.collidedLeft = false;
        this.collidedRight = false;

        this.facingUp = false;
        this.facingDown = false;
        this.facingLeft = false;
        this.facingRight = true;

        this.idle = true;
        this.onGround = false;
        this.isShooting = false;
        this.collidesWithPlatforms = true;
        this.collidesWithRopes = true;
        this.onRope = false;
        this.ropeCollisions = new ArrayList<Boolean>() {};
        this.ropeRectX = 0;

        this.lastXDir = "right";

        this.projectiles = new ArrayList<PlayerProjectile>() {};

        this.controller = controller;

        this.rect = new Rectangle();
        this.rect.x = this.x + 1;
        this.rect.y = this.y + 1;
        this.rect.width = Settings.TILE_SIZE - 2;
        this.rect.height = Settings.TILE_SIZE - 2;

        this.platformRect = new Rectangle();
        this.platformRect.x = this.x;
        this.platformRect.y = this.y + Settings.TILE_SIZE;
        this.platformRect.width = Settings.TILE_SIZE;
        this.platformRect.height = Settings.TILE_SIZE / 4;

        this.ropeRect = new Rectangle();
        this.ropeRect.x = this.x + 3 * Settings.TILE_SCALE;
        this.ropeRect.y = this.y;
        this.ropeRect.width = 2 * Settings.TILE_SCALE;
        this.ropeRect.height = Settings.TILE_SIZE;

        // #region Images init

        this.running1ImageLeft = spritesheet.getSubImage(  96 - (-40 + (40 * this.playerNum)), 136,    8, 8);
        this.running2ImageLeft = spritesheet.getSubImage(  96 - (-40 + (40 * this.playerNum)), 144,    8, 8);
        this.running3ImageLeft = spritesheet.getSubImage(  96 - (-40 + (40 * this.playerNum)), 152,    8, 8);
        this.running1ImageRight = spritesheet.getSubImage(104 - (-40 + (40 * this.playerNum)), 136,    8, 8);
        this.running2ImageRight = spritesheet.getSubImage(104 - (-40 + (40 * this.playerNum)), 144,    8, 8);
        this.running3ImageRight = spritesheet.getSubImage(104 - (-40 + (40 * this.playerNum)), 152,    8, 8);
        this.jumpingImageLeft = spritesheet.getSubImage(   96 - (-40 + (40 * this.playerNum)), 184,    8, 8);
        this.jumpingImageRight = spritesheet.getSubImage( 104 - (-40 + (40 * this.playerNum)), 184,    8, 8);
        this.fallingImageLeft = spritesheet.getSubImage(   96 - (-40 + (40 * this.playerNum)), 168,    8, 8);
        this.fallingImageRight = spritesheet.getSubImage( 104 - (-40 + (40 * this.playerNum)), 168,    8, 8);
        this.shootingImageLeft = spritesheet.getSubImage(  80 - (-40 + (40 * this.playerNum)), 136,    8, 8);
        this.shootingImageRight = spritesheet.getSubImage( 88 - (-40 + (40 * this.playerNum)), 136,    8, 8);
        this.idleImageLeft = spritesheet.getSubImage(      96 - (-40 + (40 * this.playerNum)), 136,    8, 8);
        this.idleImageRight = spritesheet.getSubImage(    104 - (-40 + (40 * this.playerNum)), 136,    8, 8);
        this.deadImage = spritesheet.getSubImage(         0,                                   16 * 8, 8, 8);

        this.runningImagesLeft = new BufferedImage[] {

            this.running1ImageLeft,
            this.running2ImageLeft,
            this.running1ImageLeft,
            this.running3ImageLeft

        };

        this.runningImagesRight = new BufferedImage[] {

            this.running1ImageRight,
            this.running2ImageRight,
            this.running1ImageRight,
            this.running3ImageRight

        };

        // #endregion

        this.image = this.idleImageRight;

    }



    public void getKeyboardInputX() {

        int pos = this.rect.x;
        this.acc = 0;

        if (gp.keyHandler.leftPressed) {

            if (!this.collidedLeft) {

                this.acc = -this.speed;

            }

            this.facingUp = false;
            this.facingDown = false;
            this.facingLeft = true;
            this.facingRight = false;
            this.lastXDir = "left";

            this.idle = false;

            // Animate player if on ground
            if (this.onGround && !this.isShooting) {

                int frame = (Math.round(pos / 50f)) % this.runningImagesLeft.length;
                this.image = this.runningImagesLeft[frame];

            }

        } else if (gp.keyHandler.rightPressed) {

            if (!this.collidedRight) {

                this.acc = this.speed;

            }

            this.facingUp = false;
            this.facingDown = false;
            this.facingLeft = false;
            this.facingRight = true;
            this.lastXDir = "right";

            this.idle = false;

            // Animate player if on ground
            if (this.onGround && !this.isShooting) {

                int frame = (Math.round(pos / 50f)) % this.runningImagesRight.length;
                this.image = this.runningImagesRight[frame];

            }

        }

        if (!gp.keyHandler.leftPressed && !gp.keyHandler.rightPressed) {

            this.speedX = 0;
            this.idle = true;

            if (this.lastXDir.equals("left") && this.onGround) {

                this.image = this.idleImageLeft;

            }

            if (this.lastXDir.equals("right") && this.onGround) {

                this.image = this.idleImageRight;

            }

        }

    }



    public void getKeyboardInputY() {

        if (gp.keyHandler.upPressed) {

            this.facingUp = true;
            this.facingDown = false;
            this.facingLeft = false;
            this.facingRight = false;

        } else if (gp.keyHandler.downPressed) {

            this.facingUp = false;
            this.facingDown = true;
            this.facingLeft = false;
            this.facingRight = false;

            this.collidesWithPlatforms = false;

        }

        if (!gp.keyHandler.downPressed) {

            this.collidesWithPlatforms = true;

        }

    }



    public void getKeyboardInputYOptions() {

        if (gp.keyHandler.downPressed && !this.hasMovedContY) {

            if (gp.menuManager.currentMenu.currentSelection < gp.menuManager.currentMenu.itemCount - 1) {

                gp.menuManager.currentMenu.currentSelection++;

            }

            if (gp.menuManager.currentMenu.currentSelection == 0) {

                gp.menuManager.currentMenu.currentSelection = gp.menuManager.currentMenu.itemCount - 1;

            }

            this.hasMovedContY = true;

        } else if (gp.keyHandler.upPressed && !this.hasMovedContY) {

            if (gp.menuManager.currentMenu.currentSelection > 0) {

                gp.menuManager.currentMenu.currentSelection--;

            }

            if (gp.menuManager.currentMenu.currentSelection == gp.menuManager.currentMenu.itemCount - 1) {

                gp.menuManager.currentMenu.currentSelection = 0;

            }

            this.hasMovedContY = true;

        }

        if (!gp.keyHandler.downPressed && !gp.keyHandler.upPressed && this.hasMovedContY) {

            this.hasMovedContY = false;

        }

    }



    public void getKeyboardInputShoot() {

        if (gp.keyHandler.shootPressed && !this.hasPressedSquare) {

            this.isShooting = true;

            if (this.facingDown) {

                if (!this.hasShotDown && !this.onGround) { 
                    
                    this.speedY = -this.doubleJump;
                    this.createProjectile();

                }

                this.hasShotDown = true;
                this.gp.screenShake.shake();

            } if (!this.facingDown) {

                this.createProjectile();
                this.gp.screenShake.shake();

            }

            this.hasPressedSquare = true;

        }

        if (!gp.keyHandler.shootPressed && this.hasPressedSquare) {

            this.isShooting = false;
            this.hasPressedSquare = false;

        }

    }



    public void getKeyboardInputJump() {

        if (gp.keyHandler.jumpPressed && !this.hasPressedX) {

            if (this.onGround) {

                this.speedY = -this.jump;
                this.onGround = false;
                this.hasPressedX = true;

            }

            else if (!this.hasShotDown && !this.onGround && !this.onRope) { 
                    
                this.speedY = -this.doubleJump;
                this.facingUp = false;
                this.facingDown = true;
                this.facingLeft = false;
                this.facingRight = false;
                this.createProjectile();
                this.hasShotDown = true;
                this.gp.screenShake.shake();

            }

        }

        if (!gp.keyHandler.jumpPressed && this.hasPressedX) {

            this.hasPressedX = false;

        }

    }



    public void getKeyboardInputSelect() {

        if (gp.keyHandler.jumpPressed && !this.hasPressedX) {

            gp.menuManager.currentMenu.excecuteItem();
            this.hasPressedX = true;

        }

        if (!gp.keyHandler.jumpPressed && this.hasPressedX) {

            this.hasPressedX = false;

        }

    }



    public void getKeyboardInputEscape() {

        if (gp.keyHandler.escPressed && !this.hasPressedOptions) {

            if (this.playerNum == 1) {

                if (!gp.menuManager.inMenu && !gp.menuManager.inSubMenu) {

                    gp.menuManager.inMenu = true;
                    gp.menuManager.currentMenu = gp.menuManager.pauseMenu;

                } else if (gp.menuManager.inMenu) {

                    gp.menuManager.inMenu = false;
                    gp.menuManager.inSubMenu = false;
    
                } else if (gp.menuManager.inSubMenu) {
    
                    gp.menuManager.inSubMenu = false;
                    gp.menuManager.inMenu = true;
    
                }

                this.hasPressedOptions = true;

            }

        }

        if (!gp.keyHandler.escPressed && this.hasPressedOptions) {

            this.hasPressedOptions = false;

        }

    }



    public void getOptionsButtonInput() {

        if (this.controller.isButtonPressed("options") && !this.hasPressedOptions) {

            if (this.playerNum == 1) {

                if (!gp.menuManager.inMenu && !gp.menuManager.inSubMenu) {

                    gp.menuManager.inMenu = true;
                    gp.menuManager.currentMenu = gp.menuManager.pauseMenu;

                } else if (gp.menuManager.inMenu) {

                    gp.menuManager.inMenu = false;
                    gp.menuManager.inSubMenu = false;
    
                } else if (gp.menuManager.inSubMenu) {
    
                    gp.menuManager.inSubMenu = false;
                    gp.menuManager.inMenu = true;
    
                }

                this.hasPressedOptions = true;

            }

        }

        if (!this.controller.isButtonPressed("options") && this.hasPressedOptions) {

            this.hasPressedOptions = false;

        }

    }



    public void getCircleButtonInput() {

        if (this.controller.isButtonPressed("circle") && !this.hasPressedCircle) {

            if (gp.menuManager.inMenu) {

                gp.menuManager.inMenu = false;
                gp.menuManager.inSubMenu = false;

            }

            if (gp.menuManager.inSubMenu) {

                gp.menuManager.inSubMenu = false;
                gp.menuManager.inMenu = true;

            }

        }

    }


    
    public void getXButtonInput() {

        if (this.controller.isButtonPressed("x") && !this.hasPressedX) {

            if (this.onGround) {

                this.speedY = -this.jump;
                this.onGround = false;
                this.hasPressedX = true;

            }

            if (!this.hasShotDown && !this.onGround && !this.onRope) { 
                    
                this.speedY = -this.doubleJump;
                this.facingUp = false;
                this.facingDown = true;
                this.facingLeft = false;
                this.facingRight = false;
                this.createProjectile();
                this.hasShotDown = true;
                this.gp.screenShake.shake();

            }

        }

        if (!this.controller.isButtonPressed("x") && this.hasPressedX) {

            this.hasPressedX = false;

        }

    }



    public void getXButtonInputOptions() {

        if (this.controller.isButtonPressed("x") && !this.hasPressedX) {

            gp.menuManager.currentMenu.excecuteItem();
            this.hasPressedX = true;

        }

        if (!this.controller.isButtonPressed("x") && this.hasPressedX) {

            this.hasPressedX = false;

        }

    }



    public void getTriangleButtonInput() {

        if (this.controller.isButtonPressed("triangle")) {

            this.gp.screenShake.shake();

        }

    }



    public void getSquareButtonInput() {

        if (this.controller.isButtonPressed("square") && !this.hasPressedSquare) {

            this.isShooting = true;

            if (this.facingDown) {

                if (!this.hasShotDown && !this.onGround) { 
                    
                    this.speedY = -this.doubleJump;
                    this.createProjectile();

                }

                this.hasShotDown = true;
                this.gp.screenShake.shake();

            } if (!this.facingDown) {

                this.createProjectile();
                this.gp.screenShake.shake();

            }

            this.hasPressedSquare = true;

        }

        if (!this.controller.isButtonPressed("square") && this.hasPressedSquare) {

            this.isShooting = false;
            this.hasPressedSquare = false;

        }

    }



    public void getContInputX() {

        int pos = this.rect.x;
        this.acc = 0;

        if (this.controller.isAxisMoved("left")) {

            if (!this.collidedLeft) {

                this.acc = -this.speed;

            }

            this.facingUp = false;
            this.facingDown = false;
            this.facingLeft = true;
            this.facingRight = false;
            this.lastXDir = "left";

            this.idle = false;

            // Animate player if on ground
            if (this.onGround && !this.isShooting) {

                int frame = (Math.round(pos / 50f)) % this.runningImagesLeft.length;
                this.image = this.runningImagesLeft[frame];

            }

        } else if (this.controller.isAxisMoved("right")) {

            if (!this.collidedRight) {

                this.acc = this.speed;

            }

            this.facingUp = false;
            this.facingDown = false;
            this.facingLeft = false;
            this.facingRight = true;
            this.lastXDir = "right";

            this.idle = false;

            // Animate player if on ground
            if (this.onGround && !this.isShooting) {

                int frame = (Math.round(pos / 50f)) % this.runningImagesRight.length;
                this.image = this.runningImagesRight[frame];

            }

        }

        if (!this.controller.isAxisMoved("left") && !this.controller.isAxisMoved("right")) {

            this.speedX = 0;
            this.idle = true;

            if (this.lastXDir.equals("left") && this.onGround) {

                this.image = this.idleImageLeft;

            }

            if (this.lastXDir.equals("right") && this.onGround) {

                this.image = this.idleImageRight;

            }

        }

    }



    public void getContInputYOptions() {

        if (this.controller.isAxisMoved("down") && !this.hasMovedContY) {

            if (gp.menuManager.currentMenu.currentSelection < gp.menuManager.currentMenu.itemCount - 1) {

                gp.menuManager.currentMenu.currentSelection++;

            }

            if (gp.menuManager.currentMenu.currentSelection == 0) {

                gp.menuManager.currentMenu.currentSelection = gp.menuManager.currentMenu.itemCount - 1;

            }

            this.hasMovedContY = true;

        } else if (this.controller.isAxisMoved("up") && !this.hasMovedContY) {

            if (gp.menuManager.currentMenu.currentSelection > 0) {

                gp.menuManager.currentMenu.currentSelection--;

            }

            if (gp.menuManager.currentMenu.currentSelection == gp.menuManager.currentMenu.itemCount - 1) {

                gp.menuManager.currentMenu.currentSelection = 0;

            }

            this.hasMovedContY = true;

        }

        if (!this.controller.isAxisMoved("down") && !this.controller.isAxisMoved("up") && this.hasMovedContY) {

            this.hasMovedContY = false;

        }

    }



    public void getContInputY() {

        if (this.controller.isAxisMoved("up")) {

            this.facingUp = true;
            this.facingDown = false;
            this.facingLeft = false;
            this.facingRight = false;

        } else if (this.controller.isAxisMoved("down")) {

            this.facingUp = false;
            this.facingDown = true;
            this.facingLeft = false;
            this.facingRight = false;

        } if (this.controller.isAxisMoved("down", 0.99f)) {

            this.facingUp = false;
            this.facingDown = true;
            this.facingLeft = false;
            this.facingRight = false;

            this.collidesWithPlatforms = false;

        }

        if (!this.controller.isAxisMoved("down")) {

            this.collidesWithPlatforms = true;

        }

    }



    public void setIndividualImages() {
        
        if (!this.dead) {

            if (this.lastXDir.equals("left")) {

                if (!this.onGround && !this.isShooting) {

                    if (this.speedY > 0) {

                        this.image = this.fallingImageLeft;

                    } 
                    
                    if (this.speedY < 0) {

                        this.image = this.jumpingImageLeft;

                    }

                }

                if (this.onGround && this.idle && !this.isShooting) {

                    this.image = this.idleImageLeft;

                }

                if (this.isShooting) {

                    this.image = this.shootingImageLeft;

                }

            }

            if (this.lastXDir.equals("right")) {

                if (!this.onGround && !this.isShooting) {

                    if (this.speedY > 0) {

                        this.image = this.fallingImageRight;

                    } 
                    
                    if (this.speedY < 0) {

                        this.image = this.jumpingImageRight;

                    }

                }

                if (this.onGround && this.idle && !this.isShooting) {

                    this.image = this.idleImageRight;

                }

                if (this.isShooting) {

                    this.image = this.shootingImageRight;

                }

            }

        }

        if (this.dead) {

            this.image = this.deadImage;

        }

    }



    public void detectCollisions(String dir) {

        if (dir.equals("x")) {

            for (Tile tile : gp.spriteManager.allTiles) {

                if (!tile.id.equals("60") && tile.solid && this.rect.intersects(tile.rect)) {

                    if (this.speedX < 0) {

                        this.x = tile.x + Settings.TILE_SIZE;
                        this.collidedLeft = true;

                    }

                    if (this.speedX > 0) {

                        this.x = tile.x - Settings.TILE_SIZE;
                        this.collidedRight = true;

                    }

                    this.rect.x = this.x;
                    this.rect.width = Settings.TILE_SIZE;

                } else {

                    this.collidedLeft = false;
                    this.collidedRight = false;

                }

            }

        }

        if (dir.equals("y")) {

            for (Tile tile : gp.spriteManager.allTiles) {

                if (!tile.id.equals("60") && tile.solid && this.rect.intersects(tile.rect)) {

                    if (this.speedY < 0) {

                        this.y = tile.y + Settings.TILE_SIZE;
                        this.collidedTop = true;

                    }

                    if (this.speedY > 0) {

                        this.y = tile.y - Settings.TILE_SIZE;
                        this.collidedBottom = true;
                        this.onGround = true;
                        this.hasShotDown = false;

                    }

                    this.speedY = 0;
                    this.rect.y = this.y;
                    this.rect.height = Settings.TILE_SIZE;

                }

            }

        }

    }



    public void detectPlatformCollisions() {

        if (this.collidesWithPlatforms) {

            for (Tile tile : gp.spriteManager.allPlatformTiles) {

                this.platformRect.x = this.x;
                this.platformRect.y = this.y + Settings.TILE_SIZE;
                this.platformRect.width = Settings.TILE_SIZE;
                this.platformRect.height = Settings.TILE_SIZE / 4;

                if (this.platformRect.intersects(tile.rect)) {

                    if (this.speedY > 0) {

                        this.y = tile.y - Settings.TILE_SIZE - 1;
                        this.onGround = true;
                        this.hasShotDown = false;
                        this.collidedBottom = true;

                        this.speedY = 0;
                        this.platformRect.x = this.x;
                        this.platformRect.y = this.y + Settings.TILE_SIZE;
                        this.platformRect.width = Settings.TILE_SIZE;
                        this.platformRect.height = Settings.TILE_SIZE / 4;

                    }

                }

            }

        }

    }



    public void detectRopeJump() {

        if (this.onRope) {

            if (gp.PLAYMODE.equals("c")) {

                if (this.controller.isButtonPressed("x")) {

                    this.collidesWithRopes = false;
                    this.onRope = false;

                    if (this.lastXDir.equals("left")) {

                        this.speedY = -this.jump;
                        this.speedX = -this.speed;

                    }

                    if (this.lastXDir.equals("right")) {

                        this.speedY = -this.jump;
                        this.speedX = this.speed;

                    }

                }

            }

            if (gp.PLAYMODE.equals("k")) {

                if (gp.keyHandler.jumpPressed) {

                    this.collidesWithRopes = false;
                    this.onRope = false;

                    if (gp.keyHandler.leftPressed) {

                        this.speedY = -this.jump;
                        this.speedX = -this.speed;

                    }

                    if (gp.keyHandler.rightPressed) {

                        this.speedY = -this.jump;
                        this.speedX = this.speed;

                    }

                }

            }

        }

    }



    public void detectRopeCollisions() {

        for (Tile tile : gp.spriteManager.allRopeTiles) {

            this.ropeRect.x = this.x + 3 * Settings.TILE_SCALE;
            this.ropeRect.y = this.y;
            this.ropeRect.width = 2 * Settings.TILE_SCALE;
            this.ropeRect.height = Settings.TILE_SIZE;

            if (this.ropeRect.intersects(tile.rect) && this.collidesWithRopes) {

                this.ropeRectX = tile.rect.x - 3 * Settings.TILE_SCALE;
                this.ropeCollisions.add(true);

            } else {

                this.ropeCollisions.add(false);

            }

        }

        if (this.ropeCollisions.contains(true)) {

            this.onRope = true;

        } else {

            this.onRope = false;
            this.collidesWithRopes = true;

        }

        this.ropeCollisions.clear();

    }



    public void moveOnRope() {

        if (this.onRope) {

            if (gp.PLAYMODE.equals("c")) {

                if (this.controller.isAxisMoved("up")) {

                    this.x = this.ropeRectX;
                    this.speedY = -this.speed / 2;

                } if (this.controller.isAxisMoved("down")) {

                    this.x = this.ropeRectX;
                    this.speedY = this.speed / 2;

                }

                if (!this.controller.isAxisMoved("up") && !this.controller.isAxisMoved("down")) {

                    this.x = this.ropeRectX;
                    this.speedY = 0;

                }

            }

            if (gp.PLAYMODE.equals("k")) {

                if (gp.keyHandler.upPressed) {

                    this.x = this.ropeRectX;
                    this.speedY = -this.speed / 2;

                } if (gp.keyHandler.downPressed) {

                    this.x = this.ropeRectX;
                    this.speedY = this.speed / 2;

                }

                if (!gp.keyHandler.upPressed && !gp.keyHandler.downPressed) {

                    this.x = this.ropeRectX;
                    this.speedY = 0;

                }

            }

        }

    }



    public void detectDangerousCollisions() {

        for (Tile tile : gp.spriteManager.allTiles) {

            if (tile.dangerous) {

                if (this.rect.intersects(tile.rect)) {

                    this.kill();

                }

            }

        }

    }



    public void createProjectile() {

        this.projectiles.add(new PlayerProjectile(
            
            new boolean[] {this.facingUp, this.facingDown, this.facingLeft, this.facingRight}, 
            this.playerNum,
            this.x,
            this.y,
            this.projectileImages,
            gp
        
        ));

        int min = 1;
        int max = 2;
        int num = (int) Math.floor(Math.random() * (min - max + 1) + min);
        SoundPlayer.playEffect("shoot" + num);

    }



    public void updateProjectiles() {

        for (PlayerProjectile proj : this.projectiles) {

            proj.update();

        }

    }



    public void limitScrolling() {

        if (gp.spriteManager.lockedLeft) {

            this.drawX = this.x;

        } else if (gp.spriteManager.lockedRight) {

            this.drawX = this.x - gp.spriteManager.totalMapWidth / 2;

        } else {

            this.drawX = (Settings.SCREEN_WIDTH / 2) - (this.width / 2);

        }

        if (gp.spriteManager.lockedTop) {

            this.drawY = this.y;

        } else if (gp.spriteManager.lockedBottom) {

            this.drawY = this.y - gp.spriteManager.totalMapHeight / 2;

        } else {

            this.drawY = (Settings.SCREEN_HEIGHT / 2) - (this.height / 2);

        }

    }

    

    public void kill() {

        this.dead = true;

    }



    public void update() {

        this.limitScrolling();

        if (!gp.menuManager.inMenu && !gp.menuManager.inSubMenu) {

            // Controller input
            if (!this.dead) {

                if (gp.PLAYMODE.equals("c")) {

                    this.getContInputY();
                    this.getContInputX();
                    this.getXButtonInput();
                    this.getTriangleButtonInput();
                    this.getSquareButtonInput();

                }

                if (gp.PLAYMODE.equals("k")) {

                    this.getKeyboardInputX();
                    this.getKeyboardInputY();
                    this.getKeyboardInputShoot();
                    this.getKeyboardInputJump();

                }

                this.detectRopeCollisions();
                this.moveOnRope();
                this.detectRopeJump();
                this.detectDangerousCollisions();

            }

            // Images
            this.setIndividualImages();

            // Update other instances / classes
            this.updateProjectiles();
            this.gp.screenShake.update();

            // Apply gravity & speed
            if (!this.dead) {

                if (!this.onRope) {

                    this.speedY += this.gravity;
                    float preAdd = this.speedY + (this.gravity * 0.5f);
                    if (preAdd > this.maxFallSpeed) { preAdd = this.maxFallSpeed; }
                    this.speedY = preAdd;
                    this.y += this.speedY;

                }

                if (this.onRope) {
                    
                    this.y += this.speedY;

                }

                // Calculate X physics
                this.acc += this.speedX * Settings.PLAYER_FRICTION;
                this.speedX += this.acc;
                double preAdd = this.speedX + 0.5 * this.acc;

                if (preAdd > 6) {

                    preAdd = 6;

                } else if (preAdd < -6) {

                    preAdd = -6;

                }
                this.speedX = (int) preAdd;

                this.x += speedX;

                // Round pos to nearest scaled pixel
                this.drawX = Settings.TILE_SCALE * (Math.round(this.drawX / Settings.TILE_SCALE));
                this.y = Settings.TILE_SCALE * (Math.round(this.y / Settings.TILE_SCALE));

                // Collisions
                // Main rect
                this.rect.x = this.x + 1;
                this.rect.width = Settings.TILE_SIZE - 2;

                this.detectCollisions("x");

                // Main rect
                this.rect.y = this.y + 1;
                this.rect.height = Settings.TILE_SIZE - 2;

                // Platform rect
                this.platformRect.x = this.x;
                this.platformRect.y = this.y + Settings.TILE_SIZE;
                this.platformRect.width = Settings.TILE_SIZE;
                this.platformRect.height = Settings.TILE_SIZE / 4;

                this.detectCollisions("y");
                this.detectPlatformCollisions();

            }

        }

        if (gp.PLAYMODE.equals("c")) {

            this.getOptionsButtonInput();
            this.getCircleButtonInput();

            if (gp.menuManager.inMenu || gp.menuManager.inSubMenu) {

                this.getContInputYOptions();
                this.getXButtonInputOptions();

            }

        }

        if (gp.PLAYMODE.equals("k")) {

            this.getKeyboardInputEscape();

            if (gp.menuManager.inMenu || gp.menuManager.inSubMenu) {

                this.getKeyboardInputEscape();
                this.getKeyboardInputSelect();
                this.getKeyboardInputYOptions();

            }

        }

    }



    public void draw(Graphics2D g2) {

        g2.drawImage(this.image, this.drawX, this.drawY, Settings.TILE_SIZE, Settings.TILE_SIZE, null);

        if (gp.controllerManager.playerCount == 2) {

            spritesheet.drawTextNoBG(g2, "P" + this.playerNum, this.drawX - Settings.TILE_SIZE / 2, this.drawY - Settings.TILE_SIZE, new String[] {"custom", "custom"});

        }

        for (PlayerProjectile proj : this.projectiles) {

            if (!proj.collided) {

                g2.drawImage(proj.image, proj.drawX, proj.drawY + this.scrollDiff, proj.width, proj.height, null);

            }

        }

    }

}
