package main;

import main.sprites.Menu;
import main.sprites.Spritesheet;

import java.awt.Graphics2D;

public class MenuManager {
    
    private GamePanel gp;
    private Spritesheet ss;

    public Menu currentMenu;
    public boolean inMenu = false;
    public boolean inSubMenu = false;

    public Menu optionsMenu;
    public Menu startMenu;
    public Menu endMenu;
    public Menu pauseMenu;
    public Menu failMenu;

    public MenuManager(GamePanel gp) {

        this.gp = gp;
        this.ss = gp.spritesheet;

        this.optionsMenu = new Menu(gp, "options", new String[] {"volume", "fps"});

        this.startMenu = new Menu(gp, "start", new String[] {"player", "exit"});

        this.endMenu = new Menu(gp, "end", new String[] {"player again", "exit"});

        this.pauseMenu = new Menu(gp, "paused", new String[] {"resume", "restart", "exit"});

        this.currentMenu = this.startMenu;

    }



    public void update() {

        //TODO: Update all menus (create method in Menu class)

    }



    public void draw(Graphics2D g2) {

        g2.drawImage(this.currentMenu.image, 0, 0, this.currentMenu.image.getWidth(), this.currentMenu.image.getHeight(), null);

    }

}
