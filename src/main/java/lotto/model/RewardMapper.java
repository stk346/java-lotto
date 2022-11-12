package lotto.model;

import lotto.view.OutputView;

public enum RewardMapper {
    FIRST_PLACE(6, false, 2000000000),
    SECOND_PLACE(5, true, 30000000),
    THIRD_PLACE(5, false, 1500000),
    FOURTH_PLACE(4, false, 50000),
    FIFTH_PLACE(3, false, 5000),
    NO_PLACE(0, false, 0);

    private static final String NUMBER_MATCHES_MESSAGE = "%s개 일치 ";
    private static final String WINNING_REVENUE_MESSAGE = "(%,d원)";
    private static final String MATCHES_COUNT_MESSAGE = " - %s개";

    private final int matchingNumber;
    private final boolean isBonusNumberMatches;
    public final int reward;

    RewardMapper(int matchingNumber, boolean isBonusNumberMatches, int reward) {
        this.matchingNumber = matchingNumber;
        this.reward = reward;
        this.isBonusNumberMatches = isBonusNumberMatches;
    }

    public static RewardMapper getRewardMapper(int matchingNumber, boolean isBonusNumberMatches) {
        for (int idx = 0; idx< RewardMapper.values().length; idx++) {
            RewardMapper[] rewardElement = RewardMapper.values();
            if (matchingNumber == rewardElement[idx].matchingNumber && isBonusNumberMatches == rewardElement[idx].isBonusNumberMatches) {
                return rewardElement[idx];
            }
        }
        return NO_PLACE;
    }

    public static void showLottoResultMessage(RewardMapper rewardMapper, int matchesCount) {
        System.out.println(
                String.format(NUMBER_MATCHES_MESSAGE , rewardMapper.matchingNumber)
                        + String.format(WINNING_REVENUE_MESSAGE, rewardMapper.reward)
                        + String.format(MATCHES_COUNT_MESSAGE, matchesCount));
    }
}
