package lotto.model;

import lotto.validation.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class Player {

    InputValidator inputValidator = new InputValidator();

    private int money;
    private final int LOTTO_PRICE = 1000;

    public List<Lotto> playerLotto = new ArrayList<>();

    public Player(int money) {
        this.money = money;
        getLotto(money);
    }

    /*
    테스트용 생성자
     */
//    public Player(Lotto lotto) {
//        this.playerLotto.add(lotto);
//        lotto.generateBonusNumber("7");
//    }

    private void getLotto(int money) {
        int count = 0;
        while (count < money/LOTTO_PRICE) {
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            List<Integer> randomNumber = lottoNumberGenerator.generateLottoNumbers();
            inputValidator.validateMoney(money);
            Lotto lotto = new Lotto(randomNumber);
            lotto.generateBonusNumber();
            this.playerLotto.add(lotto);
            count++;
        }
    }

    public void showLottoNumbers() {
        int lottoCount = playerLotto.size();
        for (int idx=0; idx<lottoCount; idx++) {
            showLottoNumbers(idx);
        }
        System.out.println();
    }

    private void showLottoNumbers(int idx) {
        String lottoNumbers = this.playerLotto.get(idx).getLottoNumbers();
        System.out.println(lottoNumbers);
    }

    public void showBonusNumber(int idx) {
        System.out.println(this.playerLotto.get(idx).getBonusNumber());
    }



    public int getMoney() {
        return money;
    }
}
