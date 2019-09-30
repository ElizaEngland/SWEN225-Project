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

/**
 * Read class for Chip's Challenge.
 */
public class Read {
    public Read() {
    }

    /**
     * Reads the .JSON file and sets the game up
     * @param path
     * @param board
     * @return
     */
    public static Tile[][] readFile(String path, Board board) {

        Tile[][] grid;

        JSONParser jsonParser = new JSONParser();
        try {
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

            JSONArray inventoryArray = (JSONArray) fileInfo.get("inventory");
            if (!inventoryArray.isEmpty()){
                for (Object i : inventoryArray){
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

        } catch (ParseException | IOException ex) {
            ex.printStackTrace();
        }

        return null;

    }

    /**
     * read the token passed through and converts it into a tile to place on the board
     * @param info
     * @param board
     * @return
     */
    public static Tile helperMethod(String info, Board board) {
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
            default:
                tile = null;
                break;
        }

        return tile;

    }

}