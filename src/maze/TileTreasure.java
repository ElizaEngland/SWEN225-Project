package maze;

import javax.swing.*;

public class TileTreasure extends Tile {

    TileTreasure(int x, int y) {
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

}
