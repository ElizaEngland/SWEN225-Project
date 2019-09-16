package maze;

import application.Item;
import application.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Board {

    private Tile[][] board = new Tile[Main.COLS][Main.ROWS];

    /**
     * Load the board from a text file and generate a two-dimensional array of tiles.
     */
    public Board() {

        try {

            File rooms = new File("./src/level1.map");   // MARKER: Please ensure this file is in the correct directory

            BufferedReader reader = new BufferedReader(new FileReader(rooms));

            String targetLine;

            while ((targetLine = reader.readLine()) != null) {

                String[] tokens = targetLine.split(" ");

                int x = Integer.parseInt(tokens[0]);    // x
                int y = Integer.parseInt(tokens[1]);    // y
                String type = tokens[2];            // tile type
                String colour = "";

                if (tokens.length == 4) {   // for colour coded keys/doors
                     colour = tokens[3];
                }

                Tile tile;

                if (type.equals("blank")) {
                    tile = new TileBlank(x, y);
                } else if (type.equals("treasure")) {
                    tile = new TileTreasure(x, y);
                } else if (type.equals("wall")) {
                    tile = new TileWall(x, y);
                } else if (type.equals("door")) {
                    tile = new TileDoor(x, y, colour);
                } else if (type.equals("exit")) {
                    tile = new TileExit(x, y);
                } else if (type.equals("info")) {
                    tile = new TileInfo(x, y);
                } else if (type.equals("key")) {
                    tile = new TileKey(x, y, colour);
                } else if (type.equals("exitlock")) {
                    tile = new TileExitLock(x, y);
                }else {
                    tile = null;
                }

                board[x][y] = tile;

            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }

    /**
     * Move the player from one coordinate to another.
     * @param oldX The X coordinate of the position moved from.
     * @param oldY The Y coordinate of the position moved from.
     * @param x The X coordinate of the position moved to.
     * @param y The Y coordinate of the position moved to.
     */
    public void update(int oldX, int oldY, int x, int y) {
        board[oldX][oldY].setPlayer(false);
        board[x][y].setPlayer(true);
    }

    /**
     * Get a specific tile from the board at a specified coordinate.
     * @param x The X coordinate
     * @param y The Y coordinate
     * @return The tile at the specified coordinates
     */
    public Tile getTile(int x, int y) {
        return board[x][y];
    }

    /**
     * Returns the object beneath the player if it is an item that can be picked up.
     * @param x The X coordinate.
     * @param y The Y coordinate.
     * @return The object to be picked up if one is found.
     */
    public Item getObjectOnTile(int x, int y) {

        Tile tile = getTile(x, y);

        if (tile instanceof TileKey || tile instanceof TileTreasure) {
            Item item = new Item(tile.toString());
            board[x][y] = new TileBlank(x, y);
            return item;
        } else {
            return null;
        }

    }
}
