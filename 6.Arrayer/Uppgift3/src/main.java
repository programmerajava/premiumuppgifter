import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        /* Ange länken till vaderdata.csv genom att högerklicka på vaderdata.csv och trycka "Copy Path".
        *  Klistra sedan in länken under csvFile.
        */
        String csvFile = "<SÄTT IN ADRESSEN HÄR>";

        // Läser in all väderdata
        LoadData data = new LoadData(csvFile);

        //Sparar undan väderdatan i fyra olika arraylists
        ArrayList<String> timestamps = data.getTimestamps();
        ArrayList<Double> barometer = data.getBarometer();
        ArrayList<Double> temp = data.getTemp();
        ArrayList<Double> rain = data.getRain();

        //Skriv ut exempeldata
        System.out.println( "Exempeldata - Tid: " + timestamps.get(0) +
                ", Barometer: " + barometer.get(0) +
                ", Temperatur: " + temp.get(0) +
                ", Mängd regn: " + rain.get(0));

    }

}