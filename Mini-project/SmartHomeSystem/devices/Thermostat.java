package devices;

public class Thermostat extends Device {
    private int temperature;

    public Thermostat(int id) {
        super(id, "thermostat");
        this.temperature = 70;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + id + " set to " + temperature + " degrees.");
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void on() {
        System.out.println("Thermostat " + id + " is controlling temperature.");
    }

    @Override
    public void off() {
        System.out.println("Thermostat " + id + " turned off.");
    }
}
