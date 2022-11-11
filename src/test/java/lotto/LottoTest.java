package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.controller.LottoController;
import lotto.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest extends NsTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @Test
    void 로또넘버와_추가넘버_정상_생성되는지_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isOverlappedNumbersAndBonusNumber()).isEqualTo(false);
    }

    @Test
    void 당첨번호_생성_테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getLottoNumbers()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 당첨금액_잘_매핑되는지_테스트() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        lotto.generateBonusNumber("9");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,7", "9");
        LottoNumberMatcher lottoNumberMatcher = new LottoNumberMatcher(winningNumbers);
        RewardMapper rewardMapper = lottoNumberMatcher.getLottoMapper(lotto);
        assertThat(rewardMapper.reward).isEqualTo(30000000);
    }

    @Test
    void 당첨금액_잘_매핑되는지_테스트2() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        lotto.generateBonusNumber("9");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "9");
        LottoNumberMatcher lottoNumberMatcher = new LottoNumberMatcher(winningNumbers);
        RewardMapper rewardMapper = lottoNumberMatcher.getLottoMapper(lotto);
        assertThat(rewardMapper.reward).isEqualTo(2000000000);
    }

    @Test
    void 투입_금액_만큼_로또가_구매되는지_테스트() {
        Player player = new Player(6000);
        assertThat(player.playerLotto.size()).isEqualTo(6);
    }

    @Test
    void 천원으로_나누어_떨어지지_않을_때_에러발생_테스트() {
        assertThatThrownBy(() -> new Player(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 결과테스트() {
        LottoController lottoController = new LottoController();
        lottoController.buyLottoAndShowResult();
    }


    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("100j");
            System.out.println("아웃풋 : " + output());
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
