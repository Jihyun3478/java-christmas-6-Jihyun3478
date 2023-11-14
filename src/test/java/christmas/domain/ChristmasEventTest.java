package christmas.domain;

import christmas.domain.ChristmasEvent;
import christmas.domain.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChristmasEventTest {

    @ParameterizedTest
    @ValueSource(ints = {25})
    @DisplayName("크리스마스 디데이 할인이 적용되는지 확인한다.")
    void checkChristmasDiscount(int date) {
        Date theDate = new Date(date);
        ChristmasEvent christmasEvent = new ChristmasEvent(theDate);
        int christmasDiscount = christmasEvent.getDiscount();
        assertEquals(christmasDiscount, 3400);
    }
}