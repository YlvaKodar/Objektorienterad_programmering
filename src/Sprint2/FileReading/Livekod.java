package Sprint2.FileReading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Livekod {

    public Livekod() throws IOException {
        //Copy Path referense nån av de relativa nedre text contentroot


        try (BufferedReader br = new BufferedReader(new FileReader("src/Sprint2/FileReading/EnFilMedText.txt"));) {
            String tempString;

            while ((tempString = br.readLine()) != null) {
                System.out.println(tempString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //BufferedReader har inget stöd för att kolla vilken data den läser (typ int), men det har Scanner
        //Scanner får exeption vid slutet av filen - går att fånga upp med has element exeption eller has next line)
//        try (Scannet sc = new Scanner (new FileReader("src/Sprint2/FileReading/EnFilMedText.txt"));){
//
//        }



    }

    public static void main (String[] args){

            try {
                Livekod livekod = new Livekod();
            } catch (IOException e) {
                System.out.println("Fel");
                e.printStackTrace();
            }
    }
}
