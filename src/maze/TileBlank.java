package maze;


import javax.swing.*;

public class TileBlank extends Tile {

    TileBlank(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return new ImageIcon("resources/chap.png");
        } else {
            return new ImageIcon("resources/blank.png");
        }
    }

}
