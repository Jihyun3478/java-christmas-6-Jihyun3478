package christmas.domain;

import static christmas.view.constant.NumberConstant.*;

public class Date {
    private final int date;

    public Date(int date) {
        this.date = date;
        checkInputRange(date);
    }

    public int getDate() {
        return date;
    }

    private void checkInputRange(int input) {
        if(!(input >= MIN_DATE && input <= MAX_DATE)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isChristmasPeriod() {
        return this.date <= CHRISTMAS_PERIOD;
    }

    public boolean isWeekend() {
        return this.date % WEEK_NUMBER == WEEK_DIVIDE1 || this.date % WEEK_NUMBER == WEEK_DIVIDE2;
    }
}