package christmas.controller;

import christmas.domain.Date;
import christmas.domain.OrderMenu;
import christmas.service.EventManageService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventManageController {
    private final InputView inputView;
    private final OutputView outputView;
    private final EventManageService eventManageService;

    public EventManageController() {
        inputView = new InputView();
        outputView = new OutputView();
        eventManageService = new EventManageService();
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
