package christmas.controller;

import christmas.domain.Date;
import christmas.domain.OrderMenu;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

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
        OrderMenu orderMenu = getOrderMenu();
    }

    private Date getDate() {
        try {
            return new Date(inputView.readDate());
        } catch (IllegalArgumentException exception) {
            outputView.printDateErrorMessage();
            return getDate();
        }
    }

    private OrderMenu getOrderMenu() {
        try {
            return new OrderMenu(inputView.readOrderMenu());
        } catch (IllegalArgumentException exception) {
            outputView.printMenuErrorMessage();
            return getOrderMenu();
        }
    }
}
