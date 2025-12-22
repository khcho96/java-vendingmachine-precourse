package vendingmachine.view;

import java.util.Arrays;
import java.util.EnumMap;
import vendingmachine.constant.Coin;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String _MESSAGE = "";

    public static void printResult() {

    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printMachineCoins(EnumMap<Coin, Integer> coinCount) {
        System.out.println("\n자판기가 보유한 동전");
        for (Coin coin : coinCount.keySet()) {
            System.out.printf("%d원 - %d개\n", coin.getAmount(), coinCount.get(coin));
        }
    }
}
