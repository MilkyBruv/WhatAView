package main;

import main.sprites.Menu;
import main.sprites.Spritesheet;

import java.awt.Graphics2D;

public class MenuManager {
    
    private GamePanel gp;
    private Spritesheet ss;

    public Menu currentMenu;
    public boolean inMenu = true;

    public Menu optionsMenu;
    public Menu startMenu;
    public Menu endMenu;
    public Menu pauseMenu;
    public Menu failMenu;

    public MenuManager(GamePanel gp) {

        this.gp = gp;
        this.ss = gp.spritesheet;

        this.optionsMenu = new Menu(gp, "options", 1);
        this.optionsMenu.items[0] = "volume";
        this.optionsMenu.items[1] = "fps";

        this.startMenu = new Menu(gp, "start", 1);
        this.startMenu.items[0] = "play";
        this.startMenu.items[1] = "exit";

        this.endMenu = new Menu(gp, "end", 1);
        this.endMenu.items[0] = "play again";
        this.endMenu.items[1] = "exit";

        this.pauseMenu = new Menu(gp, "paused", 2);
        this.pauseMenu.items[0] = "resume";
        this.pauseMenu.items[1] = "restart";
        this.pauseMenu.items[2] = "exit";

    }



    public void update() {

        //TODO: Update all menus (create method in Menu class)

    }



    public void draw(Graphics2D g2) {

        //TODO: Draw current menu image

    }

}
