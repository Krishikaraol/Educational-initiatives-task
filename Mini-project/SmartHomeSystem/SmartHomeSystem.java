

import devices.*;
import factory.*;
import hub.*;
import proxy.DeviceProxy;
import java.util.Scanner;

public class SmartHomeSystem {
    public static void main(String[] args) {
        SmartHub hub = new SmartHub();
        DeviceProxy proxy = new DeviceProxy(hub);
        Scanner scanner = new Scanner(System.in);

        // Create initial devices using the factory method
        Device light1 = DeviceFactory.createDevice("light", 1);
        Device thermostat1 = DeviceFactory.createDevice("thermostat", 2);
        Device doorLock1 = DeviceFactory.createDevice("door", 3);

        // Add devices to the hub
        hub.addDevice(light1);
        hub.addDevice(thermostat1);
        hub.addDevice(doorLock1);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Smart Home Menu ===");
            System.out.println("1. View Status");
            System.out.println("2. Control Device");
            System.out.println("3. Set Schedule");
            System.out.println("4. Add Trigger");
            System.out.println("5. Simulate Temperature Change");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hub.displayStatus();
                    break;

                case 2:
                    System.out.println("Enter device ID to control (1 for light, 2 for thermostat, 3 for door): ");
                    int deviceId = scanner.nextInt();
                    System.out.println("Turn device on/off (1: on, 2: off): ");
                    int action = scanner.nextInt();
                    if (action == 1) {
                        proxy.turnOn(deviceId);
                    } else if (action == 2) {
                        proxy.turnOff(deviceId);
                    } else {
                        System.out.println("Invalid action.");
                    }
                    break;

                case 3:
                    System.out.println("Enter device ID to schedule (1 for light, 2 for thermostat, 3 for door): ");
                    int scheduleDeviceId = scanner.nextInt();
                    System.out.println("Enter time to schedule (HH:MM format): ");
                    String time = scanner.next();
                    System.out.println("Enter command (turnOn/turnOff): ");
                    String command = scanner.next();
                    hub.setSchedule(scheduleDeviceId, time, command);
                    break;

                case 4:
                    System.out.println("Enter trigger type (temperature): ");
                    String conditionType = scanner.next();
                    System.out.println("Enter operator (>, <): ");
                    String operator = scanner.next();
                    System.out.println("Enter value for the condition: ");
                    int value = scanner.nextInt();
                    System.out.println("Enter action (turnOn(deviceId)/turnOff(deviceId)): ");
                    String triggerAction = scanner.next();
                    hub.addTrigger(conditionType, operator, value, triggerAction);
                    break;

                case 5:
                    System.out.println("Enter new temperature: ");
                    int newTemp = scanner.nextInt();
                    hub.temperatureChanged(newTemp);
                    break;

                case 6:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
