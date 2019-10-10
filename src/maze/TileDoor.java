package maze;

import application.Main;

import javax.swing.*;

public class TileDoor extends Tile {

    private String colour;

    public TileDoor(int x, int y, String colour) {
        super(x, y);
        this.colour = colour;
    }


    public String getColour() {
        return colour;
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return Main.getPlayer().getIcon();
        } else {
            return new ImageIcon("resources/door_" + colour + ".png");
        }
    }

    @Override
    public String getType() {
        return "door, " + colour;
    }
}
