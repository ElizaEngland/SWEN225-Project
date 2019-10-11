package maze;

import javax.swing.*;

public class TileInfo extends Tile {

    /**
     * Sub class of tile, TileInfo is the tile that
     * contains information
     * on how to play the game.
     *
     * @param x x axis for tile
     * @param y y axis for tile
     */
    public TileInfo(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return super.getIcon();
        } else {
            return new ImageIcon("resources/info.png");
        }
    }

    @Override
    public String getType() {
        return "info";
    }
}
