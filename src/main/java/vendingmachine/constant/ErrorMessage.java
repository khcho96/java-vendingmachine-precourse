package vendingmachine.constant;

public enum ErrorMessage {

    AMOUNT_NUMBER_FORMAT_ERROR("금액은 숫자여야 합니다."),
    AMOUNT_UNIT_ERROR("금액은 10원 단위여야 합니다."),

    INPUT_FORMAT_ERROR("입력 형식이 올바르지 않습니다."),

    PRICE_NUMBER_FORMAT_ERROR("가격은 숫자여야 합니다."),

    INVALID_AMOUNT("유효하지 않은 금액입니다.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(Object... args) {
        return ERROR_MESSAGE_PREFIX + String.format(errorMessage, args);
    }
}
