import java.util.ArrayList;

public class Race {

    Car winner = null;
    ArrayList<Car> cars = new ArrayList<>();

    private int calcDistance(Car car, int hours) {
        return car.speed * hours;
    }

    public void Registration(Car car) {
        cars.add(car);
    }

    public void Start(int raceHours) {

        winner = null;
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (winner == null) {
                winner = car;
            } else {
                if (calcDistance(car, raceHours) > calcDistance(winner, raceHours)) {
                    winner = car;
                }
            }
        }

    }

    public Car getWinner() {
        return winner;
    }

}
