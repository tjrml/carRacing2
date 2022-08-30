import java.util.ArrayList;
import java.util.List;

public class CarFactory extends Car{
    private List<Car> carList = new ArrayList<>();

    public List<Car> createCar() {
        System.out.println("자동차를 몇대 생성 하시겠습니까?");
        int carCount = Main.scan.nextInt();
        for(int i = 1; i <= carCount; i++) {
            carList.add(new Car("car" + i));
        }
        return carList;
    }
}
