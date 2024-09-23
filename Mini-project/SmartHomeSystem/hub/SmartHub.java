package hub;

import devices.*;
import java.util.*;

public class SmartHub {
    private List<Device> devices = new ArrayList<>();
    private List<Schedule> schedules = new ArrayList<>();
    private List<Trigger> triggers = new ArrayList<>();

    // Method to add a device
    public void addDevice(Device device) {
        devices.add(device);
        System.out.println("Added " + device.getType() + " with ID " + device.getId() + " to the hub.");
    }

    // Public method to access the devices list (getter)
    public List<Device> getDevices() {
        return devices;
    }

    // Method to set a schedule
    public void setSchedule(int deviceId, String time, String command) {
        schedules.add(new Schedule(deviceId, time, command));
        System.out.println("Scheduled: Device " + deviceId + " to " + command + " at " + time);
    }

    // Method to add a trigger
    public void addTrigger(String conditionType, String operator, int value, String action) {
        triggers.add(new Trigger(conditionType, operator, value, action));
        System.out.println("Added Trigger: " + conditionType + " " + operator + " " + value + " -> " + action);
    }

    // Simulate a temperature change that triggers automation
    public void temperatureChanged(int newTemp) {
        System.out.println("Temperature changed to " + newTemp + " degrees.");
        for (Trigger trigger : triggers) {
            trigger.evaluate(newTemp, devices);
        }
    }

    // Display the status of all devices
    public void displayStatus() {
        for (Device device : devices) {
            String status = device.isOn() ? "On" : "Off";
            System.out.println(device.getType().substring(0, 1).toUpperCase() + device.getType().substring(1)
                               + " " + device.getId() + " is " + status);
        }
    }
}
