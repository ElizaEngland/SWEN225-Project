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
        fileWriter.write(board.getLevelName() );
        for (int row = 0; row < Main.ROWS; row++){
            for (int col = 0; col < Main.COLS; col++){
                fileWriter.write("\n" + col + ", " + row + ", " + board.getTile(col, row).getType() );
            }
        }
//        fileWriter.write(time);
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
            JSONObject jsonObj = new JSONObject(); // create a new obj
            jsonObj.put("time", time); // int
            jsonObj.put("inventory", Main.getPlayer().getInventory().toString()); // arrayList SUSS
            jsonObj.put("level", board.getLevelName()); // txt file
            jsonObj.put("treasure", board.getTreasureCount());
            jsonObj.put("boardMapFile", convertBoardMap(board, filePath, time));
            jsonObj.put("x", Main.getPlayer().getX());
            jsonObj.put("y", Main.getPlayer().getY());

            Files.write(Paths.get(filePath+".json"), jsonObj.toJSONString().getBytes());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
