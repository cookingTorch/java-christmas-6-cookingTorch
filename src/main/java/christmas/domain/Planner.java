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
        Event event = tryGenerateEvent(date);
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
}
