package maze;

import javax.swing.*;


public class TileJailWall extends Tile {


    public TileJailWall(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("resources/jail_wall.png");
    }

    @Override
    public String getType() {
        return "jailWall";
    }
}
