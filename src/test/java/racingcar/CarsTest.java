package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Constants.ErrorMessage.ERR_MSG_TITLE;

class CarsTest {

    private final String EXPECTED_CONTAINING_ERR_MSG = "[ERROR]";
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
        .hasMessageContaining(ERR_MSG_TITLE);
    }
}