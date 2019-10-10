package application;

import maze.*;
import renderer.GUINextLevel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The player class which handles player movement, inventory etc...
 */
public class Player {

    private ArrayList<Item> inventory = new ArrayList<>();
    public ArrayList MavsXPos = new ArrayList<ItemTreasure>();
    public ArrayList MavsYPos = new ArrayList<ItemTreasure>();
    private int x;
    private int y;
    private int treasureCollected = 0;
    private boolean infoRequested;
    private static int prisonSentence = 0;
    private ImageIcon icon = new ImageIcon("resources/chapEast.png");

    /**
     * Player constructor.
     *
     * @param startX The starting x position of the player
     * @param startY The starting y position of the player
     */
    Player(int startX, int startY, Board board) {
        this.x = startX;
        this.y = startY;
        board.getTile(x, y).setPlayer(true);
        addInventory(board);
    }

    public void addInventory(Board board) {
        if (!board.initialInventory.isEmpty()) {
            inventory = board.initialInventory;
        }
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
            if (validateMove(x, y - 1, board, direction)) {
                setIcon(new ImageIcon("resources/chapEast.png"));
                y--;
            }
        }

        if (direction == Direction.SOUTH) {
            if (validateMove(x, y + 1, board, direction)) {
                setIcon(new ImageIcon("resources/chapEast.png"));
                y++;
            }
        }

        if (direction == Direction.WEST) {
            if (validateMove(x - 1, y, board, direction)) {
                setIcon(new ImageIcon("resources/chapWest.png"));
                x--;
            }
        }

        if (direction == Direction.EAST) {
            if (validateMove(x + 1, y, board, direction)) {
                setIcon(new ImageIcon("resources/chapEast.png"));
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
    public boolean validateMove(int x, int y, Board board, Direction direction) {
        infoRequested = false;

        if (y < 0 || x < 0 || y >= Main.ROWS || x >= Main.COLS) return false;

        Tile nextMove = board.getTile(x, y);

        if (nextMove instanceof TileSpilledDrink) {
            if (direction == Direction.NORTH) {
                if (validateMove(x, y - 1, board, direction)) {
                    this.y--;
                }
            }
            if (direction == Direction.SOUTH) {
                if (validateMove(x, y + 1, board, direction)) {
                    this.y++;
                }
            }
            if (direction == Direction.WEST) {
                if (validateMove(x - 1, y, board, direction)) {
                    this.x--;
                }
            }
            if (direction == Direction.EAST) {
                if (validateMove(x + 1, y, board, direction)) {
                    this.x++;
                }
            }
        }

        if (nextMove instanceof TileWall) return false;
        if (nextMove instanceof TileJailWall) return false;

        if (nextMove instanceof TileDoor) {
            boolean foundKey = false;
            for (Item item : inventory) {
                if (item instanceof ItemKey) {
                    ItemKey key = (ItemKey) item;
                    if (key.getColour().equals(((TileDoor) nextMove).getColour())) {
                        foundKey = true;
                    }
                }
            }
            return foundKey;
        }

        if (nextMove instanceof TileJailDoor) {
            if(prisonSentence <= 0){
                return true;
            }else{
                return false;
            }
        }


        if (nextMove instanceof TileExitLock) {
            return (treasureCollected == Main.MAX_TREASURE);
        }

        if (nextMove instanceof TileInfo) {
            infoRequested = true;
        }

        if (nextMove instanceof TileExit) {
            new GUINextLevel();
        }

        if (nextMove instanceof TileCop){
            if (validateMove(x, y - 1, board, direction)) {
                this.x = 2;
                this.y = 9;
                prisonSentence = 5;
            }
        }
        if (nextMove instanceof TileEnemy){
            if (validateMove(x, y - 1, board, direction)) {
                this.x = 7;
                this.y = 12;
            }
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
        if (item instanceof ItemTreasure) {

            treasureCollected++;
            return;
        }

        if (inventory.size() <= 8) {

            inventory.add(item);

        }

    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    /**
     * Get the players inventory.
     *
     * @return Player inventory.
     */
    public ArrayList<Item> getInventory() {
        return inventory;
    }


    /**
     * Get the players inventory.
     *
     * @return Player inventory.
     */
    public ArrayList<String> getInventorykeys() {
        ArrayList<String> keyColours = new ArrayList<>();

        for (Item i : inventory) {
            keyColours.add(((ItemKey) i).getColour());
        }
        System.out.println(keyColours);
        return keyColours;
    }


    @Override
    public String toString() {
        //String s = "";
        StringBuffer buf = new StringBuffer();
        for (Item i : inventory) {
            //s += ", " + ((ItemKey) i).getColour();
            buf.append(", " + ((ItemKey) i).getColour());
        }
        String s = buf.toString();
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

    public static void setPrisonSentence(int length) {
        prisonSentence = length;
    }

    public static int getPrisonSentence() {
        return prisonSentence;
    }
}
