package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> pickedNumber = randomNumber.subList(0, 6);
        Collections.sort(pickedNumber);
        System.out.print(randomNumber);
        return randomNumber;
    }
}
