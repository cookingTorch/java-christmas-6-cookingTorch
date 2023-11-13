package christmas.util;

import christmas.constants.Constants;
import christmas.constants.Errors;
import christmas.enums.Menus;
import christmas.constants.Messages;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public void validateDate(String input) {
        if (notNumeric(input) || lowerRange(input) || upperRange(input)) {
            throw new IllegalArgumentException(Errors.INVALID_DATE);
        }
    }

    public void validateMenu(String input) {
        String[] inputs = input.split(Messages.COMMA);

        if (invalidOrders(inputs) || duplicateMenu(inputs)) {
            throw new IllegalArgumentException(Errors.INVALID_ORDER);
        }
    }

    private boolean notNumeric(String input) {
        return !input.matches(Messages.REGULAR_NUMBER);
    }

    private boolean lowerRange(String input) {
        return (Integer.parseInt(input) < Constants.FIRST_DATE);
    }

    private boolean upperRange(String input) {
        return (Integer.parseInt(input) > Constants.LAST_DATE);
    }

    private boolean invalidOrders(String[] inputs) {
        for (String order : inputs) {
            if (invalidOrder(order)) {
                return true;
            }
        }
        return false;
    }

    private boolean invalidOrder(String order) {
        String[] orders = order.split(Messages.HYPHEN);

        return (invalidForm(orders) || notMenuName(orders[0])
                || notNumeric(orders[1]) || lowerRange(orders[1]));
    }

    private boolean invalidForm(String[] orders) {
        return (orders.length != 2);
    }

    private boolean notMenuName(String name) {
        Menus[] menus = Menus.values();

        for (Menus menu : menus) {
            if (name.equals(menu.getName())) {
                return false;
            }
        }
        return true;
    }

    private boolean duplicateMenu(String[] inputs) {
        List<String> names = new ArrayList<>();
        String name;

        for (String order : inputs) {
            name = order.split(Messages.HYPHEN)[0];
            if (names.contains(name)) {
                return true;
            }
            names.add(name);
        }
        return false;
    }
}
