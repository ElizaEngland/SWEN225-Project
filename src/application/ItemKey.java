package application;

import javax.swing.*;

/**
 * ItemKey class for the keys in Chip's Challenge.
 * @author - Ben Robertson, Eliza England, Ethan King, Jacqueline Dong, Jay Patel, Mason Yi
 */
public class ItemKey implements Item {

    private String colour;

    public ItemKey(String colour) {
        this.colour = colour;
    }

    /**
     * Returns the colour of the Key.
     * @return String of the colour.
     */
    String getColour() {
        return colour;
    }

    /**
     * Returns an Image Icon of the coloured key.
     * @return ImageIcon.
     */
    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/key_" + colour + ".png");
    }
}
