package maze;

import application.Item;
import application.ItemKey;
import application.ItemTreasure;
import application.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Board {

    private Tile[][] board;
    private int treasureCount = 0;
    private String levelName;
    private String startX, startY;

    /**
     * Load the board from a text file and generate a two-dimensional array of tiles.
     */
    public Board(File fileName) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String targetLine;

            levelName = reader.readLine();
            startX = reader.readLine();
            startY = reader.readLine();
            Main.COLS = Integer.parseInt(reader.readLine());
            Main.ROWS = Integer.parseInt(reader.readLine());

            board = new Tile[Main.COLS][Main.ROWS];

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

                switch (type) {
                    case "blank":
                        tile = new TileBlank(x, y);
                        break;
                    case "treasure":
                        tile = new TileTreasure(x, y);
                        treasureCount++;
                        break;
                    case "wall":
                        tile = new TileWall(x, y);
                        break;
                    case "door":
                        tile = new TileDoor(x, y, colour);
                        break;
                    case "exit":
                        tile = new TileExit(x, y);
                        break;
                    case "info":
                        tile = new TileInfo(x, y);
                        break;
                    case "key":
                        tile = new TileKey(x, y, colour);
                        break;
                    case "exitlock":
                        tile = new TileExitLock(x, y);
                        break;
                    case "spilleddrink":
                        tile = new TileSpilledDrink(x, y);
                        break;
                    case "jaildoor":
                        tile = new TileJailDoor(x, y);
                        break;
                    case "jailwall":
                        tile = new TileJailWall(x, y);
                        break;
                    case "jailfloor":
                        tile = new TileJailFloor(x, y);
                        break;

                    default:
                        tile = null;
                        break;
                }

                board[x][y] = tile;

            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

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

    public int getStartX() {
        return Integer.parseInt(startX);
    }

    public int getStartY() {
        return Integer.parseInt(startY);
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
