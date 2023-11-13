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

    @DisplayName("메뉴판에 없는 메뉴를 입력하는 경우 에러가 발생한다.")
    @Test
    void orderNotInMenu() {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.validateMenu("타파스-1,포터하우스-2,바비큐립-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 개수가 1보다 작으면 에러가 발생한다.")
    @Test
    void orderLowerOne() {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.validateMenu("타파스-1,티본스테이크-0,바비큐립-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 형식이 맞지 않으면 에러가 발생한다.")
    @Test
    void orderInvalidForm() {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.validateMenu("타파스-1,티본스테이크--2,바비큐립-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 메뉴가 있으면 에러가 발생한다.")
    @Test
    void orderDuplicateMenu() {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.validateMenu("티본스테이크-1,티본스테이크-2,바비큐립-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
