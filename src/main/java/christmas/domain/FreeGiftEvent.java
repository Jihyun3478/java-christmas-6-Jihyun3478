package christmas.domain;

import static christmas.view.constant.Constant.FREE_GIFT_CONDITION;
import static christmas.view.constant.Constant.FREE_GIFT_DISCOUNT;

public class FreeGiftEvent {

    private int discount = 0;

    public FreeGiftEvent(int totalPrice) {
        discount = getDiscount(totalPrice);
    }

    public int getDiscount(int totalPrice) {
        if(isContainFreeGift(totalPrice)) {
            return FREE_GIFT_DISCOUNT;
        }
        return 0;
    }

    public static boolean isContainFreeGift(int totalPrice) {
        return totalPrice >= FREE_GIFT_CONDITION;
    }
}
