package main.menu.menus;

import main.GamePanel;
import main.menu.Menu;

public class EndMenu extends Menu {
    
    public EndMenu(GamePanel gp) {

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
        this.title = "[e]";
        this.items = new String[] {"1", "2", "3"};
        this.itemCount = this.items.length;
        this.selectedItem = 0;

        this.getItemPositions();
        this.image = this.getImage();

        System.out.println(this.title);

    }

}
