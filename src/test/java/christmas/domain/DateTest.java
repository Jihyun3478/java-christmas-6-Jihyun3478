package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class DateTest {

    @DisplayName("1 이상 31 이하가 아닌 날짜에 대한 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {0, 32})
    void RangeOutDate(int input) {
        assertThatCode(() -> new Date(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}