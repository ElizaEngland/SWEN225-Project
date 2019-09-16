package application;

import maze.Board;

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
    void move(Direction direction, Board board) {

        int oldX = x;
        int oldY = y;

        if (direction == Direction.NORTH) {
            if (y > 0) {
                y--;
            }
        }

        if (direction == Direction.SOUTH) {
            if (y < Main.COLS - 1) {
                y++;
            }
        }

        if (direction == Direction.WEST) {
            if (x > 0) {
                x--;
            }
        }

        if (direction == Direction.EAST) {
            if (x < Main.ROWS - 1) {
                x++;
            }
        }

        board.update(oldX, oldY, x, y);

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
