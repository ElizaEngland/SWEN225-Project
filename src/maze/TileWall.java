package maze;

import javax.swing.*;

public class TileWall extends Tile {

    public TileWall(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/wall.png");
    }

    @Override
    public String getType() {
        return "wall";
    }
}
