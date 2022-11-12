package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoRewardCalculator;
import lotto.model.Player;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.NoSuchElementException;

public class LottoController {

    private final String SPLIT_DELIMITER = ",";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void buyLottoAndShowResult() {
        Player player = buyLottoAndReturnPlayer();
        showLottoNumbers(player);
        WinningNumbers winningNumbers = getWinningNumbers();
        LottoRewardCalculator lottoRewardCalculator = new LottoRewardCalculator(winningNumbers);

        outputView.showWinningStatisticsMessage();
        lottoRewardCalculator.showRewardStatistics(player);
        lottoRewardCalculator.showTotalReturn(player);
    }

    private Player buyLottoAndReturnPlayer() {
        inputView.showBuyingAmountMessage();
        String stringMoney = Console.readLine();
        validateInputMoney(stringMoney);
        System.out.println();
        int money = Integer.parseInt(stringMoney);
        Player player = new Player(money);
        System.out.print(money / 1000);
        outputView.showPlayerBuyLottoMessage();
        return player;
    }

    private void showLottoNumbers(Player player) {
        player.showLottoNumbers();
    }

    private void validateInputMoney(String money) {
        for (int i=0; i<money.length(); i++) {
            if (!Character.isDigit(money.charAt(i))) {
                System.out.println("[ERROR] 올바른 숫자 형식을 입력해주세요.");
                throw new NoSuchElementException("[ERROR] 올바른 숫자 형식을 입력해주세요.");
            }
        }
    }

    private WinningNumbers getWinningNumbers() {
        String inputWinningNumbers = getAndValidateWinningNumbers();
        String inputBonusNumber = getAndValidateBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers, inputBonusNumber);
        return winningNumbers;
    }

    private String getAndValidateBonusNumber() {
        inputView.showEnterBonusNumberMessage();
        String inputBonusNumber = Console.readLine();
        System.out.println();
        validateBonusNumber(inputBonusNumber);
        return inputBonusNumber;
    }

    private void validateBonusNumber(String bonusNumber) {
        if (!Character.isDigit(bonusNumber.charAt(0))) {
            throw new IllegalArgumentException("[ERROR] 보너스 넘버는 숮자만 가능합니다.");
        }
    }

    private String getAndValidateWinningNumbers() {
        inputView.showEnterWinningNumberMessage();
        String inputWinningNumbers = Console.readLine();
        System.out.println();
        validateInputWinningNumbers(inputWinningNumbers);
        return inputWinningNumbers;
    }

    private void validateInputWinningNumbers(String winningNumbers) {
        if (!winningNumbers.contains(SPLIT_DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 로또 넘버는 콤마(,)로 구분돼야 합니다.");
        }
        String[] InputOfSeparatedInComma = winningNumbers.split(SPLIT_DELIMITER);
        for (String s : InputOfSeparatedInComma) {
            if (!Character.isDigit(s.charAt(0))) {
                throw new IllegalArgumentException("[ERROR] 로또 넘버는 숫자만 들어올 수 있습니다.");
            }
        }
    }
}
