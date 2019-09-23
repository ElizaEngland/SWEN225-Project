package application;

import javax.swing.*;

public class ItemTreasure implements Item {

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/inventory/treasure.png");
    }

}
