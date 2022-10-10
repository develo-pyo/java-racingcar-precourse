package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoveCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "0", "a"})
    @DisplayName("자동차 이동 횟수 테스트")
    public void validateMoveCountTest_invalidValue(String given){
        //when then
        assertThatThrownBy(
                () -> {
                    new MoveCount(given);
                }
        )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("자동차 이동 횟수 테스트")
    public void validateMoveCountTest_null(String given){
        //when then
        assertThatThrownBy(
                () -> {
                    new MoveCount(given);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}