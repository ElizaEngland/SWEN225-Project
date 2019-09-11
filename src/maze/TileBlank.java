package maze;

import javax.swing.*;

public class TileBlank extends Tile {

    TileBlank(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/blank.png");
    }

}
