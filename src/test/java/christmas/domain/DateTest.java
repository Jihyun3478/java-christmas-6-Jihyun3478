package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class DateTest {

    @DisplayName("방문할 날짜가 1 이상 31 이하의 숫자가 아닌 경우에 대한 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {0, 32})
    void dateRangeOut(int input) {
        assertThatThrownBy(() -> new Date(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}