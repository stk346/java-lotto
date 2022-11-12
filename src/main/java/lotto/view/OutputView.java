package lotto.view;

import lotto.model.RewardMapper;

public class OutputView {
    private static final String RETURN_RATIO_MESSAGE = "총 수익률은 %.1f";
    private static final String NUMBER_MATCHES_MESSAGE = "%s개 일치 ";
    private static final String WINNING_REVENUE_MESSAGE = "(%,d원)";
    private static final String MATCHES_COUNT_MESSAGE = " - %s개";

    private static final String WINNING_STATISTICS_MESSAGE = "당첨 콩계 \n ---.";



    public static void showLottoResultMessage(RewardMapper rewardMapper, int matchesCount) {
        System.out.println(
                String.format(NUMBER_MATCHES_MESSAGE , rewardMapper.matchingNumber)
                        + String.format(WINNING_REVENUE_MESSAGE, rewardMapper.reward)
                        + String.format(MATCHES_COUNT_MESSAGE, matchesCount));
    }

    public static void showReturnRatioMessage(double totalRevenueRatio) {
        System.out.println(String.format(RETURN_RATIO_MESSAGE, totalRevenueRatio) + "%입니다.");
    }

    public void showWinningStatisticsMessage() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
    }


}
