package application;

import javax.swing.*;

public class ItemKey implements Item {

    private String colour;

    public ItemKey(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/key_" + colour + ".png");
    }
}
