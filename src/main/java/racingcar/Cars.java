package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import view.UserInterFace;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
        validateDuplicatedCarName();
    }

    public void validateDuplicatedCarName(){
        Set<String> carNames = new HashSet<>();
        for (Car car : cars) {
            carNames.add(car.toString());
        }
        if(carNames.size() != cars.size()){
            throw new IllegalArgumentException("[ERROR] 자동차 이름 중복");
        }
    }

    public void moveCars(){
        for (Car car : cars) {
            car.move(generateRandomNumber());
            car.printCarNameAndPosition();
        }
        UserInterFace.printMsg("");
    }

    private int generateRandomNumber(){
        return Randoms.pickNumberInRange(1,9);
    }

    public void printWinners(){
        StringBuffer sb = new StringBuffer();
        cars.sort((o1, o2) -> o2.getCarPosition().getPosition() - o1.getCarPosition().getPosition());
        sb.append(cars.get(0)).append(",");
        for (int i = 1; i < cars.size(); i++) {
            if(cars.get(i-1).getCarPosition().equals(cars.get(i).getCarPosition())){
                sb.append(cars.get(i)).append(",");
            }
        }

        String winners = sb.toString();
        UserInterFace.printMsg("최종 우승자 : "+winners.substring(0, winners.length()-1));
    }

}
