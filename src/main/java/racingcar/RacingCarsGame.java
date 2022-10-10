package racingcar;

import view.UserInterFace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarsGame {

    private final Cars cars;
    private final MoveCount moveCount;

    public RacingCarsGame(){
        cars = mapCars();
        moveCount = mapMoveCount();
    }

    private Cars mapCars(){
        try {
            List<Car> cars = new ArrayList<>();
            for (String name : UserInterFace.getCarNames().split(",")) {
                cars.add(new Car(name));
            }
            return new Cars(cars);
        } catch (IllegalArgumentException e){
            UserInterFace.printMsg(e.getMessage());
            return mapCars();
        }
    }

    private MoveCount mapMoveCount(){
        try {
            return new MoveCount(UserInterFace.getMoveCount());
        } catch (IllegalArgumentException e){
            UserInterFace.printMsg(e.getMessage());
            return mapMoveCount();
        }
    }

    public void start(){
        for (int i = 0; i < moveCount.getMoveCount(); i++) {
            cars.moveCars();
        }
        cars.printWinners();
    }

}
