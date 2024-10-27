package Sprint3.Change;

public class Change {

    int coinOrNote;
    int howMany;
    String form;

    public Change(int coinOrNote, int howMany, String form) {
        this.coinOrNote = coinOrNote;
        this.howMany = howMany;
        this.form = form;
    }
    @Override
    public String toString() {
        return "\nQuantity of " + coinOrNote + form + howMany;
    }
}
