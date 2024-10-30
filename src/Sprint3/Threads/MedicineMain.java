package Sprint3.Threads;

import java.util.Scanner;

public class MedicineMain{
    Scanner sc = new Scanner(System.in);

    public MedicineMain() throws InterruptedException {

        Medicine m1 = makeNewMedicine();
        Medicine m2 = makeNewMedicine();
        Medicine m3 = makeNewMedicine();

        m1.start();
        m2.start();
        m3.start();

        Thread.sleep(10000);
        m1.interrupt();
        m2.interrupt();
        m3.interrupt();
    }
    public Medicine makeNewMedicine() {
        System.out.println("Medicinens namn:");
        String medicine = sc.next();
        System.out.println("Dos:");
        double dosage = Double.parseDouble(sc.next());
        System.out.println("Per minut:");
        int min = Integer.parseInt(sc.next());

        Medicine m = new Medicine(medicine, dosage, min);
        return m;
    }
    public static void main(String[] args) throws InterruptedException { MedicineMain m = new MedicineMain();}
}
