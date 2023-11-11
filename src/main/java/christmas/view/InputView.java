package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static christmas.view.constant.Constant.*;
import static christmas.view.constant.InputMessage.INPUT_DATE_MESSAGE;
import static christmas.view.constant.InputMessage.INPUT_MENU_AND_COUNT_MESSAGE;

public class InputView {
    Pattern pattern = Pattern.compile(ORDER_MENU_REGEX);

    public int readDate() {
        System.out.println(INPUT_DATE_MESSAGE.getMessage());
        String input = Console.readLine();

        return converseToInt(input);
    }

    public Map<String, Integer> readOrderMenu() {
        System.out.println(INPUT_MENU_AND_COUNT_MESSAGE.getMessage());
        String input = Console.readLine();
        checkFormat(input);
        return converseToMap(input);
    }

    private int converseToInt(String input) {
        return Integer.parseInt(input);
    }

    private void checkFormat(String input) {
        if (!pattern.matcher(input).find()) {
            throw new IllegalArgumentException();
        }
    }

    private Map<String, Integer> converseToMap(String input) {
        String[] splitOfComma = input.split(COMMA);
        Map<String, Integer> orderMenu = new HashMap<>();

        for(String s : splitOfComma) {
            String[] splitOfDash = s.split(DASH);
            for(int i = 0; i < splitOfDash.length; i+=2) {
                int value = Integer.parseInt(splitOfDash[i+1]);
                orderMenu.put(splitOfDash[i], value);
            }
        }
        return orderMenu;
    }
}