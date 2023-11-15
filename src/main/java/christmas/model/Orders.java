package christmas.model;

import christmas.constants.Errors;
import christmas.enums.MenuTypes;
import christmas.enums.Menus;
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

    public Integer calculateCost() {
        return (menu.getCost() * number);
    }

    public Integer isDessert() {
        if (menu.getMenuType() == MenuTypes.DESSERT) {
            return number;
        }
        return 0;
    }

    public Integer isMain() {
        if (menu.getMenuType() == MenuTypes.MAIN) {
            return number;
        }
        return 0;
    }

    private Menus findMenu(String inputName) {
        return Menus.findByName(inputName);
    }

    private Integer findNumber(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }
}
