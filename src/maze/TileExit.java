package maze;

import application.Main;

import javax.swing.*;

public class TileExit extends Tile {

    public TileExit(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return super.getIcon();
        } else {
            return new ImageIcon("resources/exit.png");
        }
    }

    @Override
    public String getType() {
        return "exit";
    }
}
