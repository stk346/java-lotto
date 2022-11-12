package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    List<Integer> winningNumbers = new ArrayList<>();
    int winningBonusNumber;

    private static String SPLIT_DELIMITER = ",";

    public WinningNumbers(String numbers, String bonusNumber) {
        addWinningNumbers(numbers);
        addBonusNumber(bonusNumber);
    }

    private void addWinningNumbers(String numbers) {
        String[] winningNumbers = numbers.split(SPLIT_DELIMITER);
        for (String s : winningNumbers) {
            this.winningNumbers.add(Integer.parseInt(s));
        }
    }

    private void addBonusNumber(String bonusNumber) {
        this.winningBonusNumber = Integer.parseInt(bonusNumber);
    }
}
