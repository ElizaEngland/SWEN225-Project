package application;

import maze.Board;
import maze.TileWall;

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
     *
     * @param startX The starting x position of the player
     * @param startY The starting y position of the player
     */
    Player(int startX, int startY) {

        this.x = startX;
        this.y = startY;
    }

    /**
     * Allows the movement of a player around the board.
     *
     * @param direction The direction to be moved
     */
    void move(Direction direction, Board board) {

        int oldX = x;
        int oldY = y;

        if (direction == Direction.NORTH) {
            if (validMove(x, y - 1, board)) {
                y--;
            }
        }

        if (direction == Direction.SOUTH) {
            if (validMove(x, y + 1, board)) {
                y++;
            }
        }

        if (direction == Direction.WEST) {
            if (validMove(x - 1, y, board)) {
                x--;
            }
        }

        if (direction == Direction.EAST) {
            if (validMove(x + 1, y, board)) {
                x++;
            }
        }

        board.update(oldX, oldY, x, y);
    }

    boolean validMove(int x, int y, Board board) {
        if (board.getBoard()[x][y] instanceof TileWall
                || x < 0
                || y < 0
                || x >= Main.COLS
                || y >= Main.ROWS) return false;
        return true;
    }


    /**
     * Allows the addition of items to the player inventory.
     *
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
