package christmas.domain;

public class Badge {

    private final String badge;

    public Badge(int totalDiscount) {
        this.badge = giveBadge(totalDiscount);
    }

    public String giveBadge(int totalDiscount) {
        String badge = "없음";

        if(totalDiscount >= 5000) {
            badge = "별";
        }
        if(totalDiscount >= 10000) {
            badge = "트리";
        }
        if(totalDiscount >= 20000) {
            badge = "산타";
        }
        return badge;
    }
}
