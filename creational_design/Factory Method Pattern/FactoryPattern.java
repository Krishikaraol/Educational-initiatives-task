// Product Interface
import java.util.*;
interface Vehicle {
    void drive();
}

// Concrete Products
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike.");
    }
}

// Factory Class
class VehicleFactory {
    public Vehicle createVehicle(String type) {
        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("bike")) {
            return new Bike();
        }
        return null;
    }
}

// Demo: Vehicle Factory
public class FactoryPattern {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter vehicle type (car/bike): ");
        String type = scanner.nextLine();

        Vehicle vehicle = factory.createVehicle(type);
        if (vehicle != null) {
            vehicle.drive();
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }
}
