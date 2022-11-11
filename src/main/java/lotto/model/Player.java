package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Lotto> playerLotto = new ArrayList<>();

    public Player(int money) {
        getLotto(money);
    }

    /*
    테스트용 생성자
     */
    public Player(Lotto lotto) {
        this.playerLotto.add(lotto);
        lotto.generateBonusNumber("7");
    }

    private void getLotto(int money) {
        int count = 0;
        while (count < money/1000) {
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            List<Integer> randomNumber = lottoNumberGenerator.generateLottoNumbers();
            Lotto lotto = new Lotto(randomNumber);
            validateMoney(money);
            lotto.generateBonusNumber();
            this.playerLotto.add(lotto);
            count++;
        }
    }

    public void showLottoNumbers(int idx) {
        String lottoNumbers = this.playerLotto.get(idx).getLottoNumbers();
        String convertedNumbers = lottoNumbers.replace(",", ", ");
        System.out.println(convertedNumbers);
    }

    public void showBonusNumber(int idx) {
        System.out.println(this.playerLotto.get(idx).getBonusNumber());
    }

    private void validateMoney(int money) {
        if (money/1000 != 0) throw new IllegalArgumentException("[ERROR] 투입 금액은 1000원으로 나누어 떨어져야 합니다.");
    }
}
