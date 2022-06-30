package main.sprites.entity;

import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;
import main.Settings;
import main.controller.PlayerController;
import main.sprites.Tile;
import main.sprites.particle.Particle;
import main.sprites.Spritesheet;

public class Player extends Sprite {
    
    public BufferedImage image;
    public BufferedImage[] projectileImages;
    public int speedX;
    public int speedY;
    public int speed;
    public float gravity;
    public int jump;
    public int doubleJump;

    public int playerNum;

    private Spritesheet spritesheet = new Spritesheet();
    private PlayerController controller;
    private GamePanel gp;
    private Settings settings = new Settings();

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

    private Particle landParticle;
    private Particle jumpParticle;

    public List<PlayerProjectile> projectiles;

    public Player(int x, int y, BufferedImage[] projectileImages, PlayerController controller, int playerNum, GamePanel gp) {

        super(gp);

        this.gp = gp;

        this.x = x;
        this.y = y;
        this.drawX = this.x;
        this.drawY = this.y;
        this.width = settings.TILESIZE;
        this.height = settings.TILESIZE;
        this.scrollDiff = 0;
        this.projectileImages = projectileImages;
        this.speedX = 0;
        this.speedY = 0;
        this.speed = settings.PLAYERSPEED;

        this.gravity = settings.PLAYERGRAVITY;
        this.jump = settings.PLAYERJUMP;
        this.doubleJump = settings.PLAYERDOUBLEJUMP;
        
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
        this.rect.width = settings.TILESIZE - 2;
        this.rect.height = settings.TILESIZE - 2;

        this.platformRect = new Rectangle();
        this.platformRect.x = this.x;
        this.platformRect.y = this.y + settings.TILESIZE;
        this.platformRect.width = settings.TILESIZE;
        this.platformRect.height = settings.TILESIZE / 4;

        this.ropeRect = new Rectangle();
        this.ropeRect.x = this.x + 3 * settings.tileScale;
        this.ropeRect.y = this.y;
        this.ropeRect.width = 2 * settings.tileScale;
        this.ropeRect.height = settings.TILESIZE;

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

        // Create Particles
        this.landParticle = new Particle(this, "land", gp);
        this.jumpParticle = new Particle(this, "jump", gp);

    }



