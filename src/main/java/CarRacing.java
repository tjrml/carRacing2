import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CarRacing {

    public static final int CONDITIONALS = 4; //변수명을 단수로 표현하면 좋을 것 같아요.
    private List<String> winnerList = new ArrayList<>();//변수명에 자료구조를 직접 쓰기 보단 복수형으로 표현해도 좋을 것 같아요
    // e.g. winners or winnerGroup
    private Dice dice = new Dice(); // final 키워드를 활용해 보시면 좋을 것 같아요.
    private CarFactory carFactory = new CarFactory();


    public void startGame() {
        int diceCount = dice.rollDice();
        List<Car> carList = carFactory.createCar();
        racingGame(carList, diceCount);
        // 개행을 통해서 코드의 문맥을 분리하면 가독성에 도움이 될 것 같아요.
    }

    private void racingGame(List<Car> carList, int diceCount) {
        carList.forEach(car -> {
            long moveCount = dice.randomDice(diceCount).filter(randomDice -> randomDice > CONDITIONALS).count();
            //stream이나 optional처럼 메서드 체인이 있는 경우 . 마다 개행해주면 가독성에 도움이 됩니다.

            car.setMove((int) moveCount);
            printResult(car);
        });
//        carList.stream().forEach(CarRacing::printResult);
        getWinner(carList);
    }

    private void printResult(Car car) {
        System.out.print(car.getName() + ": ");
        for (int i = 0; i < car.getMove(); i++) {// i값을 쓰는 for 보다 향상된 for문이 가독성이 좋을 것 같아요.
            System.out.print("-");
        }
        System.out.println(); //자주 사용되는 system.out.print~ 메서드도 분리해서 사용하면 재활용 할 수 있을 것 같아요.
    }

    private void getWinner(List<Car> carList) {
        carList.stream()
                .filter(car -> car.getMove() == getMaxNumber(carList))// 위치가 같음을 직접 비교하기 보다 car 객체에게 같은지 물어보는 것도 좋을 것 같아요.
                .forEach(car -> {
            winnerList.add(car.getName());
        });

        printWinner(winnerList);
    }

    private int getMaxNumber(List<Car> carList) {
        Optional<Integer> maxNumber = carList.stream()
                .map(Car::getMove)
                .reduce(Integer::max);
//        OptionalInt maxNumber = carList.stream().mapToInt(Car::getMove).max();
        return maxNumber.orElseThrow(NumberFormatException::new);
    }

    private void printWinner(List<String> winnerList) {
        String[] winnerArray = winnerList.stream().toArray(String[]::new);
        System.out.println("winner: " + Arrays.toString(winnerArray));
    }
}


