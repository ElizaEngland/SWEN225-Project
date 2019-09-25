package maze;
import javax.swing.*;


public class TileJailWall extends Tile {


    TileJailWall(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {

        return new ImageIcon("resources/jailWall.png");
    }

    @Override
    public String getType() {
        return "jailWall";
    }
}
