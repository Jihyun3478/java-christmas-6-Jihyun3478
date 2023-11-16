package christmas.domain;

import static christmas.view.constant.NumberConstant.FREE_GIFT_CONDITION;
import static christmas.view.constant.NumberConstant.FREE_GIFT_DISCOUNT;

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

    public static int getTotalDiscountPrice(int totalPrice, int totalDiscount) {
        int totalDiscountPrice = 0;
        if(isContainFreeGift(totalPrice)) {
            totalDiscountPrice = withFreeGiftPrice(totalPrice, totalDiscount);
        }
        if(!isContainFreeGift(totalPrice)) {
            totalDiscountPrice = withoutFreeGiftPrice(totalPrice, totalDiscount);
        }
        return totalDiscountPrice;
    }

    private static int withFreeGiftPrice(int totalPrice, int totalDiscount) {
        return totalPrice - totalDiscount + FREE_GIFT_DISCOUNT;
    }

    private static int withoutFreeGiftPrice(int totalPrice, int totalDiscount) {
        return totalPrice - totalDiscount;
    }
}
