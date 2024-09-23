// Component Interface
interface Car {
    void assemble();
}

// Concrete Component
class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Basic car.");
    }
}

// Decorator Class
abstract class CarDecorator implements Car {
    protected Car decoratedCar;

    public CarDecorator(Car decoratedCar) {
        this.decoratedCar = decoratedCar;
    }

    public void assemble() {
        decoratedCar.assemble();
    }
}

// Concrete Decorator
class SunroofCar extends CarDecorator {
    public SunroofCar(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding a sunroof.");
    }
}

// Demo: Decorator Pattern
public class DecoratorPattern {
    public static void main(String[] args) {
        Car basicCar = new BasicCar();
        Car sunroofCar = new SunroofCar(basicCar);

        sunroofCar.assemble();
    }
}
