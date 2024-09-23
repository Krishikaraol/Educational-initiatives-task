// Target Interface
interface Charger {
    void chargePhone();
}

// Adaptee
class ElectricOutlet {
    public void provideElectricity() {
        System.out.println("Providing electricity.");
    }
}

// Adapter Class
class ChargerAdapter implements Charger {
    private ElectricOutlet outlet;

    public ChargerAdapter(ElectricOutlet outlet) {
        this.outlet = outlet;
    }

    @Override
    public void chargePhone() {
        outlet.provideElectricity();
        System.out.println("Charging phone.");
    }
}

// Demo: Adapter Pattern
public class AdapterPattern {
    public static void main(String[] args) {
        ElectricOutlet outlet = new ElectricOutlet();
        Charger charger = new ChargerAdapter(outlet);

        charger.chargePhone();
    }
}
