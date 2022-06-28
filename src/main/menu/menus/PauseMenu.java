package main.menu.menus;

import main.GamePanel;
import main.menu.Menu;

public class PauseMenu extends Menu {
    
    public PauseMenu(GamePanel gp) {

        super(gp);
        
        this.gp = gp;
        this.itemPositions = new int[][] {

            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0}
    
        };
        this.title = "[paused]";
        this.items = new String[] {"resume", "restart", "quit"};
        this.itemCount = this.items.length;
        this.selectedItem = 0;

        this.getItemPositions();
        this.image = this.getImage();

        System.out.println(this.title);

    }



    @Override
    public void item1() {

        gp.menuManager.inMenu = false;

    }



    @Override
    public void item2() {

        System.out.println("TODO: Restart level");

    }



    @Override
    public void item3() {

        System.exit(0);

    }

}
