/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.gui.devices;

import asmedit.machine.Device;
import asmedit.machine.devices.TextOutputDevice;
import javax.swing.JFrame;

/**
 *
 * @author koukola
 */
public class TextOutputDeviceFactory extends DeviceFactory {
    public Device newDevice() {
        return new TextOutputDevice();
    }

    public JFrame newWindow(Device d) {
        return new TextOutputDeviceWindow((TextOutputDevice)d);
    }
    
    public String getName() {
        return "Text output device";
    }
}
