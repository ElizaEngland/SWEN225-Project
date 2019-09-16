package application;

import java.util.ArrayList;

public class Player {

    ArrayList<String> inventory = new ArrayList<>();
    int x;
    int y;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void move(String direction) {

        if (direction.equals("N")) {
            y--;
        } else if (direction.equals("S")) {
            y++;
        } else if (direction.equals("W")) {
            x--;
        } else if (direction.equals("E")) {
            x++;
        }

    }
}
