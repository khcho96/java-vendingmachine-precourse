package vendingmachine;

import java.util.EnumMap;
import java.util.function.Supplier;
import vendingmachine.constant.Coin;
import vendingmachine.domain.VendingMachine;
import vendingmachine.util.InputParser;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {

    private static VendingMachine vendingMachine;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        EnumMap<Coin, Integer> coinCount = retryOnError(() -> {
            String readMachineMoney = InputView.readMachineMoney();
            int money = InputParser.parseMachineMoney(readMachineMoney);
            vendingMachine = VendingMachine.from(money);
            return vendingMachine.getCoinCount();
        });

        OutputView.printMachineCoins(coinCount);
    }

    private static  <T> T retryOnError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private static void retryOnError(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
