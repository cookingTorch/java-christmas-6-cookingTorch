package christmas.model;

import christmas.constants.Constants;
import christmas.enums.Menus;
import christmas.constants.Messages;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private final Integer date;
    private final List<Orders> orders;

    public Event(Integer date, String[] inputs) {
        this.date = date;
        this.orders = generateOrders(inputs);
    }

    public String buildDateMessage() {
        return (Messages.MONTH + date.toString() + Messages.DAY);
    }

    public List<String> buildOrderMenus() {
        List<String> orderMenus = new ArrayList<>();

        for (Orders order : orders) {
            orderMenus.add(order.buildOrderMenu());
        }
        return orderMenus;
    }

    public Integer calculateTotalAmount() {
        Integer totalAmount = 0;

        for (Orders order : orders) {
            totalAmount += order.calculateCost();
        }
        return totalAmount;
    }

    public String buildComplimentaryMenu() {
        if (isOverMinAmount()) {
            return (Menus.CHAMPAGNE.getName()
                    + Messages.SPACE + Constants.ONE + Messages.PIECE);
        }
        return Messages.NOTHING;
    }

    private List<Orders> generateOrders(String[] inputs) {
        List<Orders> orders = new ArrayList<>();

        for (String input : inputs) {
            orders.add(new Orders(input));
        }
        return orders;
    }

    private boolean isOverMinAmount() {
        Integer totalAmount = calculateTotalAmount();

        return (totalAmount > Constants.MIN_AMOUNT);
    }
}
