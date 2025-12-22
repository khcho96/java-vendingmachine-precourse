package vendingmachine.domain;

import java.util.EnumMap;
import org.junit.jupiter.api.Test;
import vendingmachine.constant.Coin;

class VendingMachineTest {

    @Test
    void 동전_생성_테스트() {
        VendingMachine vendingMachine = VendingMachine.fromMoney(450);
        EnumMap<Coin, Integer> coinCount = vendingMachine.getCoinCount();

        System.out.println(coinCount);
    }
}