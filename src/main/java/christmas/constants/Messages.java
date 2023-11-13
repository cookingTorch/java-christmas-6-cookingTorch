package christmas.constants;

public class Messages {
    public static final String HYPHEN = "-";
    public static final String COMMA = ",";
    public static final String MONTH = Constants.DECEMBER + "월 ";
    public static final String DAY = "일";
    public static final String GREETING_EVENT = "안녕하세요! 우테코 식당 " + MONTH + "이벤트 플래너입니다.";
    public static final String RESTAURANT_VISIT_DATE = MONTH + "중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String ORDER_REQUEST
            = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. "
            + Menus.SEAFOOD_PASTA.getName() + HYPHEN + "2" + COMMA
            + Menus.RED_WINE.getName() + HYPHEN + "1" + COMMA
            + Menus.CHOCOLATE_CAKE.getName() + HYPHEN + "1)";
    public static final String EVENT_PREVIEW = "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    public static final String REGULAR_NUMBER = "\\d+";

    private Messages() {
    }
}
