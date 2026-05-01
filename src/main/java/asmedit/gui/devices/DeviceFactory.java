/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.gui.devices;

import asmedit.machine.Device;
import javax.swing.JFrame;

/**
 *
 * @author koukola
 */
public abstract class DeviceFactory {
    public abstract Device newDevice();
    public abstract JFrame newWindow(Device d);
    public abstract String getName();
    
    public static DeviceFactory[] factories = new DeviceFactory[]{
        new ConsoleDeviceFactory(),
        new KeyboardDeviceFactory(),
        new TextOutputDeviceFactory()
    };
}
