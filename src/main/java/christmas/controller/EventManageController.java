package christmas.controller;

import christmas.domain.*;
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
        OrderMenu orderMenu = getOrderMenu();
        printOrderMenu(orderMenu);

        int totalPrice = printTotalPrice(orderMenu);
        printFreeGift(totalPrice);

        outputView.printEventDetail();
        getEventDetail(date, orderMenu, totalPrice);

        int totalDiscount = printTotalDiscount();
        printTotalDiscountPrice(totalPrice, totalDiscount);
        printBadge(totalDiscount);
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

    private void getEventDetail(Date date, OrderMenu orderMenu, int totalPrice) {
        if(TotalDiscount.isEventCondition(totalPrice)) {
            manageEvent(date, orderMenu, totalPrice);
        }

        if(!TotalDiscount.isEventCondition(totalPrice)) {
            outputView.printNotExistEvent();
        }
    }

    private void manageEvent(Date date, OrderMenu orderMenu, int totalPrice) {
        ChristmasEvent christmasEvent = getChristmasEvent(date);
        DayEvent dayEvent = getDayEvent(date, orderMenu);
        SpecialEvent specialEvent = getSpecialEvent(date);
        FreeGiftEvent freeGiftEvent = getFreeGiftEvent(totalPrice);
        TotalDiscount total = new TotalDiscount(christmasEvent, dayEvent, specialEvent, freeGiftEvent, totalPrice);
    }

    private ChristmasEvent getChristmasEvent(Date date) {
        ChristmasEvent christmasEvent = new ChristmasEvent(date);
        int discount = christmasEvent.getDiscount();

        outputView.printChristmasEvent(discount);
        return christmasEvent;
    }

    private DayEvent getDayEvent(Date date, OrderMenu orderMenu) {
        DayEvent dayEvent = new DayEvent(orderMenu, date);
        int discount = dayEvent.getDiscount();

        if(!(discount == 0)) {
            outputView.printDayEvent(date, discount);
        }
        return dayEvent;
    }

    private SpecialEvent getSpecialEvent(Date date) {
        SpecialEvent specialEvent = new SpecialEvent(date);
        int discount = specialEvent.getDiscount();

        if(!(discount == 0)) {
            outputView.printSpecialEvent(discount);
        }
        return specialEvent;
    }

    private FreeGiftEvent getFreeGiftEvent(int totalPrice) {
        FreeGiftEvent freeGiftEvent = new FreeGiftEvent(totalPrice);
        int count = freeGiftEvent.getDiscount(totalPrice);
        boolean isContainFreeGift = FreeGiftEvent.isContainFreeGift(totalPrice);

        outputView.printFreeGiftEvent(count, isContainFreeGift);

        return freeGiftEvent;
    }

    private static String getBadge(int totalDiscount) {
        Badge badge = new Badge(totalDiscount);
        return badge.giveBadge(totalDiscount);
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
        boolean isContainFreeGift = FreeGiftEvent.isContainFreeGift(totalPrice);
        outputView.printFreeGift(isContainFreeGift);
    }

    private int printTotalDiscount() {
        int totalDiscount = TotalDiscount.getDiscount();
        outputView.printTotalDiscount(totalDiscount);
        return totalDiscount;
    }

    private void printTotalDiscountPrice(int totalPrice, int totalDiscount) {
        int totalDiscountPrice = FreeGiftEvent.getTotalDiscountPrice(totalPrice, totalDiscount);
        outputView.printTotalDiscountPrice(totalDiscountPrice);
    }

    private void printBadge(int totalDiscount) {
        String badgeDetail = getBadge(totalDiscount);
        outputView.printBadge(badgeDetail);
    }
}