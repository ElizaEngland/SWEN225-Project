package persistence;

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

    public void readFile(String path) {

        JSONParser jsonParser = new JSONParser();
        try {

            Object obj = jsonParser.parse(new FileReader(path));
            JSONObject fileInfo = (JSONObject) obj;

            System.out.println(fileInfo);
            String time = (String) fileInfo.get("time"); // int
            JSONArray inventory = (JSONArray) fileInfo.get("inventory"); // arrayList SUSS
            String level = (String)fileInfo.get("level"); // txt file
            String treasure = (String)fileInfo.get("treasure");
            String boardmap = (String)fileInfo.get("boardMapFile");
            String x = (String)fileInfo.get("x");
            String y = (String)fileInfo.get("y");


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