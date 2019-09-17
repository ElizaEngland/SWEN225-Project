package application;

import javax.swing.*;

public class ItemKey implements Item {

    private String colour;

    public ItemKey(String colour) {
        this.colour = colour;
    }

    String getColour() {
        return colour;
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/inventory/key_" + colour + ".png");
    }
}
