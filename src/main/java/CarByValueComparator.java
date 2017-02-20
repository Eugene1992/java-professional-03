import java.util.Comparator;

public class CarByValueComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return car1.getVoulme() - car2.getVoulme();
    }
}
