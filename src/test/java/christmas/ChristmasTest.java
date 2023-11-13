package christmas;

import christmas.model.Event;
import christmas.util.Calculator;
import christmas.util.TextUtil;
import christmas.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ChristmasTest {
    private final Validator validator = new Validator();
    private final Calculator calculator = new Calculator();
    private final TextUtil textUtil = new TextUtil();

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
                .isEqualTo("샴페인 1개");
    }

    @DisplayName("12만 원이 넘지 않으면 증정 메뉴가 없다.")
    @Test
    void nothingComplimentaryMenu() {
        Event event = new Event(25, new String[] {"타파스-1","티본스테이크-1","바비큐립-1"});

        assertThat(event.buildComplimentaryMenu(114500))
                .isEqualTo("없음");
    }

    @DisplayName("혜택 내역에 출력할 숫자들을 계산한다.")
    @Test
    void outputBenefitAmounts() {
        Event event = new Event(25, new String[] {"타파스-1","티본스테이크-2","바비큐립-1"});

        assertThat(event.calculateBenefitAmounts(169500))
                .containsExactly(3400, 0, 0, 1000, 25000);
    }

    @DisplayName("혜택이 있는 내역들만 출력한다.")
    @Test
    void outputBenefitDetails() {
        Event event = new Event(25, new String[] {"타파스-1","티본스테이크-2","바비큐립-1"});
        List<Integer> benefitAmounts = event.calculateBenefitAmounts(169500);

        assertThat(textUtil.buildBenefitDetails(benefitAmounts))
                .containsExactly("크리스마스 디데이 할인: -3,400원", "특별 할인: -1,000원", "증정 이벤트: -25,000원");
    }

    @DisplayName("받는 혜택이 없으면 없음을 출력한다.")
    @Test
    void nothingBenefitDetails() {
        Event event = new Event(26, new String[] {"타파스-1","티본스테이크-1","바비큐립-1"});
        List<Integer> benefitAmounts = event.calculateBenefitAmounts(114500);

        assertThat(textUtil.buildBenefitDetails(benefitAmounts))
                .containsExactly("없음");
    }

    @DisplayName("혜택 내역의 금액을 모두 더해 총혜택 금액을 구한다.")
    @Test
    void outputTotalBenefit() {
        Event event = new Event(25, new String[] {"타파스-1","티본스테이크-2","바비큐립-1"});
        List<Integer> benefitAmounts = event.calculateBenefitAmounts(169500);

        assertThat(calculator.calculateTotalBenefit(benefitAmounts))
                .isEqualTo(29400);
    }

    @DisplayName("총주문 금액에서 증정 이벤트를 제외한 혜택들을 빼 할인 후 금액을 계산한다.")
    @Test
    void outputAfterDiscount() {
        Event event = new Event(25, new String[] {"타파스-1","티본스테이크-2","바비큐립-1"});
        List<Integer> benefitAmounts = event.calculateBenefitAmounts(169500);

        assertThat(calculator.calculateAfterDiscount(169500, benefitAmounts))
                .isEqualTo(165100);
    }
}
