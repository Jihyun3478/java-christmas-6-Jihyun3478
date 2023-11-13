package christmas.domain;

import static christmas.view.constant.Constant.MAX_NUMBER;
import static christmas.view.constant.Constant.MIN_NUMBER;

public class Date {
    private final int date;

    public Date(int date) {
        this.date = date;
        checkInputRange(date);
    }

    private void checkInputRange(int input) {
        if(!(input >= MIN_NUMBER && input <= MAX_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isChristmasPeriod() {
        return this.date <= 25;
    }

    public boolean isWeekend() {
        return this.date % 7 == 1 || this.date % 7 == 2;
    }

    public int getDate() {
        return date;
    }
}
