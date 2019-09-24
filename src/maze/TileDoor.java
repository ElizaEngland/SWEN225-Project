package maze;

import javax.swing.*;

public class TileDoor extends Tile {

    private String colour;
    private boolean unlocked;

    TileDoor(int x, int y, String colour) {
        super(x, y);
        this.colour = colour;
        unlocked = false;
    }

    public void setUnlocked() { unlocked = true;}

    public String getColour() {
        return colour;
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return new ImageIcon("resources/chap.png");
        } else {
            if(unlocked) return new ImageIcon("resources/blank.png");
            return new ImageIcon("resources/door_" + colour + ".png");
        }
    }

    @Override
    public String getType() { return "door, " + colour; }
}
