package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String MACHINE_MONEY_REQUEST = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    public static String readMachineMoney() {
        System.out.println(MACHINE_MONEY_REQUEST);
        return Console.readLine();
    }
}
