package devices;

public class DoorLock extends Device {
    public DoorLock(int id) {
        super(id, "door");
    }

    @Override
    public void on() {
        status = true;
        System.out.println("Door " + id + " unlocked.");
    }

    @Override
    public void off() {
        status = false;
        System.out.println("Door " + id + " locked.");
    }
}
