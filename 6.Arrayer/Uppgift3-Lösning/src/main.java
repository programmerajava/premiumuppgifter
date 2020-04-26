import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        /* Ange länken till vaderdata.csv genom att högerklicka på vaderdata.csv och trycka "Copy Path".
        *  Klistra sedan in länken under csvFile.
        */
        String csvFile = "/Users/Gustav/Dropbox/Programmering/ProgrammeraJava/premiumuppgifter/6.Arrayer/Uppgift3-Lösning/src/vaderdata.csv";

        // Läser in all väderdata
        LoadData data = new LoadData(csvFile);

        //Sparar undan väderdatan i fyra olika arraylists
        ArrayList<String> timestamps = data.getTimestamps();
        ArrayList<Float> barometer = data.getBarometer();
        ArrayList<Float> temp = data.getTemp();
        ArrayList<Float> rain = data.getRain();

        //Skriv ut exempeldata
        System.out.println( "Tid: " + timestamps.get(0) +
                            " Barometer: " + barometer.get(0) +
                            " Temperatur: " + temp.get(0) +
                            " Mängd regn: " + rain.get(0));

        System.out.println(temp.get(0) > temp.get(1));
    }

}