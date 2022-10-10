package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("자동차 중복 이름 테스트")
    public void validateDuplicatedCarNameTest(){
        //given
        String given = "jpp";
        Car car1 = new Car(given);
        Car car2 = new Car(given);

        //when then
        assertThatThrownBy(
                () -> {
                    new Cars(Arrays.asList(car1, car2));
                }
        )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]");
    }
}