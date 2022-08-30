import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. 자동차 대수를 스캐너로 입력
 * 2. 주사위를 몇번 굴릴 것인지 스캐너로 입력
 * 3. else를 쓰지 않는다.
 * 4. 주사위의 수만큼 랜덤 주사위를 굴려 0~9까지의 수중 4이상이면 자동차는 움직일수 있다
 * 5. 우승차를 뽑아낸다.
 * */

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.startGame();

    }
}
