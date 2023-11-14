package christmas.domain;

import christmas.domain.Date;
import christmas.domain.SpecialEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecialEventTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    @DisplayName("특별 할인이 적용되는지 확인한다.")
    void checkSpecialDiscount(int date) {
        Date theDate = new Date(date);
        SpecialEvent specialEvent = new SpecialEvent(theDate);

        assertEquals(specialEvent.getDiscount(), 1000);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 5, 6, 7})
    @DisplayName("특별 할인이 적용이 안되는지 확인한다.")
    void checkNotSpecialDiscount(int date) {
        Date theDate = new Date(date);
        SpecialEvent specialEvent = new SpecialEvent(theDate);

        assertEquals(specialEvent.getDiscount(), 0);
    }
}