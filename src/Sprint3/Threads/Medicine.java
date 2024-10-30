package Sprint3.Threads;

//Kan också använda interfacet runnable
public class Medicine extends Thread {
    protected String medicine;
    protected double dosage;
    protected int perMin;

    public Medicine(String medicine, double dosage, int perMin) {
        this.medicine = medicine;
        this.dosage = dosage;
        this.perMin = perMin;
    }
    @Override
    public void run() {
        while (!Thread.interrupted()){
            try{
                Thread.sleep(perMin);
                System.out.println(medicine);
                System.out.println(dosage);
            }
            catch(InterruptedException e){
                break;
            }
        }
    }
}
