package maze;

import javax.swing.*;

public class TileEnemy extends Tile {

    /**
     * Tile for the board x and y axis
     *
     * @param x x axis for tile
     * @param y y axis for tile
     */
    public TileEnemy(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return super.getIcon();
        } else {
            return new ImageIcon("resources/drunk.png");
        }
    }

    @Override
    boolean isPlayer() {
        return super.isPlayer();
    }

    @Override
    public void setPlayer(boolean value) {
        super.setPlayer(value);
    }

    @Override
    public String getType() {
        return super.getType();
    }
}
