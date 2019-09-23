package persistence;
import application.Main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Read class for Chip's Challenge.
 */
public class Read {
    public Read() {
    }

    public void readFile(String path) {

        JSONParser jsonParser = new JSONParser();
        try {

            Object obj = jsonParser.parse(new FileReader(path));
            JSONObject fileInfo = (JSONObject) obj;

            System.out.println(fileInfo);
            String time = (String) fileInfo.get("time"); // int
//            JSONArray inventory = (JSONArray) fileInfo.get("inventory"); // arrayList SUSS
            String level = (String)fileInfo.get("level"); // txt file
            long treasure = (long)fileInfo.get("treasure");
            String boardmap = (String)fileInfo.get("boardMapFile");
            long x = (long)fileInfo.get("x");
            long y = (long)fileInfo.get("y");

            System.out.println(time  + "\n" +  level + "\n" +  treasure + "\n" +  boardmap+ "\n" + x+ "\n" + y);
//            System.out.println(inventory);

//            fileInfo.forEach( info -> parseInfoObject((JSONObject) info));
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void parseInfoObject(JSONObject info) {
        //
    }


    //
//
//
//    try{
//
//        Object obj = parser.parse(new FileReader(new File("")));
//        JSONObject jsonObj = (JSONObject) obj;
//
//    }
//    catch(FileNotFoundException e){ e.printStackTrace(); }
//    catch(IOException e){ e.printStackTrace(); }
//    catch(ParseException e){ e.printStackTrace(); }
//    catch(Exception e) { e.printStackTrace();}

}