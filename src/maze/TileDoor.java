package maze;

import javax.swing.*;

public class TileDoor extends Tile {

    private String colour;

    TileDoor(int x, int y, String colour) {
        super(x, y);
        this.colour = colour;
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/door_" + colour + ".png");
    }
}
