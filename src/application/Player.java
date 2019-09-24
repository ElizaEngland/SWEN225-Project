package application;

import maze.*;
import renderer.GUINextLevel;

import java.util.ArrayList;

/**
 * The player class which handles player movement, inventory etc...
 */
public class Player {

    private ArrayList<Item> inventory = new ArrayList<>();
    private int x;
    private int y;
    private int treasureCollected = 0;
    private boolean infoRequested;

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
    public void move(Direction direction, Board board) {

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
     *
     * @param x     The X coordinate.
     * @param y     The Y coordinate.
     * @param board The board to be checked against.
     * @return Whether or not the move is valid.
     */
    private boolean validMove(int x, int y, Board board) {
        infoRequested = false;

        if (y < 0 || x < 0 || y >= Main.ROWS || x >= Main.COLS) return false;

        Tile nextMove = board.getTile(x, y);

        if (nextMove instanceof TileSpilledDrink) {
            System.out.println("should slip");
        }

        if (nextMove instanceof TileWall) return false;

        if (nextMove instanceof TileDoor) {
            boolean foundKey = false;
            for (Item item : getInventory()) {
                if (item instanceof ItemKey) {
                    ItemKey key = (ItemKey) item;
                    if (key.getColour().equals(((TileDoor) nextMove).getColour())) {
                        foundKey = true;
                    }
                }
            }
            if(foundKey) ((TileDoor) nextMove).setUnlocked();
            return foundKey;
        }

        if (nextMove instanceof TileExitLock) {
            return (treasureCollected == Main.MAX_TREASURE);
        }

        if (nextMove instanceof TileInfo) {
            infoRequested = true;
            return true;
        }

        if (nextMove instanceof TileExit){
            new GUINextLevel();

        }

        return true;

    }

    /**
     * Allows the addition of items to the player inventory.
     *
     * @param item The item which will be added to the players inventory
     */
    private void addItemToInventory(Item item) {

        if (item == null) return;
        if(item instanceof ItemTreasure){
            treasureCollected++;
            return;
        }

        if (inventory.size() <= 8) {

            inventory.add(item);

        }

    }

    /**
     * Get the players inventory.
     *
     * @return Player inventory.
     */
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        String s="";
        for (Item i : inventory) {
            s += ", " + i.getIcon();
        }
        System.out.println(s);
        return s;
    }

    /**
     * Gets the number of Treasure the player has collected
     *
     * @return Number of Treasure the player has
     */
    public int getTreasureCollected() {
        return treasureCollected;
    }

    /**
     * Checks the boolean variable to see if information is being requested
     *
     * @return if the information Tile is being stood on
     */
    public boolean isInfoRequested() {
        return infoRequested;
    }

    /**
     * Gets the x co-ordinate of player
     *
     * @return x value
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y co-ordinate of player
     *
     * @return y value
     */
    public int getY() {
        return y;
    }
}
