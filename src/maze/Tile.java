package maze;

import application.Direction;
import application.Main;

import javax.swing.*;

/**
 * Tile class for Chip's Challenge
 * @author - Ben Robertson, Eliza England, Ethan King, Jacqueline Dong, Jay Patel, Mason Yi
 */
public class Tile {

    private int x;
    private int y;
    private boolean player;

    /**
     * Tile for the board x and y axis
     *
     * @param x x axis for tile
     * @param y y axis for tile
     */

    Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the image icon for this tile.
     *
     * @return Returns the image icon for this tile
     */
    public ImageIcon getIcon() {
        return Main.getPlayer().getIcon();
    }

    /**
     * Check whether a tile has a player or not.
     *
     * @return Returns true if the tile contains a player.
     */
    boolean isPlayer() {
        return player;
    }

    /**
     * Set the current player status of a tile.
     *
     * @param value Whether the tile has a player or not.
     */
    public void setPlayer(boolean value) {
        player = value;
    }

    /**
     * Returns type of tile for jSon file output
     *
     * @return
     */
    public String getType() {
        return null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(Direction direction) {
        if (direction == Direction.EAST) x++;
        if (direction == Direction.WEST) x--;
        if (direction == Direction.SOUTH) y++;
        if (direction == Direction.NORTH) y--;
    }
}
