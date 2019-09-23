package maze;

import javax.swing.*;

public class TileExit extends Tile {

    TileExit(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return new ImageIcon("resources/chap.png");
        } else {
            return new ImageIcon("resources/exit.png");
        }
    }

    @Override
    public String getType() {
        return "exit";
    }
}
