package christmas.domain;

import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class Planner {
    private final InputView inputView;
    private final OutputView outputView;

    public Planner() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void showChristmasPromotion() {
        outputView.printGreetingEvent();
        Integer date = tryReadDate();
        Event event = tryGenerateEvent(date);
        outputView.printEventPreview(event.buildDateMessage());
        showOrderMenus(event);
        showTotalAmount(event);
    }

    private Integer tryReadDate() {
        while (true) {
            try {
                return inputView.readDate();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private Event tryGenerateEvent(Integer date) {
        while (true) {
            try {
                return generateEvent(date);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private Event generateEvent(Integer date) {
        String[] inputs = inputView.readMenu();

        return new Event(date, inputs);
    }

    private void showOrderMenus(Event event) {
        List<String> orderMenus = event.buildOrderMenus();

        outputView.printOrderMenus(orderMenus);
    }

    private void showTotalAmount(Event event) {
        Integer totalAmount = event.calculateTotalAmount();

        outputView.printTotalAmount(totalAmount);
    }
}
