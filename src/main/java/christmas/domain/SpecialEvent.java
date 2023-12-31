package christmas.domain;

import java.util.Arrays;
import java.util.List;

import static christmas.view.constant.NumberConstant.DEFAULT_CHRISTMAS_DISCOUNT;

public class SpecialEvent {
    private static final List<Integer> star = Arrays.asList(3, 10, 17, 24, 25, 31);
    private final int discount;

    public SpecialEvent(Date date) {
        this.discount = applySpecialEvent(date);
    }

    public int getDiscount() {
        return discount;
    }

    private int applySpecialEvent(Date date) {
        int discount = 0;
        if(star.contains(date.getDate())) {
            discount = DEFAULT_CHRISTMAS_DISCOUNT;
        }
        return discount;
    }
}
