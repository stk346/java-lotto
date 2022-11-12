package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoRewardCalculator;
import lotto.model.Player;
import lotto.model.WinningNumbers;
import lotto.validation.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputValidator inputValidator = new InputValidator();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    private final int LOTTO_PRICE = 1000;

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
        inputValidator.validateInputMoney(stringMoney);
        System.out.println();
        int money = Integer.parseInt(stringMoney);
        Player player = new Player(money);
        System.out.print(money / LOTTO_PRICE);
        outputView.showPlayerBuyLottoMessage();
        return player;
    }

    private void showLottoNumbers(Player player) {
        player.showLottoNumbers();
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
        inputValidator.validateBonusNumber(inputBonusNumber);
        return inputBonusNumber;
    }

    private String getAndValidateWinningNumbers() {
        inputView.showEnterWinningNumberMessage();
        String inputWinningNumbers = Console.readLine();
        System.out.println();
        inputValidator.validateInputWinningNumbers(inputWinningNumbers);
        return inputWinningNumbers;
    }
}
