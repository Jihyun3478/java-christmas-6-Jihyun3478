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
        if(!(input >= MIN_DATE_CONDITION && input <= MAX_DATE_CONDITION)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isChristmasPeriod() {
        return this.date <= CHRISTMAS_DATE_CONDITION;
    }

    public boolean isWeekend() {
        return this.date % WEEK == WEEKEND_DIVIDE_CONDITION1 || this.date % WEEK == WEEKEND_DIVIDE_CONDITION2;
    }
}