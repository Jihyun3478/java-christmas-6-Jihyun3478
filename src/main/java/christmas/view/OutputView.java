package christmas.view;

import static christmas.view.constant.ErrorMessage.DATE_FORMAT_ERROR_MESSAGE;
import static christmas.view.constant.OutputMessage.INTRODUCE_MESSAGE;

public class OutputView {

    public void printIntroduce() {
        System.out.println(INTRODUCE_MESSAGE.getMessage());
    }

    public void printDateErrorMessage() {
        System.out.println(DATE_FORMAT_ERROR_MESSAGE.getMessage());
    }
}
