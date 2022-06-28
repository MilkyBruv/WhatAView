package main.menu.menus;

import main.GamePanel;
import main.menu.Menu;

public class StartMenu extends Menu {
    
    public StartMenu(GamePanel gp) {

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
        this.title = "[start]";
        this.items = new String[] {"play", "mode: " + gp.PLAYMODE, "quit"};
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

        System.out.println("TODO: Change play mode");

    }



    @Override
    public void item3() {

        System.exit(0);

    }

}
