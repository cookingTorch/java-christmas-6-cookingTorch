package christmas.domain;

import christmas.constants.Errors;
import christmas.constants.Menus;
import christmas.constants.Messages;

public class Orders {
    private final Menus menu;
    private final Integer number;

    public Orders(String input) {
        String[] inputs = input.split(Messages.HYPHEN);

        this.menu = findMenu(inputs[0]);
        this.number = findNumber(inputs[1]);
    }

    public String buildOrderMenu() {
        return (menu.getName() + Messages.SPACE + number + Messages.PIECE);
    }

    private Menus findMenu(String inputName) {
        Menus[] menus = Menus.values();

        for (Menus menu : menus) {
            if (inputName.equals(menu.getName())) {
                return menu;
            }
        }
        throw new IllegalArgumentException(Errors.INVALID_ORDER);
    }

    private Integer findNumber(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }
}
