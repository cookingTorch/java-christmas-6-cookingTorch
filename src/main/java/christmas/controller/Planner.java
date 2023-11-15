package christmas.controller;

import christmas.model.Event;
import christmas.util.Calculator;
import christmas.util.TextUtil;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class Planner {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private final TextUtil textUtil;

    private Event event;

    public Planner() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculator = new Calculator();
        this.textUtil = new TextUtil();
    }

    public void christmasPromotion() {
        showGreetingEvent();
        plannerInput();
        showEventPreview();
        plannerOutput();
    }

    private void plannerInput() {
        Integer date;

        date = tryGenerateDate();
        event = tryGenerateEvent(date);
    }

    private void plannerOutput() {
        Integer totalAmount;
        Integer totalBenefit;
        List<Integer> benefitAmounts;

        totalAmount = findTotalAmount();
        showOrderResult(totalAmount);
        benefitAmounts = findBenefitAmounts(totalAmount);
        totalBenefit = findTotalBenefit(benefitAmounts);
        showEventResult(totalAmount, benefitAmounts, totalBenefit);
    }

    private void showOrderResult(Integer totalAmount) {
        showOrderMenus();
        showTotalAmount(totalAmount);
    }

    private void showEventResult(Integer totalAmount, List<Integer> benefitAmounts, Integer totalBenefit) {
        showComplimentaryMenu(totalAmount);
        showBenefitDetails(benefitAmounts);
        showTotalBenefit(totalBenefit);
        showAfterDiscount(totalAmount, benefitAmounts);
        showEventBadge(totalBenefit);
    }

    private Integer tryGenerateDate() {
        while (true) {
            try {
                return generateDate();
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

    private Integer generateDate() {
        return inputView.readDate();
    }

    private Event generateEvent(Integer date) {
        String[] inputs = inputView.readMenu();

        return new Event(date, inputs);
    }

    private Integer findTotalAmount() {
        return event.calculateTotalAmount();
    }

    private List<Integer> findBenefitAmounts(Integer totalAmount) {
        return event.calculateBenefitAmounts(totalAmount);
    }

    private Integer findTotalBenefit(List<Integer> benefitAmounts) {
        return calculator.calculateTotalBenefit(benefitAmounts);
    }

    private void showGreetingEvent() {
        outputView.printGreetingEvent();
    }

    private void showEventPreview() {
        String dateMessage = event.buildDateMessage();

        outputView.printEventPreview(dateMessage);
    }

    private void showOrderMenus() {
        List<String> orderMenus = event.buildOrderMenus();

        outputView.printOrderMenus(orderMenus);
    }

    private void showTotalAmount(Integer totalAmount) {
        outputView.printTotalAmount(totalAmount);
    }

    private void showComplimentaryMenu(Integer totalAmount) {
        String complimentaryMenu = event.buildComplimentaryMenu(totalAmount);

        outputView.printComplimentaryMenu(complimentaryMenu);
    }

    private void showBenefitDetails(List<Integer> benefitAmounts) {
        List<String> benefitDetails = textUtil.buildBenefitDetails(benefitAmounts);

        outputView.printBenefitDetails(benefitDetails);
    }

    private void showTotalBenefit(Integer totalBenefit) {
        outputView.printTotalBenefit(totalBenefit);
    }

    private void showAfterDiscount(Integer totalAmount, List<Integer> benefitAmounts) {
        Integer afterDiscount = calculator.calculateAfterDiscount(totalAmount, benefitAmounts);

        outputView.printAfterDiscount(afterDiscount);
    }

    private void showEventBadge(Integer totalBenefit) {
        String eventBadge = textUtil.buildEventBadge(totalBenefit);

        outputView.printEventBadge(eventBadge);
    }
}
