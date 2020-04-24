import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class LoadData {

    String csvFile;
    BufferedReader br;
    String line;
    String cvsSplitBy = ";";
    ArrayList <String> timestamps = new ArrayList<String>();
    ArrayList <String> barometer = new ArrayList<String>();
    ArrayList <String> temp = new ArrayList<String>();
    ArrayList <String> rain = new ArrayList<String>();


    LoadData(String csvFile){
        this.csvFile = csvFile;
        createData();
    }


    public void createData() {

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] row = line.split(cvsSplitBy);

                //Append all values to each arraylist
                timestamps.add(row[0]);
                barometer.add(row[1]);
                temp.add(row[2]);
                rain.add(row[3]);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //GETTERS
    public ArrayList<String> getTimestamps() {
        return timestamps;
    }

    public ArrayList<String> getBarometer() {
        return barometer;
    }

    public ArrayList<String> getTemp() {
        return temp;
    }

    public ArrayList<String> getRain() {
        return rain;
    }
}

