package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

import static christmas.view.constant.Constant.*;
import static christmas.view.constant.InputMessage.INPUT_DATE_MESSAGE;
import static christmas.view.constant.InputMessage.INPUT_MENU_AND_COUNT_MESSAGE;

public class InputView {

    public int readDate() {
        System.out.println(INPUT_DATE_MESSAGE.getMessage());
        String input = Console.readLine();

        return converseToInt(input);
    }

    public Map<String, Integer> readOrderMenu() {
        System.out.println(INPUT_MENU_AND_COUNT_MESSAGE.getMessage());
        String input = Console.readLine();
        return converseToMap(input);
    }

    private static void checkDuplicate(Map<String, Integer> orderMenu, String[] splitOfDash, int i) {
        if(orderMenu.containsKey(splitOfDash[i])) {
            throw new IllegalArgumentException();
        }
    }

    private int converseToInt(String input) {
        return Integer.parseInt(input);
    }

    private Map<String, Integer> converseToMap(String input) {
        String[] splitOfComma = input.split(COMMA);
        Map<String, Integer> orderMenu = new HashMap<>();

        for(String s : splitOfComma) {
            String[] splitOfDash = s.split(DASH);
            for(int i = 0; i < splitOfDash.length; i+=2) {
                int value = converseToInt(splitOfDash[i + 1]);
                checkDuplicate(orderMenu, splitOfDash, i);
                orderMenu.put(splitOfDash[i], value);
            }
        }
        return orderMenu;
    }
}