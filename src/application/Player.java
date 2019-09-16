package application;

import java.util.ArrayList;

/**
 * The player class which handles player movement, inventory etc...
 */
public class Player {

    private ArrayList<Item> inventory = new ArrayList<>();
    int x;
    int y;

    /**
     * Player constructor.
     * @param startX The starting x position of the player
     * @param startY The starting y position of the player
     */
    Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    /**
     * Allows the movement of a player around the board.
     * @param direction The direction to be moved
     */
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

    /**
     * Allows the addition of items to the player inventory.
     * @param item The item which will be added to the players inventory
     */
    void addItemToInventory(Item item) {
        if (inventory.size() <= 8) {
            inventory.add(item);
        } else {
            System.out.println("Cannot have more than 8 items in the inventory.");
        }
    }
}
