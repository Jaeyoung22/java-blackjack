package domain.game;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProfitRatioTest {

    @ParameterizedTest(name = "플레이어의 결과에 따라 비율을 반환한다.")
    @CsvSource({"-1,0,1.5",
        "0,0,-1",
        "21,20,1",
        "19,21,-1"})
    void fetchProfitRatio(int playerHandValue, int dealerHandValue, double ratio) {
        assertThat(ProfitRatio.fetchProfitRatio(playerHandValue, dealerHandValue)).isEqualTo(ratio);
    }
}
