package maze;

import application.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Board {

    private Tile[][] board = new Tile[Main.WIDTH][Main.HEIGHT];

    public Board() {

        try {

            File rooms = new File("./src/level1.txt");   // MARKER: Please ensure this file is in the correct directory

            BufferedReader reader = new BufferedReader(new FileReader(rooms));

            String targetLine;

            while ((targetLine = reader.readLine()) != null) {

                String[] tokens = targetLine.split(" ");

                int x = Integer.parseInt(tokens[0]);    // x
                int y = Integer.parseInt(tokens[1]);    // y
                String type = tokens[2];            // tile type

                Tile tile;

                if (type.equals("blank")) {
                    tile = new TileBlank(x, y);
                } else if (type.equals("treasure")) {
                    tile = new TileTreasure(x,y);
                } else if (type.equals("wall")) {
                    tile = new TileWall(x,y);
                } else {
                    tile = null;
                }

                board[x][y] = tile;

            }

        } catch (IOException e) { System.out.println("Error: " + e); }

    }

    public Tile[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        for (int y = 0; y < Main.HEIGHT; y++) {
            for (int x = 0; x < Main.WIDTH; x++) {
                Tile t = board[x][y];
                result.append(t);
            }
            result.append("\n");
        }

        return result.toString();

    }


}
