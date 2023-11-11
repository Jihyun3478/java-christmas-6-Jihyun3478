package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.view.constant.InputMessage.INPUT_DATE_MESSAGE;

public class InputView {

    public int readDate() {
        System.out.println(INPUT_DATE_MESSAGE.getMessage());
        String input = Console.readLine();

        return converseToInt(input);
    }

    private static int converseToInt(String input) {
        return Integer.parseInt(input);
    }
}