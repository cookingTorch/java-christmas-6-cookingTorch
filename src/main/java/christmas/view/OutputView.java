package christmas.view;

import christmas.constants.Messages;

public class OutputView {
    public void printGreetingEvent() {
        System.out.println(Messages.GREETING_EVENT);
    }

    public void printEventPreview(String date) {
        System.out.print(date);
        System.out.println(Messages.EVENT_PREVIEW);
        System.out.println();
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
