package maze;

import application.Main;

import javax.swing.*;


public class TileExitLock extends Tile {

    public TileExitLock(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return super.getIcon();
        } else {
            return new ImageIcon("resources/exitLock.png");
        }
    }

    @Override
    public String getType() {
        return "exitlock";
    }
}
