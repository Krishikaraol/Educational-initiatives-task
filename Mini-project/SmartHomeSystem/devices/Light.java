package devices;

public class Light extends Device {
    public Light(int id) {
        super(id, "light");
    }

    @Override
    public void on() {
        status = true;
        System.out.println("Light " + id + " turned on.");
    }

    @Override
    public void off() {
        status = false;
        System.out.println("Light " + id + " turned off.");
    }
}
