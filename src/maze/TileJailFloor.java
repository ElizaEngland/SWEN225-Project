package maze;
import application.Main;

import javax.swing.*;


public class TileJailFloor extends Tile {

    public TileJailFloor(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return super.getIcon();
        } else {
            return new ImageIcon("resources/jailFloor.png");
        }
    }

    @Override
    public String getType() {
        return "jailFloor";
    }
}
