package christmas.domain;

import christmas.view.InputView;
import christmas.view.OutputView;

public class Planner {
    private InputView inputView;
    private OutputView outputView;

    public Planner() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void showChristmasPromotion() {
        Integer date = tryReadDate();
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
}
