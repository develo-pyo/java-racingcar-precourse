package racingcar;

public class CarName {
    private static final int MAX_NAME_LENGTH = 4;
    private final String carName;

    public CarName(String carName){
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName){
        validateNull(carName);
        validateLength(carName);
    }

    public static void validateNull(String carName){
        if(carName == null || carName.isEmpty()){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1~4자");
        }
    }

    public static void validateLength(String carName) {
        if(carName == null || carName.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1~4자");
        }
    }

    @Override
    public String toString() {
        return carName;
    }
}
