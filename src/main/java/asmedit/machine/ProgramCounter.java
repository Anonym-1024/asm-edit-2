/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.machine;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author koukola
 */
public class ProgramCounter {
    protected int content;

    PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    public ProgramCounter() {
        this.content = 0;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
        pcs.firePropertyChange("content", null, content);
    }
    
    public void increment() {
        this.content += 1;
        pcs.firePropertyChange("content", null, content);
    }
    
    public void setByte0(int byte0) {
        this.content &= 0xFF00;
        this.content |= (byte0 & 0x00FF);
        pcs.firePropertyChange("content", null, content);
    }
    
    public void setByte1(int byte1) {
        this.content &= 0x00FF;
        this.content |= (byte1 & 0xFF00);
        pcs.firePropertyChange("content", null, content);
    }
    
    public int getByte0() {
        return this.content & 0x00FF;
    }
    public int getByte1() {
        return (this.content & 0xFF00) >> 8;
    }
    
    public void reset() {
        this.content = 0;
        pcs.firePropertyChange("content", null, content);
    }
    
    public void addListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }
    
}
