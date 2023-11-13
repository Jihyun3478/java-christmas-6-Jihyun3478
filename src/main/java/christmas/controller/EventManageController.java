package christmas.controller;

import christmas.domain.ChristmasEvent;
import christmas.domain.Date;
import christmas.domain.TotalDiscount;
import christmas.domain.OrderMenu;
import christmas.service.EventManageService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

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
        printOrderMenu(orderMenu);
        int totalPrice = printTotalPrice(orderMenu);
        printFreeGift(totalPrice);
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

    private void printOrderMenu(OrderMenu orderMenu) {
        String[] order = orderMenu.getOrder();
        outputView.printOrderMenu(order);
    }

    private int printTotalPrice(OrderMenu orderMenu) {
        int totalPrice = OrderMenu.getTotalPrice(orderMenu);
        outputView.printTotalPrice(totalPrice);

        return totalPrice;
    }

    private void printFreeGift(int totalPrice) {
        boolean isContainFreeGift = OrderMenu.isContainFreeGift(totalPrice);
        outputView.printFreeGift(isContainFreeGift);
    }
}
