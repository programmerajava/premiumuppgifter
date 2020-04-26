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
    ArrayList <Float> barometer = new ArrayList<Float>();
    ArrayList <Float> temp = new ArrayList<Float>();
    ArrayList <Float> rain = new ArrayList<Float>();


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
                barometer.add(Float.parseFloat(row[1].replace(',', '.')));
                temp.add(Float.parseFloat(row[2].replace(',', '.')));
                rain.add(Float.parseFloat(row[3].replace(',', '.')));

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

    public ArrayList<Float> getBarometer() {
        return barometer;
    }

    public ArrayList<Float> getTemp() {
        return temp;
    }

    public ArrayList<Float> getRain() {
        return rain;
    }
}

