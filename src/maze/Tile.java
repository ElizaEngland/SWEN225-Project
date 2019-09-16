package maze;

import javax.swing.*;

public class Tile {

    private int x;
    private int y;
    private boolean player;

    Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the image icon for this tile.
     * @return Returns the image icon for this tile
     */
    public ImageIcon getIcon() {
        return null;
    }

    /**
     * Check whether a tile has a player or not.
     * @return Returns true if the tile contains a player.
     */
    public boolean isPlayer() {
        return player;
    }

    /**
     * Set the current player status of a tile.
     * @param value Whether the tile has a player or not.
     */
    public void setPlayer(boolean value) {
        player = value;
    }

}
