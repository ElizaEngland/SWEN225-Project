package maze;

import application.Item;
import application.ItemKey;
import application.ItemTreasure;
import application.Main;
import persistence.Read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Board {

    private Tile[][] board;
    public int treasureCount = 0;
    private String levelName;
    private int startX, startY;
    public ArrayList<Item> initialInventory = new ArrayList<>();

    /**
     * Load the board from a text file and generate a two-dimensional array of tiles.
     */
    public Board(String fileName) {

        board = Read.readFile(fileName, this);

    }

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
     * Get a specific tile from the board at a specified coordinate.
     *
     * @param x The X coordinate
     * @param y The Y coordinate
     * @return The tile at the specified coordinates
     */
    public Tile getTile(int x, int y) {
        return board[x][y];
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

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

    public String getLevelName() {
        return levelName;
    }
}
