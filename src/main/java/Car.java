public class Car /*implements Comparable<Car>*/{

    private String model;

    private int voulme;

    public Car(String model, int voulme) {
        this.model = model;
        this.voulme = voulme;
    }

    public String getModel() {
        return model;
    }

    public int getVoulme() {
        return voulme;
    }

    /*@Override
    public int compareTo(Car car) {
        return this.voulme - car.voulme;
    }*/

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", voulme=" + voulme +
                '}';
    }
}
