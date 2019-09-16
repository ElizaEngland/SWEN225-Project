package maze;

import javax.swing.*;

public class TileKey extends Tile {

    private String colour;

    TileKey(int x, int y, String colour) {
        super(x, y);
        this.colour = colour;
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return new ImageIcon("resources/chap.png");
        } else {
            return new ImageIcon("resources/key_" + colour + ".png");
        }
    }

    @Override
    public String toString() {
        return colour;
    }

}
