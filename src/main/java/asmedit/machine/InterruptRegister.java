/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.machine;

import asmedit.gui.EventEmmitor;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author koukola
 */

/*TODO:
|=====|=====|======|=====|=====|=====|=====|=====|
|     |     |      | IRQ | SVC | PF  | INI | INT |
|=====|=====|======|=====|=====|=====|=====|=====|
|  7  |  6  |  5   |  4  |  3  |  2  |  1  |  0  |
|=====|=====|======|=====|=====|=====|=====|=====|
*/

public class InterruptRegister implements EventEmmitor  {
    protected int content;
    
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public InterruptRegister() {
        this.content = 0;
    }
    
    public void setINT() {
        this.content |= 0b00001;
        
        pcs.firePropertyChange("content", null, content);
        
    }
    
    public void setINI() {
        this.content |= 0b00010;
        setINT();
        pcs.firePropertyChange("content", null, content);
    }
    
    public void setPF() {
        this.content |= 0b00100;
        setINT();
        pcs.firePropertyChange("content", null, content);
    }
    
    public void setIRQ() {
        this.content |= 0b10000;
        pcs.firePropertyChange("content", null, content);
    }
    
    public void setSVC() {
        this.content |= 0b01000;
        setINT();
        pcs.firePropertyChange("content", null, content);
    }
    
    public int getContent() {
        return (int)this.content;
        
    }
    
    public boolean isInterrupt() {
        return (this.content & 1) == 1;
    }
    
    public boolean isIRQ() {
        return (this.content & 0b10000) == 0b10000;
    }
    
    public void clear() {
        this.content = 0;
        pcs.firePropertyChange("content", null, content);
    }
    
    
    
    public void addListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }
    
    
    
}
