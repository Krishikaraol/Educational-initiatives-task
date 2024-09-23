package hub;

import devices.Device;

import java.util.List;

public class Trigger {
    private String conditionType;
    private String operator;
    private int value;
    private String action;

    public Trigger(String conditionType, String operator, int value, String action) {
        this.conditionType = conditionType;
        this.operator = operator;
        this.value = value;
        this.action = action;
    }

    public void evaluate(int currentValue, List<Device> devices) {
        if (conditionType.equals("temperature")) {
            if (operator.equals(">") && currentValue > value) {
                performAction(devices);
            } else if (operator.equals("<") && currentValue < value) {
                performAction(devices);
            }
        }
    }

    private void performAction(List<Device> devices) {
        for (Device device : devices) {
            String[] actionParts = action.split("\\(");
            String command = actionParts[0];
            int targetDeviceId = Integer.parseInt(actionParts[1].replace(")", ""));

            if (device.getId() == targetDeviceId) {
                if (command.equals("turnOff")) {
                    device.off();
                } else if (command.equals("turnOn")) {
                    device.on();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Trigger [conditionType=" + conditionType + ", operator=" + operator + ", value=" + value + ", action=" + action + "]";
    }
}
