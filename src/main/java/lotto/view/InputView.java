package lotto.view;

public class InputView {
    private static final String BUYING_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public void showBuyingAmountMessage() {
        System.out.println(BUYING_AMOUNT_MESSAGE);
    }

    public void showEnterBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void showEnterWinningNumberMessage() {
        System.out.println(ENTER_WINNING_NUMBER_MESSAGE);
    }

}
