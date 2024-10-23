package Sprint2.Change;

import java.util.Scanner;

public class MainChange {

    public static void main(String[] args) {
        MainChange m = new MainChange();
        m.mainProgram();
    }
    public void mainProgram(){
        Scanner sc = new Scanner(System.in);

        printOutput("Price of item?");
        int price = sc.nextInt();
        printOutput("Received amount?");
        int receivedAmount = sc.nextInt();

        ChangeCalculator ch = new ChangeCalculator(price, receivedAmount);
        ch.reactToAmountReceived();
        printOutput(buildString(ch));

    }
    public String buildString(ChangeCalculator ch){
        StringBuilder sb = new StringBuilder();
        sb.append(ch.reactToAmountReceived());

        if(ch.isChange)
            for (Change c : ch.getListOfChange())
                sb.append(c.toString());

        return sb.toString();
    }
    public void printOutput(String output){
        System.out.println(output);
    }
}
