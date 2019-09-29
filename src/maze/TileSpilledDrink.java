package maze;

import javax.swing.*;

public class TileSpilledDrink extends Tile {

    TileSpilledDrink(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return new ImageIcon("resources/chap.png");
        } else {
            return new ImageIcon("resources/black.png");
        }
    }

    @Override
    public String getType() {
        return "spilled_drink";
    }
}
