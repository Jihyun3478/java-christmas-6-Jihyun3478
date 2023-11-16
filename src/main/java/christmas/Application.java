package christmas;

import christmas.controller.EventManageController;

public class Application {
    public static void main(String[] args) {
        EventManageController eventManage = new EventManageController();
        eventManage.startEventPlanner();
    }
}
