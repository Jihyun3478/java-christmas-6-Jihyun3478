package christmas.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public String getType() {
        return type;
    }
}