package Sprint2.Change;

import java.util.ArrayList;
import java.util.List;

public class ChangeCalculator {

    protected int price;
    protected int amountReceived;
    protected int change;
    protected int changeLeft;
    List<Change> listOfChange = new ArrayList<>();
    boolean isChange;

    public ChangeCalculator(int price, int amountReceived) {
        this.price = price;
        this.amountReceived = amountReceived;
        this.change = this.expectedChange(amountReceived, price);
        this.changeLeft = this.change;
    }
    public int expectedChange(int amountReceived, int price){
        return amountReceived - price;
    }
    public String reactToAmountReceived(){
        String output = "";
        if (price > amountReceived){
            output = "Not enough money.";
        }else if(change == 0){
            output = "No change.";
        }else{
            output = "\nPrice of item: " + price + " kr. \nAmount received: " + amountReceived + " kr. \nChange: " + change + " kr.\n";
            isChange = true;
            iterateValueCounter();
        }
        return output;
    }
    public void iterateValueCounter(){
        for(NotesAndCoins n : NotesAndCoins.values()){
            if (changeLeft == 0)
                break;
            addChange(valueCounter(n.getValue()), n.getForm());
        }
    }
    public int[] valueCounter(int value){

        int[] toBeChange = new int[2];

        toBeChange[0] = value;
        toBeChange[1] = changeLeft/value;
        changeLeft = (changeLeft % value);

        return toBeChange;
    }
    public void addChange(int[] toBeChange, String form){
        //Lägg ej till i listan om valören ej ska finnas bland växeln.
        if(toBeChange[1] > 0){
            Change change = new Change(toBeChange[0], toBeChange[1],form);
            listOfChange.add(change);
        }
    }

    public List<Change> getListOfChange() {
        return listOfChange;
    }
}
