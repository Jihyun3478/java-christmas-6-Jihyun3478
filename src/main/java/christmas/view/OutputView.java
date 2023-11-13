package christmas.view;

import java.text.DecimalFormat;

import static christmas.view.constant.Constant.WON;
import static christmas.view.constant.ErrorMessage.DATE_FORMAT_ERROR_MESSAGE;
import static christmas.view.constant.ErrorMessage.MENU_FORMAT_ERROR_MESSAGE;
import static christmas.view.constant.OutputMessage.*;

public class OutputView {

    DecimalFormat moneyFormat = new DecimalFormat("###,###");
    public void printIntroduce() {
        System.out.println(INTRODUCE_MESSAGE.getMessage());
    }

    public void printOrderMenu(String[] order) {
        System.out.println(MENU_CHECK_MESSAGE.getMessage());
        for (String o : order) {
            System.out.println(o);
        }
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println(TOTAL_PRICE_MESSAGE.getMessage());
        System.out.println(moneyFormat.format(totalPrice) + WON);
    }

    public void printFreeGift(boolean freeGift) {
        System.out.println(FREE_GIFT_MESSAGE.getMessage());
        if(freeGift) {
            System.out.println(CHAMPAGNE_MESSAGE.getMessage());
        }
        if(!freeGift) {
            System.out.println(NONE.getMessage());
        }
    }

    public void printEventDetail() {
        System.out.println(EVENT_DETAIL_MESSAGE.getMessage());
    }

    public void printChristmasEvent(int discount) {
        System.out.println(CHRISTMAS_DISCOUNT_MESSAGE.getMessage() + moneyFormat.format(discount) + WON);
    }

    public void printDateErrorMessage() {
        System.out.println(DATE_FORMAT_ERROR_MESSAGE.getMessage());
    }

    public void printMenuErrorMessage() {
        System.out.println(MENU_FORMAT_ERROR_MESSAGE.getMessage());
    }

    public void printNone() {
        System.out.println(NONE.getMessage());
    }
}