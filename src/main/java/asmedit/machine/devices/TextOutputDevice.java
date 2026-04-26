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
public class TextOutputDevice extends Device {

    
    protected PropertyChangeSupport pcs;

    public TextOutputDevice() {
        this.pcs = new PropertyChangeSupport(this);
    }
    
    public void addListener(PropertyChangeListener l) {
        this.pcs.addPropertyChangeListener(l);
    }
    
    
    public void write(int data) {
        pcs.firePropertyChange("char", null, data);
    }

    
    public int read() {
        return 0;
    }
    
}
