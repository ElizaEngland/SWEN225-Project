package maze;


import application.Item;
import application.Main;

import javax.swing.*;
import java.util.ArrayList;

public class TileExitLock extends Tile {

    TileExitLock(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return new ImageIcon("resources/chap.png");
        } else {
            return new ImageIcon("resources/exitLock.png");
        }
    }
}
