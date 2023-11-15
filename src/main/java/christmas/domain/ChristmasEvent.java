package christmas.domain;

import static christmas.view.constant.NumberConstant.*;

public class ChristmasEvent {
    private final int discount;

    public ChristmasEvent(Date date) {
        this.discount = applyChristmasEvent(date);
    }

    public int getDiscount() {
        return discount;
    }

    private int applyChristmasEvent(Date date) {
        int discount = 0;
        if(date.isChristmasPeriod()) {
            discount = calculateChristmasDiscount(date);
        }
        return discount;
    }

    private int calculateChristmasDiscount(Date date) {
        int discount = DEFAULT_DISCOUNT;
        int theDate = date.getDate();
        for(int i = MIN_DATE+1; i <= theDate; i++) {
            discount += CHRISTMAS_DISCOUNT;
        }
        return discount;
    }
}
