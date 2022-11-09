package lotto.model;

import java.util.List;

public class Player {
    List<Lotto> lottoList;
    List<Integer> BonusNumbers;

    public Player(int repeatCounts) {
        getLotto((repeatCounts));
    }

    private void getLotto(int repeatCounts) {
        int count = 0;
        while (count <= repeatCounts) {
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            List<Integer> randomNumber = lottoNumberGenerator.generateLottoNumbers();
            Lotto lotto = new Lotto(randomNumber);
            this.lottoList.add(lotto);
            count++;
        }
    }

    public void showLottoNumber(int idx) {
        String lottoNumbers = this.lottoList.get(idx).toString();
        String convertedNumbers = lottoNumbers.replace(",", ", ");
        System.out.println();
        }

    public void showBonusNumber(int idx) {
        System.out.println(this.BonusNumbers.get(idx));
    }
}
