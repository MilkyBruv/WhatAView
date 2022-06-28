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

            charPressed = e.getKeyChar();
            prevCharPressed = charPressed;

        } else {

            charPressed = prevCharPressed;

        }

        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {

            upPressed = true;

        }

        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {

            downPressed = true;

        }

        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {

            leftPressed = true;

        }

        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {

            rightPressed = true;

        }

        if (code == KeyEvent.VK_X || code == KeyEvent.VK_N) {

            shootPressed = true;

        }

        if (code == KeyEvent.VK_C || code == KeyEvent.VK_M) {

            jumpPressed = true;

        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {

            upPressed = false;

        }

        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {

            downPressed = false;

        }

        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {

            leftPressed = false;

        }

        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {

            rightPressed = false;

        }

        if (code == KeyEvent.VK_X || code == KeyEvent.VK_N) {

            shootPressed = false;

        }

        if (code == KeyEvent.VK_C || code == KeyEvent.VK_M) {

            jumpPressed = false;

        }

    }
    
}
