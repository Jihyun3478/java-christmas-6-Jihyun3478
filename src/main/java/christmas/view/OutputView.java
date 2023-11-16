package christmas.view;

import christmas.domain.Date;

import java.text.DecimalFormat;

import static christmas.view.constant.OutputConstant.MONEY_FORMAT;
import static christmas.view.constant.OutputConstant.WON;
import static christmas.view.constant.ErrorMessage.DATE_FORMAT_ERROR_MESSAGE;
import static christmas.view.constant.ErrorMessage.MENU_FORMAT_ERROR_MESSAGE;
import static christmas.view.constant.OutputMessage.*;

public class OutputView {

    DecimalFormat moneyFormat = new DecimalFormat(MONEY_FORMAT);

    public void printIntroduce() {
        System.out.println(INTRODUCE_MESSAGE.getMessage());
    }

    public void printOrderMenu(String[] orders) {
        System.out.println(MENU_CHECK_MESSAGE.getMessage());
        for (String order : orders) {
            System.out.println(order);
        }
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println(TOTAL_PRICE_MESSAGE.getMessage());
        System.out.println(moneyFormat.format(totalPrice) + WON);
    }

    public void printFreeGift(boolean isContainFreeGift) {
        System.out.println(FREE_GIFT_MESSAGE.getMessage());
        if(isContainFreeGift) {
            System.out.println(CHAMPAGNE_MESSAGE.getMessage());
        }
        if(!isContainFreeGift) {
            System.out.println(NONE.getMessage());
        }
    }

    public void printEventDetail() {
        System.out.println(EVENT_DETAIL_MESSAGE.getMessage());
    }

    public void printChristmasEvent(int discount) {
        System.out.println(CHRISTMAS_DISCOUNT_MESSAGE.getMessage() + moneyFormat.format(discount) + WON);
    }

    public void printDayEvent(Date date, int discount) {
        if(date.isWeekend()) {
            System.out.println(WEEK_DISCOUNT_MESSAGE.getMessage() + moneyFormat.format(discount) + WON);
        }
        if(!date.isWeekend()) {
            System.out.println(WEEKEND_DISCOUNT_MESSAGE.getMessage() + moneyFormat.format(discount) + WON);
        }
    }

    public void printSpecialEvent(int discount) {
        System.out.println(SPECIAL_DISCOUNT_MESSAGE.getMessage() + moneyFormat.format(discount) + WON);
    }

    public void printFreeGiftEvent(int count, boolean isContainFreeGift) {
        if(isContainFreeGift) {
            System.out.println(FREE_GIFT_DISCOUNT_MESSAGE.getMessage() + moneyFormat.format(count) + WON);
        }
        if(!isContainFreeGift) {
            System.out.println(FREE_GIFT_DISCOUNT_MESSAGE.getMessage() + NONE);
        }
    }

    public void printNotExistEvent() {
        System.out.println(NONE.getMessage());
    }

    public void printTotalDiscount(int totalDiscount) {
        if(totalDiscount == 0) {
            System.out.println(TOTAL_DISCOUNT_MESSAGE.getMessage() + ZERO.getMessage());
        }
        if(totalDiscount != 0) {
            System.out.println(TOTAL_DISCOUNT_MESSAGE.getMessage() + moneyFormat.format(totalDiscount*-1) + WON);
        }
    }

    public void printTotalDiscountPrice(int totalDiscountPrice) {
        System.out.println(TOTAL_DISCOUNT_PRICE_MESSAGE.getMessage() + moneyFormat.format(totalDiscountPrice) + WON);
    }

    public void printBadge(String badgeDetail) {
        System.out.println(BADGE_MESSAGE.getMessage() + badgeDetail);
    }

    public void printDateErrorMessage() {
        System.out.println(DATE_FORMAT_ERROR_MESSAGE.getMessage());
    }

    public void printMenuErrorMessage() {
        System.out.println(MENU_FORMAT_ERROR_MESSAGE.getMessage());
    }
}