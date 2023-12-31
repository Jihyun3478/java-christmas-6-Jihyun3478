package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderMenuTest {

    @Test
    @DisplayName("메뉴판에 없는 메뉴를 입력 경우에 대한 예외처리")
    void isNotContainedMenu() {
        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("콥샐러드", 1);

        assertThatThrownBy(() -> new OrderMenu(orderMenu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("메뉴의 개수가 1 이상의 숫자가 아닌 경우에 대한 예외처리")
    void isCountLessOne() {
        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("양송이수프", 0);

        assertThatThrownBy(() -> new OrderMenu(orderMenu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음료만 주문한 경우에 대한 예외처리")
    void isOrderOnlyBeverage() {
        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("제로콜라", 1);

        assertThatThrownBy(() -> new OrderMenu(orderMenu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("21개 이상의 메뉴를 주문한 경우")
    void isCountOverTwentyOne() {
        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("양송이수프", 22);

        assertThatThrownBy(() -> new OrderMenu(orderMenu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("할인 전 총 주문 금액이 일치하는지 확인한다.")
    void checkBeforeDiscountPrice() {
        Map<String, Integer> order = new HashMap<>();
        order.put("해산물파스타", 2);

        OrderMenu orderMenu = new OrderMenu(order);
        int totalPrice = OrderMenu.getTotalPrice(orderMenu);

        assertEquals(totalPrice, 70000);
    }
}