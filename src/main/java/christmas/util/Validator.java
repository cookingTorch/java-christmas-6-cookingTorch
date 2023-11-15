package christmas.util;

import christmas.constants.Constants;
import christmas.constants.Errors;
import christmas.enums.MenuTypes;
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

        if (invalidOrders(inputs) || duplicateMenu(inputs)
                || onlyBeverages(inputs) || overMaxOrders(inputs)) {
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

    private boolean onlyBeverages(String[] inputs) {
        String name;

        for (String order : inputs) {
            name = order.split(Messages.HYPHEN)[0];
            if (notBeverage(name)) {
                return false;
            }
        }
        return true;
    }

    private boolean notBeverage(String name) {
        Menus[] menus = Menus.values();

        for (Menus menu : menus) {
            if (name.equals(menu.getName())) {
                return (menu.getMenuType() != MenuTypes.BEVERAGE);
            }
        }
        return false;
    }

    private boolean overMaxOrders(String[] inputs) {
        Integer orderCount = countOrders(inputs);

        return (orderCount > Constants.MAX_ORDER);
    }

    private Integer countOrders(String[] inputs) {
        int orderCount = 0;
        String number;

        for (String input : inputs) {
            number = input.split(Messages.HYPHEN)[1];
            orderCount += Integer.parseInt(number);
        }
        return orderCount;
    }
}
