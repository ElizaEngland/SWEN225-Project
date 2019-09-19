package maze;

import javax.swing.*;

public class TileInfo extends Tile {

    TileInfo(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return new ImageIcon("resources/chap.png");
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
