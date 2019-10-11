package maze;

import javax.swing.*;

public class TileSpilledDrink extends Tile {

    public TileSpilledDrink(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return super.getIcon();
        } else {
            return new ImageIcon("resources/spiltDrink.png");
        }
    }

    @Override
    public String getType() {
        return "spilleddrink";
    }
}
