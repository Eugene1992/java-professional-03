import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        ListIterator<String> listIterator = strings.listIterator(strings.size());
        while (listIterator.hasPrevious()) {
            String previous = listIterator.previous();
            System.out.println(previous);
        }
        System.out.println(strings);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", 150));
        cars.add(new Car("Tesla", 100));
        cars.add(new Car("Volvo", 250));

        System.out.println(cars);
        Collections.sort(cars, new CarByValueComparator());
        System.out.println(cars);

        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return c2.getModel().compareTo(c1.getModel());
            }
        });
        System.out.println(cars);

    }
}
