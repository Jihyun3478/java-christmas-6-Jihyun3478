package christmas.domain;

import java.util.Map;

import static christmas.view.constant.Constant.BLANK;
import static christmas.view.constant.Constant.COUNT;

public class OrderMenu {
    private final Map<String, Integer> orderMenu;

    public OrderMenu(Map<String, Integer> orderMenu) {
        this.orderMenu = orderMenu;
        checkAll(orderMenu);
    }

    public int size() {
        return orderMenu.size();
    }

    public static int getTotalPrice(OrderMenu orderMenu) {
        int totalPrice = 0;
        for(Map.Entry<String, Integer> orders : orderMenu.orderMenu.entrySet()) {
            int price = MenuDetail.getPrice(orders.getKey());
            int count = orders.getValue();
            totalPrice += calculateTotalPrice(price, count);
        }
        return totalPrice;
    }

    private static int calculateTotalPrice(int price, int count) {
        return price * count;
    }

    public String[] getOrder() {
        String[] result = new String[orderMenu.size()];
        int index = 0;
        for(Map.Entry<String, Integer> orders : orderMenu.entrySet()) {
            String order = orders.getKey() + BLANK + orders.getValue() + COUNT;
            result[index] = order;
            index++;
        }
        return result;
    }

    private void checkAll(Map<String, Integer> input) {
        checkIsNotContainedMenu(input);
        checkCountLessOne(input);
        checkOrderOnlyBeverage(input);
        checkCountOverTwentyOne(input);
    }

    private void checkIsNotContainedMenu(Map<String, Integer> input) {
        for(String s : input.keySet()) {
            if(!MenuDetail.isContain(s)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkCountLessOne(Map<String, Integer> input) {
        for(Integer i : input.values()) {
            if(i < 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkOrderOnlyBeverage(Map<String, Integer> input) {
        if (Menu.isOnlyBeverage(input)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkCountOverTwentyOne(Map<String, Integer> input) {
        int count = 0;
        for(Integer i : input.values()) {
            count += i;
            if (count >= 21) {
                throw new IllegalArgumentException();
            }
        }
    }
}
