package lotto.model;

public enum RewardMapper {
    FIRST_PLACE(6, false, 2000000000),
    SECOND_PLACE(5, true, 30000000),
    THIRD_PLACE(5, false, 1500000),
    FOURTH_PLACE(4, false, 50000),
    FIFTH_PLACE(4, false, 5000);

    int matchingNumber;
    boolean isBonusNumberMatches;
    int reward;

    RewardMapper(int matchingNumber, boolean isBonusNumberMatches, int reward) {
        this.matchingNumber = matchingNumber;
        this.reward = reward;
        this.isBonusNumberMatches = isBonusNumberMatches;
    }

    public static int getReward(int matchingNumber, boolean isBonusNumberMatches) {
        int reward = 0;
        for (int idx = 0; idx< RewardMapper.values().length; idx++) {

            RewardMapper[] rewardElement = RewardMapper.values();
            if (matchingNumber == rewardElement[idx].matchingNumber && isBonusNumberMatches == rewardElement[idx].isBonusNumberMatches) {
                return reward += rewardElement[idx].reward;
            }
        }
        return reward;
    }
}
