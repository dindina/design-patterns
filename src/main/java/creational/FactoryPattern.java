package creational;


interface Vehicle{
    String getType();

}

class Car implements Vehicle{

    @Override
    public String getType() {
        return "car";
    }
}

class Bike implements  Vehicle{

    @Override
    public String getType() {
        return "bike";
    }
}

class Truck implements Vehicle{

    @Override
    public String getType() {
        return "truck";
    }
}

abstract class VehicleFactory{
    abstract Vehicle createVehicle();
}

class BikeFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Bike();
    }
}

/*
The Factory pattern is used when you need to create objects
but want to hide the details of their concrete implementations.
It promotes flexibility and maintainability by decoupling the client code
from the object creation process.
It centralizes object creation.
The Java library uses factory patterns to provide locale specific objects,
driver specific objects, and many other things.
ex
 // Assumes JDBC driver is loaded
 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
 */

class CarFactory extends  VehicleFactory{

    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}

class TruckFactory extends  VehicleFactory{

    @Override
    Vehicle createVehicle() {
        return new Truck();
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory truckFactory = new TruckFactory();
        VehicleFactory bikeFactory = new BikeFactory();

        Vehicle car = carFactory.createVehicle();
        System.out.println(car.getType());

        Vehicle bike = bikeFactory.createVehicle();
        System.out.println(bike.getType());

        Vehicle truck = truckFactory.createVehicle();
        System.out.println(truck.getType());
    }
}
