package racingcar;

public class MoveCount {
    private final int moveCount;

    public MoveCount(String moveCount){
        validateNull(moveCount);
        validateNumberFormat(moveCount);
        this.moveCount = Integer.parseInt(moveCount);
        validateNumber(this.moveCount);
    }

    public static void validateNull(String moveCount){
        if(moveCount == null || moveCount.isEmpty()){
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 0이상 숫자만 입력 가능");
        }
    }

    private static void validateNumberFormat(String moveCount){
        try {
            Integer.parseInt(moveCount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 0이상 숫자만 입력 가능");
        }
    }

    private void validateNumber(int moveCount){
        if(moveCount < 1){
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 0이상 숫자만 입력 가능");
        }
    }

    public int getMoveCount(){
        return moveCount;
    }
}
