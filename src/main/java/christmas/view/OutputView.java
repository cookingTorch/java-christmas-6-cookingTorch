package christmas.view;

import christmas.constants.Menus;
import christmas.constants.Messages;

import java.util.List;

public class OutputView {
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

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
