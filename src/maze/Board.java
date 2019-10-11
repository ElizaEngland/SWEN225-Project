package maze;

import application.*;
import persistence.Read;

import java.util.ArrayList;

/**
 * Board class for Chip's Challenge
 *
 * @author - Ben Robertson, Eliza England, Ethan King, Jacqueline Dong, Jay Patel, Mason Yi
 */
public class Board {

    private Tile[][] board;
    public int treasureCount = 0;
    private String levelName;
    private int startX, startY;
    public ArrayList<Item> initialInventory = new ArrayList<>();
    private String description = "";
    public ArrayList<Tile> enemies = new ArrayList<>();
    private boolean moveRight = false;

    /**
     * Load the board from a text file and generate a two-dimensional array of tiles.
     */
    public Board(String fileName) {

        board = Read.readFile(fileName, this);
    }

    /**
     * Adds item picked up to current inventory.
     *
     * @param e
     */
    public void addInventory(Item e) {
        initialInventory.add(e);
    }

    /**
     * Move the player from one coordinate to another.
     *
     * @param oldX The X coordinate of the position moved from.
     * @param oldY The Y coordinate of the position moved from.
     * @param x    The X coordinate of the position moved to.
     * @param y    The Y coordinate of the position moved to.
     */
    public void update(int oldX, int oldY, int x, int y) {
        board[oldX][oldY].setPlayer(false);
        board[x][y].setPlayer(true);
    }

    /**
     * Update the position of all enemies on the board.
     */
    public void updateEnemies() {
        for (Tile enemy : enemies) {
            board[enemy.getX()][enemy.getY()] = new TileBlank(enemy.getX(), enemy.getY());
            if (moveRight) {
                moveRight = false;
                enemy.move(Direction.EAST);
            } else {
                moveRight = true;
                enemy.move(Direction.WEST);
            }

            board[enemy.getX()][enemy.getY()] = enemy;

            if (enemy.getX() == Main.getPlayer().getX() && enemy.getY() == Main.getPlayer().getY()) {
                Main.getPlayer().setX(5);
                Main.getPlayer().setY(9);
            }
        }
    }

    /**
     * Get a specific tile from the board at a specified coordinate.
     *
     * @param x The X coordinate.
     * @param y The Y coordinate.
     * @return The tile at the specified coordinates.
     */
    public Tile getTile(int x, int y) {
        return board[x][y];
    }

    /**
     * Sets level name for reading new levels in.
     *
     * @param levelName
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    /**
     * Gets start x position of character for level.
     *
     * @return
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Sets start x position of character for level.
     *
     * @param startX
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * Gets start y position of character for level.
     *
     * @return
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Sets start x position of character for level.
     *
     * @param startY
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * Returns the object beneath the player if it is an item that can be picked up.
     *
     * @param x The X coordinate.
     * @param y The Y coordinate.
     * @return The object to be picked up if one is found.
     */
    public Item getObjectOnTile(int x, int y) {

        Tile tile = getTile(x, y);

        if (tile instanceof TileKey) {
            Item item = new ItemKey(((TileKey) tile).getColour());
            board[x][y] = new TileBlank(x, y);
            return item;
        } else if (tile instanceof TileTreasure) {
            Item item = new ItemTreasure();
            board[x][y] = new TileBlank(x, y);
            return item;
        } else {
            return null;
        }

    }

    /**
     * Gets the number of pieces of treasure in a loaded level.
     *
     * @return The amount of treasure in the level.
     */
    public int getTreasureCount() {
        return treasureCount;
    }

    /**
     * Gets level name.
     *
     * @return
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * Gets information for info tile.
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets information for when loading file in.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
