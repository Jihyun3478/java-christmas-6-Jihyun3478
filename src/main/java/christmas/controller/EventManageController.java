package christmas.controller;

import christmas.domain.Date;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventManageController {
    private final InputView inputView;
    private final OutputView outputView;

    public EventManageController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void startEventPlanner() {
        outputView.printIntroduce();
        Date date = getDate();
    }

    private Date getDate() {
        try {
            return new Date(inputView.readDate());
        } catch (IllegalArgumentException exception) {
            outputView.printDateErrorMessage();
            return getDate();
        }
    }
}
