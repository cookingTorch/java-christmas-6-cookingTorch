package christmas.model;

import christmas.constants.Constants;
import christmas.enums.Benefit;
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

    public String buildComplimentaryMenu(Integer totalAmount) {
        if (isOverMinAmount(totalAmount)) {
            return (Menus.CHAMPAGNE.getName()
                    + Messages.SPACE + Constants.GIFT_NUMBER + Messages.PIECE);
        }
        return Messages.NOTHING;
    }

    public List<Integer> calculateBenefitAmounts(Integer totalAmount) {
        List<Integer> benefitAmounts = new ArrayList<>();
        Benefit[] benefits = Benefit.values();

        benefitAmounts.add(dDayBenefit(benefits[0]));
        benefitAmounts.add(weekdayBenefit(benefits[1]));
        benefitAmounts.add(weekendBenefit(benefits[2]));
        benefitAmounts.add(specialBenefit(benefits[3]));
        benefitAmounts.add(giftBenefit(benefits[4], totalAmount));
        return benefitAmounts;
    }

    private List<Orders> generateOrders(String[] inputs) {
        List<Orders> orders = new ArrayList<>();

        for (String input : inputs) {
            orders.add(new Orders(input));
        }
        return orders;
    }

    private Integer dDayBenefit(Benefit benefit) {
        int amount = 0;

        if (date > Constants.CHRISTMAS_DAY) {
            return amount;
        }
        amount += Constants.START_AMOUNT;
        amount += (date - 1) * benefit.getAmount();
        return amount;
    }

    private Integer weekdayBenefit(Benefit benefit) {
        Integer dessertCount;

        if (isWeekend()) {
            return 0;
        }
        dessertCount = countDessert();
        return (dessertCount * benefit.getAmount());
    }

    private Integer weekendBenefit(Benefit benefit) {
        Integer mainCount;

        if (isWeekend()) {
            mainCount = countMain();
            return (mainCount * benefit.getAmount());
        }
        return 0;
    }

    private Integer specialBenefit(Benefit benefit) {
        if (isStar()) {
            return benefit.getAmount();
        }
        return 0;
    }

    private Integer giftBenefit(Benefit benefit, Integer totalAmount) {
        if (isOverMinAmount(totalAmount)) {
            return benefit.getAmount();
        }
        return 0;
    }

    private boolean isOverMinAmount(Integer totalAmount) {
        return (totalAmount > Constants.MIN_AMOUNT);
    }

    private boolean isWeekend() {
        return (date % Constants.WEEK == Constants.FIRST_WEEKEND
                || date % Constants.WEEK == Constants.SECOND_WEEKEND);
    }

    private boolean isStar() {
        return (date % Constants.WEEK == Constants.FIRST_WEEKDAY
                || date.equals(Constants.CHRISTMAS_DAY));
    }

    private Integer countDessert() {
        Integer dessertCount = 0;

        for (Orders order : orders) {
            dessertCount += order.isDessert();
        }
        return dessertCount;
    }

    private Integer countMain() {
        Integer mainCount = 0;

        for (Orders order : orders) {
            mainCount += order.isMain();
        }
        return mainCount;
    }
}
