package maze;

import javax.swing.*;

public class TileKey extends Tile{

    TileKey(int x, int y) { super(x, y); }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/key.png");
    }
}
