package maze;


import javax.swing.*;

class TileBlank extends Tile {

    public TileBlank(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return new ImageIcon("resources/chap.png");
        } else {
            return new ImageIcon("resources/blank.png");
        }
    }

    @Override
    public String getType() {
        return "blank";
    }

}
