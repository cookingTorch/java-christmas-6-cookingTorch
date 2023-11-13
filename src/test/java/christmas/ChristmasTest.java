package christmas;

import christmas.model.Event;
import christmas.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ChristmasTest {
    private final Validator validator = new Validator();

    @DisplayName("방문 날짜가 숫자가 아니면 에러가 발생한다.")
    @Test
    void dateNotNumeric() {
        assertThatThrownBy(() -> validator.validateDate("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방문 날짜가 1보다 작으면 에러가 발생한다.")
    @Test
    void dateUnderOne() {
        assertThatThrownBy(() -> validator.validateDate("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방문 날짜가 31보다 크면 에러가 발생한다.")
    @Test
    void dateOverThirtyOne() {
        assertThatThrownBy(() -> validator.validateDate("32"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴판에 없는 메뉴를 입력하는 경우 에러가 발생한다.")
    @Test
    void orderNotInMenu() {
        assertThatThrownBy(() -> validator.validateMenu("타파스-1,포터하우스-2,바비큐립-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 개수가 1보다 작으면 에러가 발생한다.")
    @Test
    void orderLowerOne() {
        assertThatThrownBy(() -> validator.validateMenu("타파스-1,티본스테이크-0,바비큐립-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 형식이 맞지 않으면 에러가 발생한다.")
    @Test
    void orderInvalidForm() {
        assertThatThrownBy(() -> validator.validateMenu("타파스-1,티본스테이크--2,바비큐립-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 메뉴가 있으면 에러가 발생한다.")
    @Test
    void orderDuplicateMenu() {
        assertThatThrownBy(() -> validator.validateMenu("티본스테이크-1,티본스테이크-2,바비큐립-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴를 출력하기 위해 문자열을 만든다.")
    @Test
    void outputOrderMenus() {
        Event event = new Event(25, new String[] {"타파스-1","티본스테이크-2","바비큐립-1"});

        assertThat(event.buildOrderMenus())
                .contains("타파스 1개", "티본스테이크 2개", "바비큐립 1개");
    }

    @DisplayName("할인 전 총주문 금액을 계산한다.")
    @Test
    void outputTotalAmount() {
        Event event = new Event(25, new String[] {"타파스-1","티본스테이크-2","바비큐립-1"});

        assertThat(event.calculateTotalAmount())
                .isEqualTo(169500);
    }

    @DisplayName("12만 원이 넘으면 샴페인을 증정 메뉴로 반환한다.")
    @Test
    void outputComplimentaryMenu() {
        Event event = new Event(25, new String[] {"타파스-1","티본스테이크-2","바비큐립-1"});

        assertThat(event.buildComplimentaryMenu(169500))
                .contains("샴페인");
    }

    @DisplayName("12만 원이 넘지 않으면 증정 메뉴가 없다.")
    @Test
    void nothingComplimentaryMenu() {
        Event event = new Event(25, new String[] {"타파스-1","티본스테이크-1","바비큐립-1"});

        assertThat(event.buildComplimentaryMenu(114500))
                .contains("없음");
    }
}
