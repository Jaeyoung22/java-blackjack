package blackjack.domain.state;

import blackjack.domain.Fixture;
import blackjack.state.PlayerHit;
import blackjack.state.State;
import blackjack.state.StateFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerHitTest {

    @DisplayName("초기 Hit상태 확인")
    @Test
    void initialHitCheck() {
        State state = StateFactory.initialPlayerDraw(Fixture.CLUBS_KING, Fixture.CLUBS_TWO);

        assertThat(state).isExactlyInstanceOf(PlayerHit.class);
    }
}