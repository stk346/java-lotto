package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoRewardCalculator;
import lotto.model.Player;
import lotto.model.WinningNumbers;

public class LottoController {

    public void buyLottoAndShowResult() {
        Player player = buyLottoAndReturnPlayer();
        showLottoNumbers(player);
        WinningNumbers winningNumbers = getWinningNumbers();
        LottoRewardCalculator lottoRewardCalculator = new LottoRewardCalculator(winningNumbers);

        System.out.println("당첨 통계");
        System.out.println("---");
        lottoRewardCalculator.showRewardStatistics(player);
        lottoRewardCalculator.showTotalReturn(player);
    }

    private Player buyLottoAndReturnPlayer() {
        System.out.println("구입금액을 입력해 주세요.");
        String stringMoney = Console.readLine();
        System.out.println();
        validateInputMoney(stringMoney);
        int money = Integer.parseInt(stringMoney);
        Player player = new Player(money);
        System.out.println(money / 1000 + "개를 구매했습니다.");
        return player;
    }

    private void showLottoNumbers(Player player) {
        player.showLottoNumbers();
    }

    private void validateInputMoney(String money) {
        for (int i=0; i<money.length(); i++) {
            if (!Character.isDigit(money.charAt(i))) {
                throw new IllegalArgumentException("올바른 숫자 형식을 입력해주세요.");
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
        System.out.println("보너스 번호를 입력해 주세요;.");
        String inputBonusNumber = Console.readLine();
        System.out.println();
        validateBonusNumber(inputBonusNumber);
        return inputBonusNumber;
    }

    private void validateBonusNumber(String bonusNumber) {
        if (!Character.isDigit(bonusNumber.charAt(0))) {
            throw new IllegalArgumentException("보너스 넘버는 숮자만 가능합니다.");
        }
    }

    private String getAndValidateWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = Console.readLine();
        System.out.println();
        validateInputWinningNumbers(inputWinningNumbers);
        return inputWinningNumbers;
    }

    private void validateInputWinningNumbers(String winningNumbers) {
        if (!winningNumbers.contains(",")) {
            throw new IllegalArgumentException("로또 넘버는 콤마(,)로 구분돼야 합니다.");
        }
        String[] InputOfSeparatedInComma = winningNumbers.split(",");
        for (String s : InputOfSeparatedInComma) {
            if (!Character.isDigit(s.charAt(0))) {
                throw new IllegalArgumentException("로또 넘버는 숫자만 들어올 수 있습니다.");
            }
        }
    }

    private int getMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        System.out.println();
        return  Integer.parseInt(Console.readLine());
    }
}
