package christmas.view;

import christmas.constants.Messages;

import java.text.NumberFormat;
import java.util.List;

public class OutputView {
    private final NumberFormat formatter;

    public OutputView() {
        this.formatter = NumberFormat.getNumberInstance();
    }

    public void printGreetingEvent() {
        System.out.println(Messages.GREETING_EVENT);
    }

    public void printEventPreview(String date) {
        System.out.print(date);
        System.out.println(Messages.EVENT_PREVIEW);
    }

    public void printOrderMenus(List<String> orderMenus) {
        System.out.println();
        System.out.println(Messages.ORDER_MENU);
        for (String orderMenu : orderMenus) {
            System.out.println(orderMenu);
        }
    }

    public void printTotalAmount(Integer totalAmount) {
        System.out.println();
        System.out.println(Messages.TOTAL_AMOUNT);
        System.out.print(formatter.format(totalAmount));
        System.out.println(Messages.WON);
    }

    public void printComplimentaryMenu(String complimentaryMenu) {
        System.out.println();
        System.out.println(Messages.COMPLIMENTARY_MENU);
        System.out.println(complimentaryMenu);
    }

    public void printBenefitDetails(List<String> benefitDetails) {
        System.out.println();
        System.out.println(Messages.BENEFIT_DETAILS);
        for (String line : benefitDetails) {
            System.out.println(line);
        }
    }

    public void printTotalBenefit(Integer totalBenefit) {
        System.out.println();
        System.out.println(Messages.TOTAL_BENEFIT);
        System.out.print(formatter.format(-totalBenefit));
        System.out.println(Messages.WON);
    }

    public void printAfterDiscount(Integer afterDiscount) {
        System.out.println();
        System.out.println(Messages.AFTER_DISCOUNT);
        System.out.print(formatter.format(afterDiscount));
        System.out.println(Messages.WON);
    }

    public void printEventBadge(String eventBadge) {
        System.out.println();
        System.out.println(Messages.EVENT_BADGE);
        System.out.println(eventBadge);
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
