package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayEventTest {
    @ParameterizedTest
    @ValueSource(ints = {1})
    @DisplayName("주말 할인이 적용되는지 확인한다.")
    void checkWeekDiscount(int date) {
        Map<String, Integer> order = new HashMap<>();
        order.put("티본스테이크", 2);
        OrderMenu orderMenu = new OrderMenu(order);
        Date theDate = new Date(date);

        DayEvent dayEvent = new DayEvent(orderMenu, theDate);
        int dayDiscount = dayEvent.getDiscount();
        assertEquals(dayDiscount, 4046);
    }

    @ParameterizedTest
    @ValueSource(ints = {31})
    @DisplayName("평일 할인이 적용되는지 확인한다.")
    void checkWeekendDiscount(int date) {
        Map<String, Integer> order = new HashMap<>();
        order.put("초코케이크", 1);
        OrderMenu orderMenu = new OrderMenu(order);
        Date theDate = new Date(date);

        DayEvent dayEvent = new DayEvent(orderMenu, theDate);
        int dayDiscount = dayEvent.getDiscount();
        assertEquals(dayDiscount, 2023);
    }
}