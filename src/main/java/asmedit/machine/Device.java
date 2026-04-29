/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.machine;

import asmedit.machine.devices.ConsoleDevice;
import asmedit.machine.devices.KeyboardDevice;
import asmedit.machine.devices.TextOutputDevice;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author koukola
 */
public abstract class Device {
    public abstract void write(int data);
    public abstract int read();
    
    
    protected InterruptRegister intr;
    
    protected void triggerIRQ() {
        intr.setIRQ();
        
    }
    
    protected void announceDataAvailable() {
        this.state = 1;
        triggerIRQ();
    }
    
    protected void clearDataAvailable() {
        this.state = 0;
        
    }
    
    protected int state;
    
    protected int readState() {
        return state;
    }
    
    protected PropertyChangeSupport pcs;
    
    public void addListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
        
    }

    public void setIntr(InterruptRegister intr) {
        this.intr = intr;
    }
    
    
    public Device() {
        pcs = new PropertyChangeSupport(this);
        state = 0;
        
    }
    
    
    public abstract String getName();
    
    
    public static Class<Device>[] devices = new Class[] {ConsoleDevice.class, TextOutputDevice.class, KeyboardDevice.class};
    
    
}
