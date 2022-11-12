package lotto.view;

import lotto.model.RewardMapper;

public class OutputView {
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계 \n ---.";
    private static final String PLAYER_BUY_LOTTO_MESSAGE = "개를 구매했습니다.";


    public void showWinningStatisticsMessage() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
    }

    public void showPlayerBuyLottoMessage() {
        System.out.println(PLAYER_BUY_LOTTO_MESSAGE);
    }
}
