package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constants.Messages;
import christmas.validator.Validator;

public class InputView {
    private final Validator validator;

    public InputView() {
        this.validator = new Validator();
    }

    public Integer readDate() {
        System.out.println(Messages.RESTAURANT_VISIT_DATE);
        String input = Console.readLine();

        validator.validateDate(input);
        return Integer.parseInt(input);
    }

    public String[] readMenu() {
        System.out.println(Messages.ORDER_REQUEST);
        String input = Console.readLine();

        validator.validateMenu(input);
        return input.split(Messages.COMMA);
    }
}
