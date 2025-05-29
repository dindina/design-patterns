package creational;

class Car {
    String engine;
    String color;
    int seats;

    private Car(String engine, String color, int seats) {
        this.engine = engine;
        this.color = color;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return engine + '-' + color + "-" + seats;
    }

    public static CarBuilder builder() {
        return new CarBuilder();
    }

    public static class CarBuilder {

        String engine;
        String color;
        int seats;

        CarBuilder() {
        }

        public Car build() {
            return new Car(engine, color, seats);
        }

        public CarBuilder engine(String engineType) {
            this.engine = engineType;
            return this;
        }

        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder seats(int seats) {
            this.seats = seats;
            return this;
        }

    }

}

public class BuilderPattern {

    public static void main(String[] args) {
        Car car = Car.builder().color("red").engine("diesel").seats(4).build();

        System.out.println(car);

    }
}
