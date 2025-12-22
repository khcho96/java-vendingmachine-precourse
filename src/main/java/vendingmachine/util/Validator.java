package vendingmachine.util;

import vendingmachine.constant.ErrorMessage;

public final class Validator {

    private static final String CSV_FORMAT = "^ *([가-힣a-zA-Z]+-\\d+)+ *(, *([가-힣]+-\\d+)+ *)*$";
    private static final String NUMBER_FORMAT = "\\d+";

    private Validator() {}

    public static void validateAmountNumberFormat(String input) {
        if (!input.matches(NUMBER_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }

    public static void validatePriceNumberFormat(String input) {
        if (!input.matches(NUMBER_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }

//    public static void validateCsvFormat(String input) {
//        if (!input.matches(CSV_FORMAT)) {
//            throw new IllegalArgumentException(CSV_FORMAT_ERROR.getErrorMessage());
//        }
//    }
}
