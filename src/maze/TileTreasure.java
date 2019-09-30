package maze;

import javax.swing.*;

public class TileTreasure extends Tile {

    public TileTreasure(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return new ImageIcon("resources/chap.png");
        } else {
            return new ImageIcon("resources/treasure.png");
        }
    }

    @Override
    public String toString() {
        return "billy_maverick";
    }

    @Override
    public String getType() {
        return "treasure";
    }
}
