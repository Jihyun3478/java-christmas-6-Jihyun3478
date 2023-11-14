package christmas.domain;

import static christmas.view.constant.Constant.EVENT_CONDITION;

public class TotalDiscount {
    private static int discount;

    public TotalDiscount(ChristmasEvent christmasEvent, DayEvent dayEvent, SpecialEvent specialEvent, FreeGiftEvent freeGiftEvent, int totalPrice) {
        discount = calculateTotalDiscount(christmasEvent, dayEvent, specialEvent, freeGiftEvent, totalPrice);
    }

    public static int getDiscount() {
        return discount;
    }

    public static boolean isEventCondition(int totalPrice) {
        return totalPrice >= EVENT_CONDITION;
    }

    public int calculateTotalDiscount(ChristmasEvent christmasEvent, DayEvent dayEvent, SpecialEvent specialEvent, FreeGiftEvent freeGiftEvent, int totalPrice) {
        return christmasEvent.getDiscount() + dayEvent.getDiscount() + specialEvent.getDiscount() + freeGiftEvent.getDiscount(totalPrice);
    }
}
