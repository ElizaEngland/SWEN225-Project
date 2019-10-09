package maze;

import javax.swing.*;

public class TileCop extends  Tile{
    public TileCop(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return super.getIcon();
        } else {
            return new ImageIcon("resources/cop.png");
        }
    }

    @Override
    public String getType() {
        return "cop";
    }
}
