package vendingmachine.view;

import java.util.Arrays;
import java.util.EnumMap;
import vendingmachine.constant.Coin;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String _MESSAGE = "";

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printMachineCoins(EnumMap<Coin, Integer> coinCount) {
        System.out.println("\n자판기가 보유한 동전");
        for (Coin coin : coinCount.keySet()) {
            System.out.printf("%d원 - %d개\n", coin.getAmount(), coinCount.get(coin));
        }
    }

    public static void printCurrentAmount(int amount) {
        System.out.printf("\n투입 금액: %d원\n", amount);
    }

    public static void printChangeCoins(EnumMap<Coin, Integer> optimalCoinCount) {
        System.out.println("잔돈");
        for (Coin coin : optimalCoinCount.keySet()) {
            System.out.printf("%d원 - %d개\n", coin.getAmount(), optimalCoinCount.get(coin));
        }
    }
}
