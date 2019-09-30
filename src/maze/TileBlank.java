package maze;


import application.Main;

import javax.swing.*;

public class TileBlank extends Tile {

    public TileBlank(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return super.getIcon();
        } else {
            return new ImageIcon("resources/blank.png");
        }
    }

    @Override
    public String getType() {
        return "blank";
    }

}
