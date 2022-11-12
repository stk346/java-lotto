package lotto.model;

public class LottoNumberMatcher {
    WinningNumbers winningNumbers;

    private final int SECOND_OR_THIRD_PlACE_MATCHING_NUMBER = 5;

    public LottoNumberMatcher(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public RewardMapper getLottoMapper(Lotto lotto) {
        int matchingNumber = getMatchingNumber(lotto);
        boolean isBonusNumberMatches = isBonusNumberMatches(lotto);
        if (matchingNumber != SECOND_OR_THIRD_PlACE_MATCHING_NUMBER) {
            isBonusNumberMatches = false;
        }

        return RewardMapper.getRewardMapper(matchingNumber, isBonusNumberMatches);
    }

    private int getMatchingNumber(Lotto lotto) {
        int matchingNumberCounts = 0;
        for (int idx=0; idx<winningNumbers.winningNumbers.size(); idx++) {
            if (this.winningNumbers.winningNumbers.contains(lotto.getLottoNumber(idx))) {
                matchingNumberCounts++;
            }
        }
        return matchingNumberCounts;
    }

    private boolean isBonusNumberMatches(Lotto lotto) {
        return this.winningNumbers.winningBonusNumber == lotto.getBonusNumber();
    }
}
