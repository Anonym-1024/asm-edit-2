/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.gui.devices;

import asmedit.machine.Device;
import asmedit.machine.devices.ConsoleDevice;
import javax.swing.JFrame;

/**
 *
 * @author koukola
 */
public class ConsoleDeviceFactory extends DeviceFactory {

    
    public Device newDevice() {
        return new ConsoleDevice();
    }

    public JFrame newWindow(Device d) {
        return new ConsoleDeviceWindow((ConsoleDevice)d);
    }
    
    public String getName() {
        return "Console device";
    }
    
}
