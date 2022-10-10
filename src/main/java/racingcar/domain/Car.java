package racingcar.domain;

import racingcar.view.UserInterFace;

public class Car {

    private static final String CAR_NAME_CAR_POSITION_DELIMITER = " : ";
    private static final int MOVE_FORWARD_NUM = 4;
    private final CarName carName;
    private final CarPosition carPosition;

    public Car(String carName){
        this.carName = new CarName(carName);
        carPosition = new CarPosition();
    }

    public void move(int num) {
        if(num >= MOVE_FORWARD_NUM){
            carPosition.moveForward();
        }
    }

    public void printCarNameAndPosition() {
        StringBuffer sb = new StringBuffer()
                                    .append(carName)
                                    .append(CAR_NAME_CAR_POSITION_DELIMITER)
                                    .append(carPosition);
        UserInterFace.printMsg(sb.toString());
    }

    public CarPosition getCarPosition(){
        return carPosition;
    }

    @Override
    public String toString() {
        return carName.toString();
    }
}