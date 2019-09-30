package maze;

import application.Main;

import javax.swing.*;

public class TileInfo extends Tile {

    public TileInfo(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return super.getIcon();
        } else {
            return new ImageIcon("resources/info.png");
        }
    }

//    public void showHelp() {
//        JFrame instructions = new JFrame();
//    }

    @Override
    public String getType() {
        return "info";
    }
}
