package persistence;

import application.ItemKey;
import application.Main;
import maze.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Read class reads the .json file into Chip's Challenge and sets the game up from the specified settings.
 */
public class Read {

    /**
     * Reads the .JSON file and sets the game up.
     *
     * @param path
     * @param board
     * @return Tile grid
     */
    public static Tile[][] readFile(String path, Board board) {

        Tile[][] grid;

        JSONParser jsonParser = new JSONParser();
        try {
            boolean fileFound = Files.exists(Paths.get(path));
            if (fileFound) {
                Object obj = jsonParser.parse(new FileReader(path));
                JSONObject fileInfo = (JSONObject) obj;

                Main.COLS = Math.toIntExact((long) fileInfo.get("width")); // int
                Main.ROWS = Math.toIntExact((long) fileInfo.get("height")); // int

                grid = new Tile[Main.COLS][Main.ROWS];

                int x = Math.toIntExact((long) fileInfo.get("x"));
                int y = Math.toIntExact((long) fileInfo.get("y"));

                board.setStartX(x);
                board.setStartY(y);
                board.setLevelName((String) fileInfo.get("level"));
                board.setDescription((String) fileInfo.get("description"));

                String paused = (String) fileInfo.get("paused");

                if (paused.equals("true")) {
                    Main.setPaused(true);
                } else {
                    Main.setPaused(false);
                }

                JSONArray inventoryArray = (JSONArray) fileInfo.get("inventory");
                if (!inventoryArray.isEmpty()) {
                    for (Object i : inventoryArray) {
                        board.addInventory(new ItemKey(i.toString()));
                    }
                }

                int time = Integer.parseInt(String.valueOf(fileInfo.get("time")));

                Main.maxTime = time + Main.getTime();

                for (int row = 0; row < Main.ROWS; row++) {
                    for (int col = 0; col < Main.COLS; col++) {
                        String token = (String) fileInfo.get(col + " " + row);
                        grid[col][row] = helperMethod(token, board);
                    }
                }

                return grid;

            } else {
                throw new FileNotFoundException("File not found");
            }
        } catch (ParseException | IOException ex) {
            ex.printStackTrace();
        }

        return null;

    }

    /**
     * Read the token passed through and converts it into a tile to place on the board
     *
     * @param info
     * @param board
     * @return Tile
     */
    private static Tile helperMethod(String info, Board board) {
        String[] tokens = info.split(", ");

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
                board.treasureCount++;
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
            case "cop":
                tile = new TileCop(x, y);
                break;
            case "enemy":
                tile = new TileEnemy(x, y);
                board.enemies.add(tile);
                break;
            default:
                tile = null;
                break;
        }

        return tile;

    }

}