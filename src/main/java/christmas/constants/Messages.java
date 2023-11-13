package christmas.constants;

import christmas.enums.Menus;

public class Messages {
    public static final String REGULAR_NUMBER = "\\d+";
    public static final String HYPHEN = "-";
    public static final String COMMA = ",";
    public static final String SPACE = " ";
    public static final String COLON = ":";
    public static final String LEFT_BRACKET = "<";
    public static final String RIGHT_BRACKET = ">";
    public static final String MONTH = Constants.DECEMBER + "월" + SPACE;
    public static final String DAY = "일";
    public static final String PIECE = "개";
    public static final String WON = "원";
    public static final String NOTHING = "없음";
    public static final String GREETING_EVENT = "안녕하세요! 우테코 식당 " + MONTH + "이벤트 플래너입니다.";
    public static final String RESTAURANT_VISIT_DATE = MONTH + "중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String ORDER_REQUEST
            = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. "
            + Menus.SEAFOOD_PASTA.getName() + HYPHEN + "2" + COMMA
            + Menus.RED_WINE.getName() + HYPHEN + "1" + COMMA
            + Menus.CHOCOLATE_CAKE.getName() + HYPHEN + "1)";
    public static final String EVENT_PREVIEW = "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    public static final String ORDER_MENU = LEFT_BRACKET + "주문 메뉴" + RIGHT_BRACKET;
    public static final String TOTAL_AMOUNT = LEFT_BRACKET + "할인 전 총주문 금액" + RIGHT_BRACKET;
    public static final String COMPLIMENTARY_MENU = LEFT_BRACKET + "증정 메뉴" + RIGHT_BRACKET;
    public static final String BENEFIT_DETAILS = LEFT_BRACKET + "혜택 내역" + RIGHT_BRACKET;
    public static final String TOTAL_BENEFIT = LEFT_BRACKET + "총혜택 금액" + RIGHT_BRACKET;

    private Messages() {
    }
}
