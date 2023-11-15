package christmas.domain;

import static christmas.view.constant.NumberConstant.*;
import static christmas.view.constant.OutputConstant.*;

public class Badge {

    private final String badge;

    public Badge(int totalDiscount) {
        this.badge = giveBadge(totalDiscount);
    }

    public String giveBadge(int totalDiscount) {
        String badge = NONE;

        if(totalDiscount >= BADGE_STAR_CONDITION) {
            badge = BADGE_STAR;
        }
        if(totalDiscount >= BADGE_TREE_CONDITION) {
            badge = BADGE_TREE;
        }
        if(totalDiscount >= BADGE_SANTA_CONDITION) {
            badge = BADGE_SANTA;
        }
        return badge;
    }
}
