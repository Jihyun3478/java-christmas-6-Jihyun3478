package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class OrderMenu {
    private final Map<MenuDetail, Integer> orderMenu;

    public OrderMenu(Map<String, Integer> input) {
        orderMenu = new HashMap<>();
        checkAll(input);
    }

    private void checkAll(Map<String, Integer> input) {
        checkIsNotContainedMenu(input);
        checkCountLessOne(input);
        checkOrderDuplicate(input);
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

    private void checkOrderDuplicate(Map<String, Integer> input) {
        for(String s : input.keySet()) {
            if(input.containsKey(s)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkOrderOnlyBeverage(Map<String, Integer> input) {
        for(String s : input.keySet()) {
            if(s.equals(Menu.BEVERAGE.getType())) {
                throw new IllegalArgumentException();
            }
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
