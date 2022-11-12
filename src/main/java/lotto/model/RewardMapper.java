package lotto.model;

public enum RewardMapper {
    FIRST_PLACE(6, false, 2000000000),
    SECOND_PLACE(5, true, 30000000),
    THIRD_PLACE(5, false, 1500000),
    FOURTH_PLACE(4, false, 50000),
    FIFTH_PLACE(3, false, 5000),
    NO_PLACE(0, false, 0);

    public final int matchingNumber;
    public final boolean isBonusNumberMatches;
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

    public static void showResult(int firstPlace, int secondPlace, int thirdPlace, int fourthPlace, int fifthPlace) {
        System.out.println(
                String.format("%s개 일치 " , RewardMapper.FIFTH_PLACE.matchingNumber)
                        + String.format("(%,d원)", RewardMapper.FIFTH_PLACE.reward)
                        + String.format(" - %s개", fifthPlace));
        System.out.println(
                String.format("%s개 일치 " , RewardMapper.FOURTH_PLACE.matchingNumber)
                        + String.format("(%,d원)", RewardMapper.FOURTH_PLACE.reward)
                        + String.format(" - %s개", fourthPlace));
        System.out.println(
                String.format("%s개 일치 " , RewardMapper.THIRD_PLACE.matchingNumber)
                        + String.format("(%,d원)", RewardMapper.THIRD_PLACE.reward)
                        + String.format(" - %s개", thirdPlace));
        System.out.println(
                String.format("%s개 일치, " , RewardMapper.SECOND_PLACE.matchingNumber)
                        + "보너스 볼 일치 "
                        + String.format("(%,d원)", RewardMapper.SECOND_PLACE.reward)
                        + String.format(" - %s개", secondPlace));
        System.out.println(
                String.format("%s개 일치 " , RewardMapper.FIRST_PLACE.matchingNumber)
                        + String.format("(%,d원)", RewardMapper.FIRST_PLACE.reward)
                        + String.format(" - %s개", firstPlace));
    }

    public static int getRevenue(int firstPlace, int secondPlace, int thirdPlace, int fourthPlace, int fifthPlace) {
        int fifthRevenue = RewardMapper.FIFTH_PLACE.reward * fifthPlace;
        int fourthRevenue = RewardMapper.FOURTH_PLACE.reward * fourthPlace;
        int thirdRevenue = RewardMapper.THIRD_PLACE.reward * thirdPlace;
        int secondRevenue = RewardMapper.SECOND_PLACE.reward * secondPlace;
        int firstRevenue = RewardMapper.FIRST_PLACE.reward * firstPlace;
        return  fifthRevenue + fourthRevenue + thirdRevenue + secondRevenue + firstRevenue;
    }
}
