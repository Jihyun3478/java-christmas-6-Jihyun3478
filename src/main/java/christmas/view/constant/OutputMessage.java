package christmas.view.constant;

public enum OutputMessage {
    INTRODUCE_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),

    MENU_CHECK_MESSAGE("\n<주문 메뉴>"),

    TOTAL_PRICE_MESSAGE("\n<할인 전 총주문 금액>"),
    FREE_GIFT_MESSAGE("\n<증정 메뉴>"),
    CHAMPAGNE_MESSAGE("샴페인 1개"),
    NONE("없음");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
