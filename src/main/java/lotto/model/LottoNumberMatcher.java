package lotto.model;

public class LottoNumberMatcher {
    WinningNumbers winningNumbers;

    public LottoNumberMatcher(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getReward(Lotto lotto) {
        int matchingNumber = getMatchingNumber(lotto);
        boolean isBonusNumberMatches = isBonusNumberMatches(lotto);
        if (matchingNumber != 5) {
            isBonusNumberMatches = false;
        }

        return RewardMapper.getReward(matchingNumber, isBonusNumberMatches);
    }

    private int getMatchingNumber(Lotto lotto) {
        int matchingNumberCounts = 0;
        for (int idx=0; idx<winningNumbers.winningNumbers.size(); idx++) {
            if (this.winningNumbers.winningNumbers.get(idx) == lotto.getLottoNumber(idx)) {
                matchingNumberCounts++;
            }
        }
        return matchingNumberCounts;
    }

    private boolean isBonusNumberMatches(Lotto lotto) {
        return this.winningNumbers.winningBonusNumber == lotto.getBonusNumber();
    }
}
