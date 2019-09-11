package maze;

import javax.swing.*;

public class TileFree extends Tile{

    TileFree(int x, int y) { super(x, y); }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/free.png");
    }
}
