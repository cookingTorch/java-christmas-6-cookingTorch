package christmas.enums;

public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000);

    private final String name;
    private final Integer cost;

    Badge(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCost() {
        return this.cost;
    }
}
