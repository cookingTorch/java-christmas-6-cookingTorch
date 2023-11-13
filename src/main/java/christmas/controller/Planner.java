package christmas.controller;

import christmas.model.Event;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class Planner {
    private final InputView inputView;
    private final OutputView outputView;

    private Event event;

    public Planner() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void showChristmasPromotion() {
        outputView.printGreetingEvent();
        Integer date = tryReadDate();
        event = tryGenerateEvent(date);
        outputView.printEventPreview(event.buildDateMessage());
        showOrderMenus();
        Integer totalAmount = showTotalAmount();
        showComplimentaryMenu(totalAmount);
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

    private void showOrderMenus() {
        List<String> orderMenus = event.buildOrderMenus();

        outputView.printOrderMenus(orderMenus);
    }

    private Integer showTotalAmount() {
        Integer totalAmount = event.calculateTotalAmount();

        outputView.printTotalAmount(totalAmount);
        return totalAmount;
    }

    private void showComplimentaryMenu(Integer totalAmount) {
        String complimentaryMenu = event.buildComplimentaryMenu(totalAmount);

        outputView.printComplimentaryMenu(complimentaryMenu);
    }
}
