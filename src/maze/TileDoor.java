package maze;

import javax.swing.*;

public class TileDoor extends Tile{

    TileDoor(int x, int y) { super(x, y); }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/door.png");
    }
}
