package christmas.domain;

import java.util.Map;
import java.util.Set;

import static christmas.view.constant.OutputConstant.*;
import static christmas.view.constant.NumberConstant.*;

public class OrderMenu {
    private final Map<String, Integer> orderMenu;

    public OrderMenu(Map<String, Integer> orderMenu) {
        this.orderMenu = orderMenu;
        checkAll(orderMenu);
    }

    public int size() {
        return orderMenu.size();
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

    public static Set<Map.Entry<String, Integer>> getEntrySet(OrderMenu orderMenu) {
        return orderMenu.orderMenu.entrySet();
    }

    public static int getTotalPrice(OrderMenu orderMenu) {
        int totalPrice = 0;
        for(Map.Entry<String, Integer> orders : getEntrySet(orderMenu)) {
            int price = MenuDetail.getPrice(orders.getKey());
            int count = orders.getValue();
            totalPrice += calculateTotalPrice(price, count);
        }
        return totalPrice;
    }

    private static int calculateTotalPrice(int price, int count) {
        return price * count;
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
            if(i < MIN_MENU_COUNT) {
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
            if (count >= MAX_MENU_COUNT) {
                throw new IllegalArgumentException();
            }
        }
    }
}
