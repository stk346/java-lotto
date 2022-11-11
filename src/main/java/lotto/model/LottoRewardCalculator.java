package lotto.model;

public class LottoRewardCalculator {

    int firstPlace = 0;
    int secondPlace = 0;
    int thirdPlace = 0;
    int fourthPlace = 0;
    int fifthPlace = 0;
    WinningNumbers winningNumbers;

    public LottoRewardCalculator(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void showRewardStatistics(Player player) {
        LottoNumberMatcher lottoNumberMatcher = new LottoNumberMatcher(winningNumbers);
        int lottoSize = player.playerLotto.size();

        for (int idx=0; idx<lottoSize; idx++) {
            Lotto lotto = player.playerLotto.get(idx);
            if (lottoNumberMatcher.getLottoMapper(lotto) == RewardMapper.FIRST_PLACE) firstPlace++;
            if (lottoNumberMatcher.getLottoMapper(lotto) == RewardMapper.SECOND_PLACE) secondPlace++;
            if (lottoNumberMatcher.getLottoMapper(lotto) == RewardMapper.THIRD_PLACE) thirdPlace++;
            if (lottoNumberMatcher.getLottoMapper(lotto) == RewardMapper.FOURTH_PLACE) fourthPlace++;
            if (lottoNumberMatcher.getLottoMapper(lotto) == RewardMapper.FIFTH_PLACE) fifthPlace++;
        }
        RewardMapper.showResult(firstPlace, secondPlace, thirdPlace, fourthPlace, fifthPlace);
    }

    public void showTotalReturn(Player player) {
        double totalRevenue = RewardMapper.getRevenue(firstPlace, secondPlace, thirdPlace, fourthPlace, fifthPlace);
        double investment = player.getMoney();
        double totalReturnRatio = (totalRevenue / investment)*100;
        double roundedTotalRevenueRatio = Math.round(totalReturnRatio*10)/10;
        System.out.println("총 수익률은 " + roundedTotalRevenueRatio + "%입니다.");
    }
}
