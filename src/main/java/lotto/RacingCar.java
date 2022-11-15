package lotto;

import java.util.HashMap;

public class RacingCar {
    HashMap<String, Integer> cars = new HashMap<>();

    RacingCar(HashMap<String, Integer> cars) {
        this.cars = cars;
        addCars();
    }

    private void addCars() {
        cars.put("avante", 0);
        cars.put("sonata", 0);
    }

    private void move(String car, int randomNumber) {
        if (randomNumber >= 4) {
            cars.put(car, cars.get(car) + 1);
        }
    }

    public void setCars(String car, int position) {
        cars.put(car, cars.get(car) + position);
    }
}
