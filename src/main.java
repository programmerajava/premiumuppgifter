import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        String csvFile = "/Users/Gustav/Dropbox/Programmering/ProgrammeraJava/Premiumuppgifter/src/vaderdata.csv";
        LoadData data = new LoadData(csvFile);

        ArrayList<String> timestamps = data.getTimestamps();
        ArrayList<String> barometer = data.getBarometer();
        ArrayList<String> temp = data.getTemp();
        ArrayList<String> rain = data.getRain();
        //System.out.println();


    }

}