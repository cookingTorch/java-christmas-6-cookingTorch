package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constants.Messages;
import christmas.validator.Validator;

public class InputView {
    private Validator validator;

    public InputView() {
        this.validator = new Validator();
    }

    public Integer readDate() {
        System.out.println(Messages.RESTAURANT_VISIT_DATE);
        String input = Console.readLine();

        validator.validateDate(input);
        return Integer.parseInt(input);
    }
}
