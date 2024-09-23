package proxy;

import hub.SmartHub;
import devices.Device;

public class DeviceProxy {
    private SmartHub hub;

    public DeviceProxy(SmartHub hub) {
        this.hub = hub;
    }

    public void turnOn(int deviceId) {
        Device device = getDeviceById(deviceId);
        if (device != null) {
            System.out.println("Proxy: Access granted to turn on device " + deviceId);
            device.on();
        } else {
            System.out.println("Proxy: Access denied for device " + deviceId);
        }
    }

    public void turnOff(int deviceId) {
        Device device = getDeviceById(deviceId);
        if (device != null) {
            System.out.println("Proxy: Access granted to turn off device " + deviceId);
            device.off();
        } else {
            System.out.println("Proxy: Access denied for device " + deviceId);
        }
    }

    private Device getDeviceById(int deviceId) {
        for (Device device : hub.getDevices()) {  // Use the public getter to access devices
            if (device.getId() == deviceId) {
                return device;
            }
        }
        return null;
    }
}
