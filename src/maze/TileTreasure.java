package maze;

import javax.swing.*;

public class TileTreasure extends Tile {

    TileTreasure(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/treasure.png");
    }

    @Override
    public String toString() {
        return "T";
    }
}
