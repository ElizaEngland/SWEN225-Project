package maze;

import javax.swing.*;

public class TileWall extends Tile {

    TileWall(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/wall.png");
    }

}
