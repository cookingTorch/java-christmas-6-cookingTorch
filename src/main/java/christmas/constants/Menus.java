package christmas.constants;

public enum Menus {
    MUSHROOM_SOUP("양송이수프", 6000, MenuTypes.APPETIZER),
    TAPAS("타파스", 5500, MenuTypes.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, MenuTypes.APPETIZER),
    T_BONE_STEAK("티본스테이크", 55000, MenuTypes.MAIN),
    BARBECUE_RIBS("바비큐립", 54000, MenuTypes.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MenuTypes.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MenuTypes.MAIN),
    CHOCOLATE_CAKE("초코케이크", 15000, MenuTypes.DESSERT),
    ICE_CREAM("아이스크림", 5000, MenuTypes.DESSERT),
    ZERO_COKE("제로콜라", 3000, MenuTypes.BEVERAGE),
    RED_WINE("레드와인", 60000, MenuTypes.BEVERAGE),
    CHAMPAGNE("샴페인", 25000, MenuTypes.BEVERAGE);

    private final String name;
    private final Integer cost;
    private final MenuTypes menuType;

    Menus(String name, Integer cost, MenuTypes menuType) {
        this.name = name;
        this.cost = cost;
        this.menuType = menuType;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCost() {
        return this.cost;
    }

    public MenuTypes getMenuType() {
        return this.menuType;
    }
}
