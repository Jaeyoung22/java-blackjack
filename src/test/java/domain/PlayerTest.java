package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class PlayerTest {
    @ParameterizedTest(name = "플레이어의 이름은 null이거나 공백일 수 없다.")
    @NullAndEmptySource
    void validatePlayerNameTest(String name) {
        assertThatThrownBy(() -> new Player(name)).isInstanceOf(IllegalArgumentException.class);
    }



    @Test
    @DisplayName("플레이어의 이름은 '딜러'일 수 없다.")
    void validateNoDealer() {
        assertThatThrownBy(() -> new Player("딜러")).isInstanceOf(IllegalArgumentException.class);
    }
}
