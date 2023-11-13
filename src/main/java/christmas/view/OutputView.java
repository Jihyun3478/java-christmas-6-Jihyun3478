package christmas.view;

import static christmas.view.constant.ErrorMessage.DATE_FORMAT_ERROR_MESSAGE;
import static christmas.view.constant.ErrorMessage.MENU_FORMAT_ERROR_MESSAGE;
import static christmas.view.constant.OutputMessage.INTRODUCE_MESSAGE;
import static christmas.view.constant.OutputMessage.MENU_CHECK_MESSAGE;

public class OutputView {

    public void printIntroduce() {
        System.out.println(INTRODUCE_MESSAGE.getMessage());
    }

    public void printOrderMenu(String[] order) {
        System.out.println(MENU_CHECK_MESSAGE.getMessage());
        for (String o : order) {
            System.out.println(o);
        }
    }

    public void printDateErrorMessage() {
        System.out.println(DATE_FORMAT_ERROR_MESSAGE.getMessage());
    }

    public void printMenuErrorMessage() {
        System.out.println(MENU_FORMAT_ERROR_MESSAGE.getMessage());
    }
}