package lotto;

import lotto.model.Lotto;
import lotto.model.LottoNumberGenerator;
import lotto.model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
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
    void 오름차순으로_정렬_테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 6, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또넘버와_추가넘버_정상_생성되는지_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isOverlappedNumbersAndBonusNumber()).isEqualTo(false);
    }
}
