package Sprint2.Bensinförbrukning;

import java.util.Scanner;

public class FuelCon {
    public static void main(String[] args) {
        FuelCon fc = new FuelCon();
        fc.mainProgram();
        //Bäst att göra ännu en konstruktor för test, som inte läser in från Pane
        //men som kan kolla att alla parametervärden är rätt.
    }
    public void mainProgram() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Mätarinställning nu?");
        double currentMeter = Double.parseDouble(sc.nextLine().trim());
        System.out.println("Mätarinställning i fjol?");
        double lastYearsMeter = Double.parseDouble(sc.nextLine().trim());
        System.out.println("Liter bensin under året?");
        double gasConsumption = Double.parseDouble(sc.nextLine().trim());

//        double currentMeter = Double.parseDouble(JOptionPane.showInputDialog("Mätarinställning nu?").trim());
//        double lastYearsMeter = Double.parseDouble(JOptionPane.showInputDialog("Mätarinställning i fjol?").trim());
//        double gasConsumption = Double.parseDouble(JOptionPane.showInputDialog("Liter bensin under året?").trim());

        double milesThisYear = meterDifference(currentMeter, lastYearsMeter);
        double gasPerMile = gasPerMile(milesThisYear, gasConsumption);
        System.out.println(milesDriven(milesThisYear));
        System.out.println(gasUsed(gasConsumption));
        System.out.println(gasPerMile(gasPerMile));

    }
    public double meterDifference(double currentMeter, double lastYearsMeter) {
        return currentMeter - lastYearsMeter;
    }
    public double gasPerMile(double milesThisYear, double gasConsumption) {
        return milesThisYear / gasConsumption;
    }
    public String milesDriven(double milesThisYear) {
        return "Antal körda mil: " + milesThisYear;
    }
    public String gasUsed(double gasConsumption) {
        return "Antal liter bensin: " + gasConsumption;
    }
    public String gasPerMile(double gasPerMile){
        return "Förbrukning per mil: " + gasPerMile;
    }
}
