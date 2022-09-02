import java.util.Random;
import java.util.stream.IntStream;

public class Dice {
    private int dice;
    private IntStream randomDice; // Stream이 꼭 필요할까요?

    public int rollDice() {
        System.out.println("주사위를 몇번 굴리시겠습니까?");
        dice = Main.scan.nextInt();
        return dice;
    }

    public IntStream randomDice(int diceCount) {
        randomDice = new Random().ints(0, 9).limit(diceCount);// 변수로 선언하기보다 바로 리턴하면 어떨까요?
        return randomDice;
    }
}
