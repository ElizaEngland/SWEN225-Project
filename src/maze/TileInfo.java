package maze;

import javax.swing.*;

public class TileInfo extends Tile{

    TileInfo(int x, int y) { super(x, y); }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/info.png");
    }
}
