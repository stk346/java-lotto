package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumbersAreUnique(numbers);
        validateNumbersAreSortedInAscendingOrder(numbers);
        this.numbers = numbers;
        getBonusNumber();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 들어올 수 있습니다.");
        }
    }
    // TODO: 추가 기능 구현

    private void getBonusNumber() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 45);
        for (Integer n : randomNumbers) {
            if (!this.numbers.contains(n)) {
                this.bonusNumber =  n;
                break;
            }
        }
    }

    public boolean isOverlappedNumbersAndBonusNumber() {
        return numbers.contains(bonusNumber);
    }

    private void validateNumbersAreUnique(List<Integer> numbers) {
        int originalNumberLength = numbers.size();
        HashSet<Integer> uniqueNumberLength = new HashSet<>(numbers);
        if (originalNumberLength != uniqueNumberLength.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 들어올 수 없습니다.");
        }
    }

    private void validateNumbersAreSortedInAscendingOrder(List<Integer> numbers) {
        for (int idx=0; idx<numbers.size()-1; idx++) {
            if (numbers.get(idx) > numbers.get(idx+1)) {
                throw new IllegalArgumentException("[ERROR] 숫자는 오름차순으로 정렬돼야 합니다.");
            }
        }
    }
}