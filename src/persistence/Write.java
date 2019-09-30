package persistence;

import application.Item;
import application.Main;
import maze.Board;
import maze.Tile;
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
     * Convert board into .map file
     * @param board
     * @param filePath
     * @param time
     * @return
     * @throws IOException
     */
    public String convertBoardMap(Board board,  String filePath, String time) throws IOException {
        File  file = new File(filePath + ".map");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(board.getLevelName());
        System.out.println(board.getLevelName());
//        fileWriter.write(time);
        fileWriter.write(Main.getPlayer().getX());
        fileWriter.write(Main.getPlayer().getY());

        fileWriter.close();
        return file.getPath();
    }


    /**
     * Saves the current settings of the game into a .json file
     *
     * @param filePath
     * @param time
     * @param board
     */
    public void saveJSONFile(String filePath, String time, Board board ){
        try{
            JSONObject playerObj = new JSONObject(); // create a player new obj
            playerObj.put("x", Main.getPlayer().getX()); // get x
            playerObj.put("y", Main.getPlayer().getY()); // get y
            playerObj.put("inventory", Main.getPlayer().getInventory()); // arrayList SUSS

            playerObj.put("level", board.getLevelName()); // get x
            playerObj.put("width", Main.COLS); // get y
            playerObj.put("height", Main.ROWS); // get y

            for (int row = 0; row < Main.ROWS; row++){
                for (int col = 0; col < Main.COLS; col++){
//                    playerObj.put("layout" + col + " " + row,+ col + ", " + row + ", " + board.getTile(col, row).getType() + "\n");
                }
            }


            Files.write(Paths.get(filePath+".json"), playerObj.toJSONString().getBytes());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
