package application;

import javax.swing.*;

/**
 * Item Treasure class for the treasure in Chip's Challenge.
 */
public class ItemTreasure implements Item {

    /**
     * Returns an ImageIcon of the treasure.
     * @return ImageIcon of the treasure.
     */
    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/inventory/treasure.png");
    }

}
