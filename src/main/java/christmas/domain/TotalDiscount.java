package christmas.domain;

import java.util.ArrayList;
import java.util.List;

import static christmas.view.constant.Constant.EVENT_CONDITION;

public class TotalDiscount {
    private final List<Integer> discount;

    public TotalDiscount() {
        this.discount = new ArrayList<>();
    }

    public static boolean isEventCondition(int totalPrice) {
        return totalPrice >= EVENT_CONDITION;
    }
}
