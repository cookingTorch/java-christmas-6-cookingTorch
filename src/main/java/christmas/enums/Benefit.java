package christmas.enums;

public enum Benefit {
    D_DAY("크리스마스 디데이 할인", 100),
    WEEKDAY("평일 할인", 2023),
    WEEKEND("주말 할인", 2023),
    SPECIAL("특별 할인", 1000),
    GIFT("증정 이벤트", Menus.CHAMPAGNE.getCost());

    private final String name;
    private final Integer amount;

    Benefit(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAmount() {
        return this.amount;
    }
}
