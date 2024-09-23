package hub;

public class Schedule {
    private int deviceId;
    private String time;
    private String command;

    public Schedule(int deviceId, String time, String command) {
        this.deviceId = deviceId;
        this.time = time;
        this.command = command;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public String getTime() {
        return time;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String toString() {
        return "Schedule [device=" + deviceId + ", time=" + time + ", command=" + command + "]";
    }
}
