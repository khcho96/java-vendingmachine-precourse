package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import vendingmachine.constant.Coin;
import vendingmachine.constant.ErrorMessage;
import vendingmachine.generator.RandomCoinGenerator;

public class VendingMachine {

    private final EnumMap<Coin, Integer> coinCount;
    private final Map<Item, Integer> items;

    private VendingMachine(EnumMap<Coin, Integer> coinCount) {
        this.coinCount = coinCount;
        this.items = new HashMap<>();
    }

    public static VendingMachine fromMoney(int money) {
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

    public void addItems(String name, int price, int count) {
        Item item = new Item(name, price);
        items.put(item, count);
    }

    public boolean isPossiblePurchase(InsertedMoney insertedMoney) {
        int minPrice = getMinPriceOfItem();
        if (insertedMoney.getAmount() >= minPrice) {
            return true;
        }

        return allIsSoldOut();
    }

    private int getMinPriceOfItem() {
        List<Item> items = new ArrayList<>(this.items.keySet());

        return items.stream()
                .map(Item::getPrice)
                .min(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_MIN_PRICE_ERROR.getErrorMessage()));
    }

    private boolean allIsSoldOut() {
        return new ArrayList<>(items.values())
                .stream().noneMatch(count -> count > 0);
    }
}
