package christmas.domain;

import java.util.*;

public enum Menu {
    APPETIZER("에피타이저", Arrays.asList(MenuDetail.MUSHROOM_SOUP, MenuDetail.TAPAS, MenuDetail.CAESAR_SALAD)),
    MAIN_MENU("메인", Arrays.asList(MenuDetail.T_BONE_STEAK, MenuDetail.BARBECUE_RIBS, MenuDetail.SEAFOOD_PASTA, MenuDetail.CHRISTMAS_PASTA)),
    DESSERT("디저트", Arrays.asList(MenuDetail.CHOCOLATE_CAKE, MenuDetail.ICE_CREAM)),
    BEVERAGE("음료", Arrays.asList(MenuDetail.DIET_COKE, MenuDetail.RED_WINE, MenuDetail.CHAMPAGNE)),
    EMPTY("없음", Collections.EMPTY_LIST);

    private String type;
    private List<MenuDetail> menu;

    Menu(String type, List<MenuDetail> menu) {
        this.type = type;
        this.menu = menu;
    }

//    private String getName() {
//        return BEVERAGE.menu.stream().filter(m -> m.getName()).;
//    }

    private static boolean isAppetizer(String menu) {
        return APPETIZER.menu.stream()
                .anyMatch(m -> Objects.equals(m.getName(), menu));
    }

    private static boolean isMainMenu(String menu) {
        return MAIN_MENU.menu.stream()
                .anyMatch(m -> Objects.equals(m.getName(), menu));
    }

    private static boolean isDessert(String menu) {
        return DESSERT.menu.stream()
                .anyMatch(m -> Objects.equals(m.getName(), menu));
    }

    public static boolean isFood(String menu) {
        return isAppetizer(menu) || isMainMenu(menu) || isDessert(menu);
    }

    public static boolean isContainFood(Map<String, Integer> input) {
        boolean isContain = false;
        for(String menu : input.keySet()) {
            if (isFood(menu)) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    public static boolean isOnlyBeverage(Map<String, Integer> input) {
        return !isContainFood(input);
    }
}