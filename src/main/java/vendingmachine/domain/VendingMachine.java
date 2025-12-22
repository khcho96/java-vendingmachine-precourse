package vendingmachine.domain;

import java.util.Arrays;
import java.util.EnumMap;
import vendingmachine.constant.Coin;
import vendingmachine.constant.ErrorMessage;
import vendingmachine.generator.RandomCoinGenerator;

public class VendingMachine {

    private final EnumMap<Coin, Integer> coinCount;

    private VendingMachine(EnumMap<Coin, Integer> coinCount) {
        this.coinCount = coinCount;
    }

    public static VendingMachine from(int money) {
        validate(money);

        EnumMap<Coin, Integer> count = new EnumMap<>(Coin.class);

        Arrays.stream(Coin.values())
                .forEach(coin -> count.put(coin, 0));

        while (money > 0) {
            int generatedAmount = RandomCoinGenerator.generateCoin();
            if (generatedAmount <= money) {
                count.put(Coin.fromAmount(generatedAmount), count.get(Coin.fromAmount(generatedAmount)) + 1);
                money -= generatedAmount;
            }
        }

        return new VendingMachine(count);
    }

    private static void validate(int money) {
        if (money % 10 != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_UNIT_ERROR.getErrorMessage());
        }
    }

    public boolean isPossibleChange(int amount) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.getAmount() <= amount)
                .map(coin -> coin.getAmount() * coinCount.get(coin))
                .reduce(0, Integer::sum) >= amount;
    }

    public EnumMap<Coin, Integer> getCoinCount() {
        return coinCount;
    }
}
