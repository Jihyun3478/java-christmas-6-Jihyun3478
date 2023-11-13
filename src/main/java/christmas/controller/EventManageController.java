package christmas.controller;

import christmas.domain.*;
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

        outputView.printEventDetail();
        if(TotalDiscount.isEventCondition(totalPrice)) {
            ChristmasEvent christmasEvent = new ChristmasEvent(date);
            printChristmasEvent(christmasEvent);
            DayEvent dayEvent = new DayEvent(orderMenu, date);
            printDayEvent(date, dayEvent);
        }

        if(!TotalDiscount.isEventCondition(totalPrice)) {
            outputView.printNone();
        }
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

    private void printChristmasEvent(ChristmasEvent christmasEvent) {
        int discount = christmasEvent.getDiscount();
        outputView.printChristmasEvent(discount);
    }

    private void printDayEvent(Date date, DayEvent dayEvent) {
        int discount = dayEvent.getDiscount();
        if(!(discount == 0)) {
            outputView.printDayEvent(date, discount);
        }
    }
}
