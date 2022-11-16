package lotto;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final String name;

    private final int position;

    private final List<Integer> mileages;

    public Car(String name, int position, List<Integer> mileages) {
        this.name = name;
        this.position = position;
        this.mileages = new ArrayList<>(mileages);
    }

    public List<Integer> getMileages() {
        return new ArrayList<>(mileages);
    }
}
