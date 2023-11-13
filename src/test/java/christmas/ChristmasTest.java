package christmas;

import christmas.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ChristmasTest {
    @DisplayName("방문 날짜가 숫자가 아니면 에러가 발생한다.")
    @Test
    void dateNotNumeric() {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.validateDate("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방문 날짜가 1보다 작으면 에러가 발생한다.")
    @Test
    void dateUnderOne() {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.validateDate("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방문 날짜가 31보다 크면 에러가 발생한다.")
    @Test
    void dateOverThirtyOne() {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.validateDate("32"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
