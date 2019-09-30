package maze;
import javax.swing.*;

public class TileJailDoor extends Tile {

    public TileJailDoor(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return new ImageIcon("resources/chap.png");
        } else {
            return new ImageIcon("resources/jailDoor.png");
        }
    }

    @Override
    public String getType() {
        return "jailDoor";
    }
}

