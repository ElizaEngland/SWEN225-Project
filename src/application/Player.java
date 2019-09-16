package application;

import java.util.ArrayList;

public class Player {

    ArrayList<String> inventory = new ArrayList<>();
    int x;
    int y;

    Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    void move(Direction direction) {

        switch (direction) {
            case NORTH:
                y--;
                System.out.println("moved north");
                break;
            case SOUTH:
                y++;
                System.out.println("moved south");
                break;
            case EAST:
                x--;
                System.out.println("moved east");
                break;
            case WEST:
                x++;
                System.out.println("moved west");
                break;
        }

    }
}
