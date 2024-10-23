package Sprint2.FileReading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Temp {

    public static void main(String[] args) {
        Temp t = new Temp();
        t.mainProgram();
    }
    public void mainProgram(){
        List<String> tempString;

        //tempString = this.readingFileWithBufferedFileReader("temp.txt");
        tempString = this.readingFileWithScanner("temp.txt");

        List<Double> tempDouble =convertStringToDoubleList(tempString);
        System.out.println("Medeltemperaturen är " + this.calculateMediumTemp(tempDouble) + ".");

        this.sortList(tempDouble);
        System.out.println("Den lägsta temperaturen var " + tempDouble.getFirst() + ".\nDen högsta temperaturen var " + tempDouble.getLast() + ".");
    }

    public List<String> readingFileWithScanner(String file){
        List<String> l = new ArrayList<>();

        try( Scanner sc = new Scanner(new FileReader(file))){

            while(sc.hasNextLine()){
                l.add(sc.nextLine().trim());
            }

        }catch (FileNotFoundException e){
            System.out.println("Hittar inte fil.");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("Annat fel.");
            e.printStackTrace();
        }
        return l;
    }
    public List<String> readingFileWithBufferedFileReader(String file){
        String temp;
        List<String> l = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            while ((temp = bf.readLine()) != null){
                l.add(temp.trim());
            }
        }catch (Exception e) {
            System.out.println("det blev fel");
            e.printStackTrace();
        }
        return l;
    }
    public List<Double> convertStringToDoubleList(List<String> tempString){

        List<Double> l = new ArrayList<>();

        for (String s : tempString){
            l.add(Double.parseDouble(s.replaceAll(",", ".")));
        }
        return l;
    }
    public double calculateMediumTemp (List<Double> l){
        double sumOfTemp = 0;

            for (double temp : l) {
                sumOfTemp += temp;
            }
        return sumOfTemp / l.size();
    }
    public List<Double> sortList (List<Double> list){
        Collections.sort(list);
        return list;
    }
}