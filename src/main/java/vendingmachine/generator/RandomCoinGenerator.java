package vendingmachine.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.constant.Coin;

public final class RandomCoinGenerator {

    public static int generateCoin() {
        // TODO: 외부 메서드 호출
        List<Integer> coins = Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());

        return Randoms.pickNumberInList(coins);
    }
}
