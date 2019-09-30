package persistence;

import application.Item;
import application.Main;
import maze.Board;
import maze.Tile;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import renderer.GUI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * the time left,
 *  position of Chap and other actors (if there are any),
 *  the treasures he holds, etc.
 */

// saving file
public class Write {
    public Write() {
    }


    /**
     * Saves the current settings of the game into a .json file
     *
     * @param filePath
     * @param board
     */
    public void saveJSONFile(String filePath, String time, Board board ){
        try{
            JSONObject playerObj = new JSONObject(); // create a player new obj
            playerObj.put("x", Main.getPlayer().getX()); // get x
            playerObj.put("y", Main.getPlayer().getY()); // get y
            playerObj.put("inventory", Main.getPlayer().getInventorykeys()); // arrayList SUSS

            playerObj.put("level", board.getLevelName()); // get x
            playerObj.put("width", Main.COLS); // get y
            playerObj.put("height", Main.ROWS); // get y

            playerObj.put("time", time);
            System.out.println("current time :" + time);

            playerObj.put("inventory", Main.getPlayer().getInventorykeys()); // get x

            for (int row = 0; row < Main.ROWS; row++){
                for (int col = 0; col < Main.COLS; col++){
                    playerObj.put(col + " " + row,+ col + ", " + row + ", " + board.getTile(col, row).getType());
                }
            }


            Files.write(Paths.get(filePath+".json"), playerObj.toJSONString().getBytes());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
