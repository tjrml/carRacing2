import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CarRacing {

    public static final int CONDITIONALS = 4;
    private List<String> winnerList = new ArrayList<>();
    private Dice dice = new Dice();
    private CarFactory carFactory = new CarFactory();


    public void startGame() {
        int diceCount = dice.rollDice();
        List<Car> carList = carFactory.createCar();
        racingGame(carList, diceCount);
    }

    private void racingGame(List<Car> carList, int diceCount) {
        carList.forEach(car -> {
            long moveCount = dice.randomDice(diceCount).filter(randomDice -> randomDice > CONDITIONALS).count();
            car.setMove((int) moveCount);
            printResult(car);
        });
//        carList.stream().forEach(CarRacing::printResult);
        getWinner(carList);
    }

    private void printResult(Car car) {
        System.out.print(car.getName() + ": ");
        for (int i = 0; i < car.getMove(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void getWinner(List<Car> carList) {
        carList.stream()
                .filter(car -> car.getMove() == getMaxNumber(carList))
                .forEach(car -> {
            winnerList.add(car.getName());
        });

        printWinner(winnerList);
    }

    private int getMaxNumber(List<Car> carList) {
        Optional<Integer> maxNumber = carList.stream().map(Car::getMove).reduce(Integer::max);
//        OptionalInt maxNumber = carList.stream().mapToInt(Car::getMove).max();
        return maxNumber.orElseThrow(NumberFormatException::new);
    }

    private void printWinner(List<String> winnerList) {
        String[] winnerArray = winnerList.stream().toArray(String[]::new);
        System.out.println("winner: " + Arrays.toString(winnerArray));
    }
}


