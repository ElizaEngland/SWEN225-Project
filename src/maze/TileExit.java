package maze;

import javax.swing.*;

public class TileExit extends Tile{

    TileExit(int x, int y) { super(x, y); }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/exit.png");
    }
}
