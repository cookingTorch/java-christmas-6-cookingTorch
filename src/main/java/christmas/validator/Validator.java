package christmas.validator;

import christmas.constants.Errors;
import christmas.constants.Messages;

public class Validator {
    public void validateDate(String input) {
        if (notNumeric(input) || lowerRange(input) || upperRange(input)) {
            throw new IllegalArgumentException(Errors.INVALID_DATE);
        }
    }

    private boolean notNumeric(String input) {
        return !input.matches(Messages.REGULAR_NUMBER);
    }

    private boolean lowerRange(String input) {
        return (Integer.parseInt(input) < 1);
    }

    private boolean upperRange(String input) {
        return (Integer.parseInt(input) > 31);
    }
}
