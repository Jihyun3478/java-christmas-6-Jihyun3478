package christmas.view.constant;

public enum OutputMessage {
    INTRODUCE_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),

    MENU_CHECK_MESSAGE("\n<주문 메뉴>"),

    TOTAL_PRICE_MESSAGE("\n<할인 전 총주문 금액>"),
    FREE_GIFT_MESSAGE("\n<증정 메뉴>"),
    CHAMPAGNE_MESSAGE("샴페인 1개"),
    EVENT_DETAIL_MESSAGE("\n<혜택 내역>"),
    CHRISTMAS_DISCOUNT_MESSAGE("크리스마스 디데이 할인: -"),
    WEEK_DISCOUNT_MESSAGE("평일 할인: -"),
    WEEKEND_DISCOUNT_MESSAGE("주말 할인: -"),
    NONE("없음");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
