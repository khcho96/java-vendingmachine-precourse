package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;

public class InsertedMoney {

    private int amount;

    private InsertedMoney(int amount) {
        this.amount = amount;
    }

    public static InsertedMoney fromAmount(int money) {
        validate(money);

        return new InsertedMoney(money);
    }

    private static void validate(int amount) {
        if (amount % 10 != 0 ) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_UNIT_ERROR.getErrorMessage());
        }
    }

    public int updateAmount(int consumedAmount) {
        amount -= consumedAmount;
        return amount;
    }
}
