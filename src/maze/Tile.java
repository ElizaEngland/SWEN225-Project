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

    public ImageIcon getIcon() {
        return null;
    }

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer(boolean value) {
        player = value;
    }

}
