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

        // Skriv ut exempeldata
        System.out.println( "Exempeldata - Tid: " + timestamps.get(0) +
                            ", Barometer: " + barometer.get(0) +
                            ", Temperatur: " + temp.get(0) +
                            ", Mängd regn: " + rain.get(0));

        // Uppgift 2
        System.out.println("Storleken på arraylisten är: " + getSize(timestamps));

        // Uppgift 3
        System.out.println("Den högsta temperaturen som uppmättes under 2019 var: " +
                            String.format("%.2f", getMaxTemp(temp)) +
                            "° C");

        // Uppgift 4
        int maxInd = getIndOfMaxTemp(temp);
        String maxTempTimestamp = timestamps.get(maxInd);

        System.out.println("Timestampet då var: " + maxTempTimestamp +
                           " vilket motsvarar: " + getDateByTimestamp(maxTempTimestamp));


        // Uppgift 5
        System.out.println("Totalt regnade det: " + String.format("%.2f", getRainSum(rain)) +  " mm under 2019");


    }


    private static int getSize(ArrayList<?> data){
        return data.size();
    }


    private static Double getMaxTemp(ArrayList<Double> temps){

        double maxTemp = -100.0;
        for(int i = 0; i < temps.size(); i++){
            if(temps.get(i) > maxTemp){
                maxTemp = temps.get(i);
            }
        }
        return maxTemp;
    }

    private static int getIndOfMaxTemp(ArrayList<Double> temps){
        return temps.indexOf(getMaxTemp(temps));
    }


    // Konverterar ett timestamp till ett datum
    private static java.util.Date getDateByTimestamp(String maxTempTimestamp){
        return new java.util.Date((long)Long.parseLong(maxTempTimestamp)*1000);
    }


    private static double getRainSum(ArrayList<Double> rain){
        double rainSum = 0;
        for(int i = 0; i < rain.size(); i++){
            rainSum += rain.get(i);
        }
        return rainSum;
    }



}