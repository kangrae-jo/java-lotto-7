package model;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoMakerTest {

    @Test
    void 로또_생성_개수_테스트() {
        int lottoCount = 5;
        LottoMaker lottoMaker = new LottoMaker(lottoCount);
        lottoMaker.makeLottos();

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(lottoMaker.getLottos()).hasSize(lottoCount);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45)
        );
    }

    // TODO: 랜덤 테스트가 제대로 안되는 상황 해결
    @Test
    void 로또_생성_번호_테스트() {
        int lottoCount = 5;
        LottoMaker lottoMaker = new LottoMaker(lottoCount);
        lottoMaker.makeLottos();
        List<Lotto> lottos = lottoMaker.getLottos();

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(lottos.get(0).getNumbers()).contains(8, 21, 23, 41, 42, 43);
                    assertThat(lottos.get(1).getNumbers()).contains(3, 5, 11, 16, 32, 38);
                    assertThat(lottos.get(2).getNumbers()).contains(7, 11, 16, 35, 36, 44);
                    assertThat(lottos.get(3).getNumbers()).contains(1, 8, 11, 31, 41, 42);
                    assertThat(lottos.get(4).getNumbers()).contains(13, 14, 16, 38, 42, 45);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45)
        );
    }

}