    public void getKeyboardInputX() {

        int pos = this.rect.x;

        if (gp.keyHandler.leftPressed) {

            if (!this.collidedLeft) {

                this.speedX = -this.speed;

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

                this.speedX = this.speed;

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

                this.jumpParticle.create();

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

            if (this.onGround || this.onRope) {

                this.speedY = -this.jump;
                this.onGround = false;
                this.hasPressedX = true;

                this.jumpParticle.create();

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

        if (this.controller.isAxisMoved("left")) {

            if (!this.collidedLeft) {

                this.speedX = -this.speed;

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

                this.speedX = this.speed;

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

                if (!tile.id.equals("65") && tile.solid && this.rect.intersects(tile.rect)) {

                    if (this.speedX < 0) {

                        this.x = tile.x + settings.TILESIZE;
                        this.collidedLeft = true;

                    }

                    if (this.speedX > 0) {

                        this.x = tile.x - settings.TILESIZE;
                        this.collidedRight = true;

                    }

                    this.rect.x = this.x;
                    this.rect.width = settings.TILESIZE;

                } else {

                    this.collidedLeft = false;
                    this.collidedRight = false;

                }

            }

        }

        if (dir.equals("y")) {

            for (Tile tile : gp.spriteManager.allTiles) {

                if (!tile.id.equals("65") && tile.solid && this.rect.intersects(tile.rect)) {

                    if (this.speedY < 0) {

                        this.y = tile.y + settings.TILESIZE;
                        this.collidedTop = true;

                    }

                    if (this.speedY > 0) {

                        this.y = tile.y - settings.TILESIZE;
                        this.collidedBottom = true;
                        this.onGround = true;
                        this.hasShotDown = false;

                    }

                    this.speedY = 0;
                    this.rect.y = this.y;
                    this.rect.height = settings.TILESIZE;

                }

            }

        }

    }



    public void detectPlatformCollisions() {

        if (this.collidesWithPlatforms) {

            for (Tile tile : gp.spriteManager.allTiles) {

                this.platformRect.x = this.x;
                this.platformRect.y = this.y + settings.TILESIZE;
                this.platformRect.width = settings.TILESIZE;
                this.platformRect.height = settings.TILESIZE / 4;

                if (tile.id.equals("65") && this.platformRect.intersects(tile.rect)) {

                    if (this.speedY > 0) {

                        this.y = tile.y - settings.TILESIZE - 1;
                        this.onGround = true;
                        this.hasShotDown = false;
                        this.collidedBottom = true;

                        this.speedY = 0;
                        this.platformRect.x = this.x;
                        this.platformRect.y = this.y + settings.TILESIZE;
                        this.platformRect.width = settings.TILESIZE;
                        this.platformRect.height = settings.TILESIZE / 4;

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

            this.ropeRect.x = this.x + 3 * settings.tileScale;
            this.ropeRect.y = this.y;
            this.ropeRect.width = 2 * settings.tileScale;
            this.ropeRect.height = settings.TILESIZE;

            if (tile.id.equals("85") && this.ropeRect.intersects(tile.rect) && this.collidesWithRopes) {

                this.ropeRectX = tile.rect.x - 3 * settings.tileScale;
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

        for (Tile tile : gp.spriteManager.allDangerousTiles) {

            if (this.rect.intersects(tile.rect)) {

                this.kill();

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

    }



    public void updateProjectiles() {

        for (PlayerProjectile proj : this.projectiles) {

            proj.update();

        }

    }



    public void updateParticles() {

        this.landParticle.update();
        this.jumpParticle.update();

    }



    public void applyScroll() {

        long now = System.nanoTime();

        if (now - this.lastUpdate > this.gp.scrollWait) {

            this.lastUpdate = now;

            this.scrollDiff += settings.SCROLLSPEED;

        }

    }



    public void kill() {

        this.dead = true;

    }



    public void update() {

        if (!gp.menuManager.inMenu && !gp.menuManager.inSubMenu) {
        
            // Update draw pos
            this.applyScroll();
            this.drawX = this.x;
            this.drawY = this.y + this.scrollDiff;

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
            this.updateParticles();
            this.gp.screenShake.update();

            // Apply gravity & speed
            if (!this.dead) {

                if (!this.onRope) {

                    this.speedY += this.gravity;
                    this.y += this.speedY + this.gravity / 2;

                }

                if (this.onRope) {
                    
                    this.y += this.speedY;

                }

                this.x += this.speedX;

            

                //      Collisions
                // Main rect
                this.rect.x = this.x + 1;
                this.rect.width = settings.TILESIZE - 2;

                this.detectCollisions("x");

                // Main rect
                this.rect.y = this.y + 1;
                this.rect.height = settings.TILESIZE - 2;

                // Platform rect
                this.platformRect.x = this.x;
                this.platformRect.y = this.y + settings.TILESIZE;
                this.platformRect.width = settings.TILESIZE;
                this.platformRect.height = settings.TILESIZE / 4;

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

            this.getOptionsButtonInput();
            this.getCircleButtonInput();

            if (gp.menuManager.inMenu || gp.menuManager.inSubMenu) {

                this.getKeyboardInputEscape();
                this.getKeyboardInputSelect();

            }

        }

    }



    public void draw(Graphics2D g2) {

        g2.drawImage(this.image, this.drawX, this.drawY, settings.TILESIZE, settings.TILESIZE, null);

        if (gp.controllerManager.playerCount == 2) {

            spritesheet.drawTextNoBG(g2, "P" + this.playerNum, this.drawX - settings.TILESIZE / 2, this.drawY - settings.TILESIZE, new String[] {"custom", "custom"});

        }

        for (PlayerProjectile proj : this.projectiles) {

            if (!proj.collided) {

                g2.drawImage(proj.image, proj.drawX, proj.drawY + this.scrollDiff, proj.width, proj.height, null);

            }

        }

        
        g2.drawImage(

            this.landParticle.image, 
            this.landParticle.drawX, 
            this.landParticle.drawY + (settings.TILESIZE - this.jumpParticle.image.getHeight() * settings.tileScale), 
            this.landParticle.image.getWidth() * settings.tileScale, 
            this.landParticle.image.getHeight() * settings.tileScale, 
            null

        );
        
        g2.drawImage(

            this.jumpParticle.image, 
            this.jumpParticle.drawX, 
            this.jumpParticle.drawY + (settings.TILESIZE - this.jumpParticle.image.getHeight() * settings.tileScale), 
            this.jumpParticle.image.getWidth() * settings.tileScale, 
            this.jumpParticle.image.getHeight() * settings.tileScale, 
            null

        );

    }

}
