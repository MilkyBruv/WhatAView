package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, shootPressed, jumpPressed;
    public char charPressed = '0';
    private char prevCharPressed = '1';
    public String currentKeyPressed = "";
    private GamePanel gp;

    public KeyHandler(GamePanel gp) {

        this.gp = gp;

    }

    // TODO: Use lwjgl for keyboard input 

    public void onKeyPressed(char c) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        //! DO NOT USE
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();

        if (e.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {

            this.charPressed = e.getKeyChar();
            this.prevCharPressed = this.charPressed;

        } else {

            this.charPressed = this.prevCharPressed;

        }

        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {

            this.upPressed = true;

        }

        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {

            this.downPressed = true;

        }

        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {

            this.leftPressed = true;

        }

        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {

            this.rightPressed = true;

        }

        if (code == KeyEvent.VK_X || code == KeyEvent.VK_M) {

            this.shootPressed = true;

        }

        if (code == KeyEvent.VK_Z || code == KeyEvent.VK_N) {

            this.jumpPressed = true;

        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {

            this.upPressed = false;

        }

        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {

            this.downPressed = false;

        }

        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {

            this.leftPressed = false;

        }

        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {

            this.rightPressed = false;

        }

        if (code == KeyEvent.VK_X || code == KeyEvent.VK_M) {

            this.shootPressed = false;

        }

        if (code == KeyEvent.VK_Z || code == KeyEvent.VK_N) {

            this.jumpPressed = false;

        }

    }
    
}
