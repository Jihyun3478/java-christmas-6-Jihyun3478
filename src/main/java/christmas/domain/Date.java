package christmas.domain;

public class Date {
    private final int date;

    public Date(int date) {
        this.date = date;
        checkInputRange(date);
    }

    private void checkInputRange(int input) {
        if(!(input >= 1 && input <= 31)) {
            throw new IllegalArgumentException();
        }
    }
}
