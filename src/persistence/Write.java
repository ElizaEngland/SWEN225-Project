package persistence;


import application.Main;
import maze.Board;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The Write class saves the current state of the game to a .json file specified by the user.
 *
 * @author - Ben Robertson, Eliza England, Ethan King, Jacqueline Dong, Jay Patel, Mason Yi
 */

public class Write {

    /**
     * Saves the current settings of the game into a .json file.
     *
     * @param filePath
     * @param board
     */
    public void saveJSONFile(String filePath, String time, Board board) {
        try {
            JSONObject playerObj = new JSONObject(); // create a player new obj
            playerObj.put("x", Main.getPlayer().getX()); // get x
            playerObj.put("y", Main.getPlayer().getY()); // get y
            playerObj.put("inventory", Main.getPlayer().getInventoryKeys()); // arrayList SUSS

            playerObj.put("level", board.getLevelName()); // get x
            playerObj.put("width", Main.COLS); // get y
            playerObj.put("height", Main.ROWS); // get y

            playerObj.put("description", board.getDescription());
            playerObj.put("paused", "true");

            playerObj.put("time", time);

            playerObj.put("inventory", Main.getPlayer().getInventoryKeys()); // get x

            for (int row = 0; row < Main.ROWS; row++) {
                for (int col = 0; col < Main.COLS; col++) {
                    playerObj.put(col + " " + row, +col + ", " + row + ", " + board.getTile(col, row).getType());
                }
            }

            Files.write(Paths.get(filePath + ".json"), playerObj.toJSONString().getBytes());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
