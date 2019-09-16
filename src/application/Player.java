package application;

import maze.Board;
import maze.TileDoor;
import maze.TileWall;

import java.util.ArrayList;

/**
 * The player class which handles player movement, inventory etc...
 */
class Player {

    private ArrayList<Item> inventory = new ArrayList<>();
    private int x;
    private int y;

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

        addItemToInventory(board.getObjectOnTile(x, y));
        board.update(oldX, oldY, x, y);

    }

    /**
     * Checks whether the move a player is attempting to make is valid or not.
     * @param x The X coordinate.
     * @param y The Y coordinate.
     * @param board The board to be checked against.
     * @return Whether or not the move is valid.
     */
    private boolean validMove(int x, int y, Board board) {

        if (y < 0 || x < 0 || y >= Main.ROWS || x >= Main.COLS) {
            return false;
        }

        if (board.getTile(x, y) instanceof TileWall) {
            return false;
        }

        if (board.getTile(x, y) instanceof TileDoor) {
            boolean foundKey = false;
            String colour = ((TileDoor) board.getTile(x, y)).getColour();
            for (Item item : getInventory()) {
                if (item.toString().equals(colour)) {
                    foundKey = true;
                }
            }
            return foundKey;
        }

        return true;

    }

    /**
     * Allows the addition of items to the player inventory.
     * @param item The item which will be added to the players inventory
     */
    private void addItemToInventory(Item item) {

        if (item == null) return;

        if (inventory.size() <= 8) {
            inventory.add(item);
        } else {
            System.out.println("Cannot have more than 8 items in the inventory.");
        }
    }

    /**
     * Get the players inventory.
     * @return Player inventory.
     */
    ArrayList<Item> getInventory() {
        return inventory;
    }
}
