/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.gui.devices;

import asmedit.machine.Device;
import asmedit.machine.devices.ConsoleDevice;
import asmedit.machine.devices.KeyboardDevice;
import javax.swing.JFrame;

/**
 *
 * @author koukola
 */
public class KeyboardDeviceFactory extends DeviceFactory {
    public Device newDevice() {
        return new KeyboardDevice();
    }

    public JFrame newWindow(Device d) {
        return new KeyboardDeviceWindow((KeyboardDevice)d);
    }
    
    public String getName() {
        return "Keyboard device";
    }
}
