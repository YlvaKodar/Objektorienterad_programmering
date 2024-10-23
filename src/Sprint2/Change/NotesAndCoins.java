package Sprint2.Change;

public enum NotesAndCoins {
    THOUSAND (1000, " kr. notes: "),
    FIVE_HUNDRED (500," kr. notes: "),
    TWO_HUNDRED (200, " kr. notes: "),
    ONE_HUNDRED (100, " kr. notes: "),
    FIFTY (50, " kr. notes: "),
    TWENTY (20, " kr. notes: "),
    TEN (10, " kr. coins: "),
    FIVE (5, " kr. coins: "),
    TWO (2, " kr. coins: "),
    ONE (1, " kr. coins: ");

    private final int value;
    private final String form;

    NotesAndCoins(int value, String form) {
        this.value = value;
        this.form = form;
    }
    public int getValue() {
        return value;
    }
    public String getForm() {
        return form;
    }
}
