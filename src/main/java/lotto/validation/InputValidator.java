package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

public class InputValidator {

    private final String MESSAGE_WHEN_INPUT_IS_OVERLAPPED = "[ERROR] 중복된 숫자는 들어올 수 없습니다.";

    private final String MESSAGE_WHEN_MONEY_IS_NOT_THOUSAND_WON = "[ERROR] 투입 금액은 1000원으로 나누어 떨어져야 합니다.";

    private final String MESSAGE_WHEN_MONEY_IS_NOT_DIGIT = "[ERROR] 올바른 숫자 형식을 입력해주세요.";

    private final String MESSAGE_WHEN_BONUS_NUMBER_IS_NOT_DIGIT = "[ERROR] 보너스 넘버는 숮자만 가능합니다.";

    private final String MESSAGE_WHEN_INPUT_IS_NOT_CONTAINS_COMMA = "[ERROR] 로또 넘버는 콤마(,)로 구분돼야 합니다.";

    private final String MESSAGE_WHEN_LOTTO_NUMBERS_ARE_NOT_DIGIT = "[ERROR] 로또 넘버는 숫자만 들어올 수 있습니다.";


    private final String SPLIT_DELIMITER = ",";

    public void validateNumbersAreUnique(List<Integer> numbers) {
        int originalNumberLength = numbers.size();
        HashSet<Integer> uniqueNumberLength = new HashSet<>(numbers);
        if (originalNumberLength != uniqueNumberLength.size()) {
            throw new IllegalArgumentException(MESSAGE_WHEN_INPUT_IS_OVERLAPPED);
        }
    }

    public void validateMoney(int money) {
        if (money%1000 != 0) throw new IllegalArgumentException(MESSAGE_WHEN_MONEY_IS_NOT_THOUSAND_WON);
    }

    public void validateInputMoney(String money) {
        for (int i=0; i<money.length(); i++) {
            if (!Character.isDigit(money.charAt(i))) {
//                System.out.println(MESSAGE_WHEN_MONEY_IS_NOT_DIGIT);
                throw new NoSuchElementException(MESSAGE_WHEN_MONEY_IS_NOT_DIGIT);
            }
        }
    }

    public void validateBonusNumber(String bonusNumber) {
        if (!Character.isDigit(bonusNumber.charAt(0))) {
            throw new IllegalArgumentException(MESSAGE_WHEN_BONUS_NUMBER_IS_NOT_DIGIT);
        }
    }

    public void validateInputWinningNumbers(String winningNumbers) {
        if (!winningNumbers.contains(SPLIT_DELIMITER)) {
            throw new IllegalArgumentException(MESSAGE_WHEN_INPUT_IS_NOT_CONTAINS_COMMA);
        }
        String[] InputOfSeparatedInComma = winningNumbers.split(SPLIT_DELIMITER);
        for (String s : InputOfSeparatedInComma) {
            if (!Character.isDigit(s.charAt(0))) {
                throw new IllegalArgumentException(MESSAGE_WHEN_LOTTO_NUMBERS_ARE_NOT_DIGIT);
            }
        }
    }
}
