public class Car{
    //객체가 하는 일이 너무 없네요
    // CarRacing에서 수행하는 메서드 중에 Car로 옮길 수 있는 것들은 옮겨 보시는 것도 좋을 것 같아요.
    private String name;
    private int move;

    public Car(){}
    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
}
