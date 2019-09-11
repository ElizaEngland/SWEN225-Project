package maze;

import javax.swing.*;

public class TileExitLock extends Tile{

    TileExitLock(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/exitLock.png");
    }

}
