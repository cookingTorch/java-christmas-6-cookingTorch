package christmas.controller;

import christmas.model.Event;
import christmas.util.TextUtil;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class Planner {
    private final InputView inputView;
    private final OutputView outputView;
    private final TextUtil textUtil;

    public Planner() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.textUtil = new TextUtil();
    }

    public void christmasPromotion() {
        Event event;

        showGreetingEvent();
        event = plannerInput();
        showEventPreview(event);
        plannerOutput(event);
    }

    private Event plannerInput() {
        Integer date;

        date = tryReadDate();
        return tryGenerateEvent(date);
    }

    private void plannerOutput(Event event) {
        Integer totalAmount;
        List<Integer> benefitAmounts;

        showOrderMenus(event);
        totalAmount = findTotalAmount(event);
        showTotalAmount(totalAmount);
        showComplimentaryMenu(event, totalAmount);
        benefitAmounts = findBenefitAmounts(event, totalAmount);
        showBenefitDetails(benefitAmounts);
    };

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

    private Integer findTotalAmount(Event event) {
        return event.calculateTotalAmount();
    }

    private List<Integer> findBenefitAmounts(Event event, Integer totalAmount) {
        return event.calculateBenefitAmounts(totalAmount);
    }

    private void showGreetingEvent() {
        outputView.printGreetingEvent();
    }

    private void showEventPreview(Event event) {
        String dateMessage = event.buildDateMessage();

        outputView.printEventPreview(dateMessage);
    }

    private void showOrderMenus(Event event) {
        List<String> orderMenus = event.buildOrderMenus();

        outputView.printOrderMenus(orderMenus);
    }

    private void showTotalAmount(Integer totalAmount) {
        outputView.printTotalAmount(totalAmount);
    }

    private void showComplimentaryMenu(Event event, Integer totalAmount) {
        String complimentaryMenu = event.buildComplimentaryMenu(totalAmount);

        outputView.printComplimentaryMenu(complimentaryMenu);
    }

    private void showBenefitDetails(List<Integer> benefitAmounts) {
        List<String> benefitDetails = textUtil.buildBenefitDetails(benefitAmounts);

        outputView.printBenefitDetails(benefitDetails);
    }
}
