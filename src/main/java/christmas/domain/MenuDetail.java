package christmas.domain;

import java.util.Arrays;
import java.util.Objects;

public enum MenuDetail {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),

    CAESAR_SALAD("시저샐러드", 8_000),
    T_BONE_STEAK("티본스테이크", 55_000),
    BARBECUE_RIBS("바비큐립", 54_000),

    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000),
    CHOCOLATE_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000),
    DIET_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000),
    EMPTY("", 0);

    private final String name;
    private final int price;

    MenuDetail(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public static boolean isContain(String input) {
        return Arrays.stream(values())
                .anyMatch(m -> Objects.equals(m.getName(), input));
    }

    private static MenuDetail totalPrice(String input) {
        return Arrays.stream(values())
                .filter(m -> Objects.equals(m.getName(), input)).findAny().orElse(EMPTY);

    }

    public static int getPrice(String input) {
        return totalPrice(input).price;
    }
}
