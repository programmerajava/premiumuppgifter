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
        double maxTemp = getMaxValueInArraylist(temp);
        System.out.println("Den högsta temperaturen som uppmättes under 2019 var: " +
                            String.format("%.2f", maxTemp) +
                            "° C");


        // Uppgift 4
        int maxInd = getIndOfVal(temp, maxTemp);
        String maxTempTimestamp = timestamps.get(maxInd);


        System.out.println("Timestampet då var: " + maxTempTimestamp +
                           " vilket motsvarar: " + getDateByTimestamp(maxTempTimestamp));


        // Uppgift 5
        System.out.println("Totalt regnade det: " + String.format("%.2f", getRainSum(rain)) +  " mm under 2019");

        // Uppgift 6
        double minBarometer = getMinValueInArraylist(barometer);
        int minBarometerInd = getIndOfVal(barometer, minBarometer);
        String minBarometerTimestamp = timestamps.get(minBarometerInd);

        System.out.println("Det lägsta uppmätta lufttrycket var: " + minBarometer +
                           ", timestampet då var: " + minBarometerTimestamp +
                           ", vilket motsvarar: " + getDateByTimestamp(minBarometerTimestamp));


        // Uppgift 7
        System.out.println("Medeltemperaturen under 2019 var: " +  String.format("%.2f", getMeanTemp(temp)) + "° C");



    }


    /**
     * Returnera storleken på arraylisten av godtycklig datatyp.
     * ArrayList<?> betyder att vi inte bryr oss om vilken datatyp vi har i Arraylisten.
     * Denna metod kommer alltså fungera för alla arraylists, oavset datatyp
     * Returnerar längden av arraylisten i form av en int
     */
    private static int getSize(ArrayList<?> data){
        return data.size();
    }


    /**
    * Input: En arraylist av datatypen double
    * Returnerar: Maxvärdet i arraylisten i form av en double
    * Stegar igenom alla värden i arraylisten och sparar undan det värde som är störst.
    * Observera att denna metod utgår från att det endast finns ett högsta värde!
    */
    private static Double getMaxValueInArraylist(ArrayList<Double> arr){

        double maxVal= -100000.0;
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) > maxVal){
                maxVal = arr.get(i);
            }
        }
        return maxVal;
    }


    /**
    * Input: En arraylist av datatypen double
    * Returnerar: Minsta värdet i arraylisten i form av en double
    * Stegar igenom alla värden i arraylisten och sparar undan det värde som är minst.
    * Observera att denna metod utgår från att det endast finns ett minsta värde!
    */
    private static double getMinValueInArraylist(ArrayList<Double> arr){
        double minVal = 1000000;
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) < minVal){
                minVal = arr.get(i);
            }
        }
        return minVal;
    }

    /**
     * arr: en arraylist bestående av doubles
     * val: ett värde som finns i arraylisten
     * Returnerar indexet där värdet ligger i arraylisten
     * Observera att metoden utgår från att värdet finns i arraylisten
     */
    private static int getIndOfVal(ArrayList<Double> arr, double val){
        return arr.indexOf(val);
    }


    /**
    * Input: Ett unix-timestamp av datatypen String
    * Returnerar: Ett datum i av datatypen java.util.Date
    */
    private static java.util.Date getDateByTimestamp(String timestamp){
        return new java.util.Date((long)Long.parseLong(timestamp)*1000);
    }


    /**
    * Summerar alla värden i arraylisten
    * Input: En Arraylist bestående av doubles.
    * Returnerar: Summan av alla värden i arraylisten
    * */
    private static double getRainSum(ArrayList<Double> rain){
        double rainSum = 0;
        for(int i = 0; i < rain.size(); i++){
            rainSum += rain.get(i);
        }
        return rainSum;
    }


    /**
     * Summerar alla värden i arraylisten och returnerar medelvärdet av arraylisten.
     * Input: En arraylisten bestående av doubles
     * Returnerar: Medelvärdet av alla värden i arraylisten
     */
    private static double getMeanTemp(ArrayList<Double> arr){
        double sum = 0;
        for(int i = 0; i < arr.size(); i++){
            sum += arr.get(i);
        }

        return sum/(arr.size());
    }





}