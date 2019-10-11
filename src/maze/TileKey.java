package maze;

import javax.swing.*;

public class TileKey extends Tile {

    private String colour;

    /**
     * Tile Key parameters
     *
     * @param x      x coord for tile
     * @param y      y coord for tile
     * @param colour string type of tile eg wall, blank
     */

    public TileKey(int x, int y, String colour) {
        super(x, y);
        this.colour = colour;
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return super.getIcon();
        } else {
            return new ImageIcon("resources/key_" + colour + ".png");
        }
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "key_" + colour;
    }

    @Override
    public String getType() {
        return "key, " + colour;
    }
}
