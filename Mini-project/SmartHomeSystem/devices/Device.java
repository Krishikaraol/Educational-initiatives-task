package devices;

public abstract class Device {
    protected int id;
    protected String type;
    protected boolean status; // on/off status

    public Device(int id, String type) {
        this.id = id;
        this.type = type;
        this.status = false;
    }

    public abstract void on();

    public abstract void off();

    public int getId() {
        return id;
    }

    public boolean isOn() {
        return status;
    }

    public String getType() {
        return type;
    }
}
