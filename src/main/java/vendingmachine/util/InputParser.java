package vendingmachine.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public final class InputParser {

    private static final String FIRST_DELIMITER = ";";
    private static final String SECOND_DELIMITER = ",";

    private InputParser() {
    }

    public static Integer parseMachineMoney(String rawMoney) {
        rawMoney = rawMoney.trim();

        Validator.validateAmountNumberFormat(rawMoney);

        return NumberConvertor.convertToNumber(rawMoney);
    }

    public static Map<String, List<Integer>> parseMachineItems(String readItems) {
        Validator.validateMachineItemsFormat(readItems);
        readItems = readItems.trim();

        Map<String, List<Integer>> machineItems = new HashMap<>();

        String[] split = readItems.split(FIRST_DELIMITER);
        for (String s : split) {
            String[] order = s.replace("[","").replace("]", "")
                    .trim().split(SECOND_DELIMITER);
            String name = order[0];
            int price = NumberConvertor.convertToNumber(order[1]);
            int count = NumberConvertor.convertToNumber(order[2]);

            machineItems.put(name, Arrays.asList(price, count));
        }

        return machineItems;
    }
}
