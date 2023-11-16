package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FreeGiftEventTest {

    @ParameterizedTest
    @ValueSource(ints = {150000, 200000, 250000})
    @DisplayName("할인 전 총 주문 금액이 12만원 이상일 경우, 샴페인 1개를 증정하는지 확인한다.")
    void checkFreeGiftDiscount(int totalPrice) {
        FreeGiftEvent freeGiftEvent = new FreeGiftEvent(totalPrice);

        assertEquals(freeGiftEvent.getDiscount(totalPrice), 25000);
    }

    @ParameterizedTest
    @ValueSource(ints = {10000, 50000, 100000})
    @DisplayName("할인 전 총 주문 금액이 12만원 미만일 경우, 증정품이 제공되지 않는지 확인한다.")
    void checkNotFreeGiftDiscount(int totalPrice) {
        FreeGiftEvent freeGiftEvent = new FreeGiftEvent(totalPrice);

        assertEquals(freeGiftEvent.getDiscount(totalPrice), 0);
    }
}