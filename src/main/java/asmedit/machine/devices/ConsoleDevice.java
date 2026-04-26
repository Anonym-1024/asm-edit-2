/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.machine.devices;

import asmedit.machine.Device;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author koukola
 */
public class ConsoleDevice extends Device {

    
    
    public ConsoleDevice() {
        this.pcs = new PropertyChangeSupport(this);
    }
    
    
    protected PropertyChangeSupport pcs;
    
    public void write(int data) {
        pcs.firePropertyChange("char", null, data);
    }

    
    public void addListener(PropertyChangeListener l) {
        this.pcs.addPropertyChangeListener(l);
    }
    
    protected int keyRegister;
    
    public int read() {
        clearDataAvailable();
        return this.keyRegister;
    }
    
    
    public void setKeyRegister(int key) {
        this.keyRegister = key;
        announceDataAvailable();
    } 
    
}
