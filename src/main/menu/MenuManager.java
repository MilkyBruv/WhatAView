package main.menu;

import main.GamePanel;
import main.menu.menus.*;

import java.awt.Graphics2D;

public class MenuManager {
    
    private GamePanel gp;

    public Menu currentMenu;
    public boolean inMenu = true;
    public boolean inSubMenu = false;

    public Menu optionsMenu;
    public Menu startMenu;
    public Menu endMenu;
    public Menu pauseMenu;
    public Menu failMenu;

    public MenuManager(GamePanel gp) {

        this.gp = gp;

        this.optionsMenu = new OptionsMenu(gp);

        this.startMenu = new StartMenu(gp);

        this.endMenu = new EndMenu(gp);

        this.pauseMenu = new PauseMenu(gp);

        this.currentMenu = this.startMenu;

    }



    public void update() {

        this.currentMenu.setItemSelection();
        this.currentMenu.getItemPositions();
        this.currentMenu.setImage();

    }



    public void draw(Graphics2D g2) {

        g2.drawImage(this.currentMenu.image, 0, 0, this.currentMenu.image.getWidth(), this.currentMenu.image.getHeight(), null);

    }

}
