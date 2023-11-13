package christmas.domain;

import java.util.Map;

import static christmas.view.constant.Constant.DAY_DISCOUNT;

public class DayEvent {
    private final int discount;

    public DayEvent(OrderMenu orderMenu, Date date) {
        this.discount = weekOrWeekend(orderMenu, date);
    }

    public int getDiscount() {
        return discount;
    }

    private int weekOrWeekend(OrderMenu orderMenu, Date date) {
        int discount = 0;
        if(!date.isWeekend()) {
            discount = applyWeekEvent(orderMenu);
        }
        if(date.isWeekend()) {
            discount = applyWeekendEvent(orderMenu);
        }
        return discount;
    }

    private int applyWeekEvent(OrderMenu orderMenu) {
        int discount = 0;
        for(Map.Entry<String, Integer> orders : OrderMenu.getEntrySet(orderMenu)) {
            String menu = orders.getKey();
            int count = orders.getValue();
            if(Menu.isDessert(menu)) {
                discount = count * DAY_DISCOUNT;
            }
        }
        return discount;
    }

    private int applyWeekendEvent(OrderMenu orderMenu) {
        int discount = 0;
        for(Map.Entry<String, Integer> orders : OrderMenu.getEntrySet(orderMenu)) {
            String menu = orders.getKey();
            int count = orders.getValue();
            if(Menu.isMainMenu(menu)) {
                discount = count * DAY_DISCOUNT;
            }
        }
        return discount;
    }
}
