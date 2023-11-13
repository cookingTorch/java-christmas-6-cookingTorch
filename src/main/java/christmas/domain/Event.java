package christmas.domain;

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

    public String dateMessage() {
        return (Messages.MONTH + date.toString() + Messages.DAY);
    }

    private List<Orders> generateOrders(String[] inputs) {
        List<Orders> orders = new ArrayList<>();

        for (String input : inputs) {
            orders.add(new Orders(input));
        }
        return orders;
    }
}
