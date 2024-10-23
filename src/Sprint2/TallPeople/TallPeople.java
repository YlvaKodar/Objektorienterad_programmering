package Sprint2.TallPeople;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;

//Gör objekt för Path med hjälpklass Paths:
// Path p = Paths.get("C:/home/joe/foo");
//      Ovan skapar Path-objekt för användaren Joe, filnamn "foo" (men den finns inte?)
// Files.createFile(p);
//      Ovan skapar upp fil i systemet (kan bara göra en gång -- lägg in if som nedan.

//            if (!Files.exists(p)) {
//        Files.createFile(p);
//            }

// Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
//      Kopierar innehållet i sourcePath till targetPath (alltså innehållet i filerna)

// Files.copy(p, p1); går bra, då skapas p1 (om du gjort ett Path)
// Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
//      Flyttar innehållet i sP till tP och skriver över eventuellt tidigare fil.
// Files.delete(p);
//      Raderar p.


//Om throws: Är det dit ansvar att ta hand om det här? Om inte kasta bort det och catscha hos den som ställt till med det.



//Gör Scanner med bufferedreader för fördelarna med bägge klasser: https://docs.oracle.com/javase/tutorial/essential/io/scanning.html
//useDelimiter(",\\s*") för att bryta vid komma blanksteg istället för white space (se huvudmetod)


public class TallPeople {

    List<Person> tallPeeps = new ArrayList<>();
    Path p = Paths.get("src/Sprint2/Tall People.txt");

    public static void main(String[] args) {
        TallPeople tp = new TallPeople();
    }
    public TallPeople() {
        this.findAndProcessTallPeopleInFile("src/Sprint2/TallPeople/Personuppgifter.txt");
    }
    //Egentligen huvudprogram
    public void findAndProcessTallPeopleInFile(String fileName) {

        String name;
        String address;
        int age = 0;
        int weight = 0;
        int height = 0;

        //useDelimiter: bryt antingen efter ,\\s (komma och space) | (eller) ,\\n (komma och ny rad)
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName))).useDelimiter(",\\s*|\\n")) {
            while (sc.hasNext()) {
                name = sc.next();   //Kommer ej i utskrift
                address = sc.next() + ", " + sc.next(); //Kommer ej i utskrift
                age = Integer.valueOf(sc.next().trim());
                weight = Integer.valueOf(sc.next().trim());
                height = Integer.valueOf(sc.next().trim());
                //System.out.println( "name " + name + "address " + address + "age " + age + "weight " + weight + "height " + height );

                if (height >= 200){
                        this.writeTallPeopleToNewFile(p, name, address, age, weight, height);
                        tallPeeps.add(new Person(name,address,age,weight,height));
               }
            }

        }catch (FileNotFoundException e){
            System.out.println("File not found.");
        }catch (IOException e){
            System.out.println("I/O exception.");
            e.printStackTrace();
        }
    }

    //Onödig return för test
    public Path writeTallPeopleToNewFile(Path p, String name, String address, int age, int weight, int height) {

        try{
            if (!Files.exists(p)) {
                Files.createFile(p);
            }
        }catch (IOException e){
            System.out.println("I/O exception.");
            e.printStackTrace();
        }

        //APPEND för att kunna skriva mer i samma fil.
        try (BufferedWriter bw = Files.newBufferedWriter(p, APPEND)){
            bw.write(name + ", " + address + "" + age + ", " + weight + ", " + height + "\n");

        }catch (IOException e){
            System.out.println("I/O exception.");
            e.printStackTrace();
            return null;
        }

        return p;
    }

    //Otestbar
    public void addToTallList(Person person) {
        tallPeeps.add(person);
    }

    public List<Person> getTallPeeps() {
        return tallPeeps;
    }
}
