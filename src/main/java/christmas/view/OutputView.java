package christmas.view;

import java.text.DecimalFormat;
import java.util.List;

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

    public void printDateErrorMessage() {
        System.out.println(DATE_FORMAT_ERROR_MESSAGE.getMessage());
    }

    public void printMenuErrorMessage() {
        System.out.println(MENU_FORMAT_ERROR_MESSAGE.getMessage());
    }
}