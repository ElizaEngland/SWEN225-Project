package maze;

import application.Main;

import javax.swing.*;

public class TileJailDoor extends Tile {

    public TileJailDoor(int x, int y) {
        super(x, y);
    }

    @Override
    public ImageIcon getIcon() {
        if (isPlayer()) {
            return super.getIcon();
        } else {
            return new ImageIcon("resources/jail_door.png");
        }
    }

    @Override
    public String getType() {
        return "jailDoor";
    }
}

