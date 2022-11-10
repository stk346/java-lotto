package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Lotto> playerLotto = new ArrayList<>();

    public Player(int money) {
        getLotto(money);
    }

    private void getLotto(int money) {
        int count = 0;
        while (count < money/1000) {
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            List<Integer> randomNumber = lottoNumberGenerator.generateLottoNumbers();
            Lotto lotto = new Lotto(randomNumber);
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
}
