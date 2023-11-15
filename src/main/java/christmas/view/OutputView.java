package christmas.view;

import christmas.constants.Messages;

import java.text.NumberFormat;
import java.util.List;

public class OutputView {
    private final NumberFormat formatter;

    public OutputView() {
        this.formatter = NumberFormat.getNumberInstance();
    }

    public void printGreetingMessage() {
        System.out.println(Messages.GREETING_EVENT);
    }

    public void printPreviewMessage(String date) {
        System.out.println(date + Messages.EVENT_PREVIEW);
    }

    public void printOrderMenus(List<String> orderMenus) {
        printTitle(Messages.ORDER_MENU);
        for (String orderMenu : orderMenus) {
            System.out.println(orderMenu);
        }
    }

    public void printTotalAmount(Integer totalAmount) {
        printTitle(Messages.TOTAL_AMOUNT);
        System.out.println(formatter.format(totalAmount) + Messages.WON);
    }

    public void printComplimentaryMenu(String complimentaryMenu) {
        printTitle(Messages.COMPLIMENTARY_MENU);
        System.out.println(complimentaryMenu);
    }

    public void printBenefitDetails(List<String> benefitDetails) {
        printTitle(Messages.BENEFIT_DETAILS);
        for (String line : benefitDetails) {
            System.out.println(line);
        }
    }

    public void printTotalBenefit(Integer totalBenefit) {
        printTitle(Messages.TOTAL_BENEFIT);
        System.out.println(formatter.format(-totalBenefit) + Messages.WON);
    }

    public void printAfterDiscount(Integer afterDiscount) {
        printTitle(Messages.AFTER_DISCOUNT);
        System.out.println(formatter.format(afterDiscount) + Messages.WON);
    }

    public void printEventBadge(String eventBadge) {
        printTitle(Messages.EVENT_BADGE);
        System.out.println(eventBadge);
    }

    private void printTitle(String title) {
        System.out.println();
        System.out.println(Messages.LEFT_BRACKET + title + Messages.RIGHT_BRACKET);
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
