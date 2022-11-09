package lotto.model;

import java.util.List;

public class WinningNumbers {
    List<Integer> winningNumbers;
    int winningBonusNumber;

    WinningNumbers(String numbers, String bonusNumber) {
        addWinningNumbers(numbers);
        addBonusNumber(bonusNumber);
    }

    private void addWinningNumbers(String numbers) {
        String[] winningNumbers = numbers.split(",");
        for (String s : winningNumbers) {
            this.winningNumbers.add(Integer.valueOf(s));
        }
    }

    private void addBonusNumber(String bonusNumber) {
        this.winningBonusNumber = Integer.parseInt(bonusNumber);
    }
}
