import java.util.Random;
import java.util.stream.IntStream;

public class Dice {
    private int dice;
    private IntStream randomDice;

    public int rollDice() {
        System.out.println("주사위를 몇번 굴리시겠습니까?");
        dice = Main.scan.nextInt();
        return dice;
    }

    public IntStream randomDice(int diceCount) {
        randomDice = new Random().ints(0, 9).limit(diceCount);
        return randomDice;
    }
}
