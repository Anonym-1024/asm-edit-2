/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.machine;

import asmedit.gui.RegisterModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author koukola
 */
public class IOAddressRegister implements RegisterModel {
    protected int content;
    
    public IOAddressRegister() {
        this.pcs = new PropertyChangeSupport(this);
        this.content = 0;
    }
    
    
    protected PropertyChangeSupport pcs;
    
    public void addListener(PropertyChangeListener l) {
        this.pcs.addPropertyChangeListener(l);
    }
    
    public int getContent() {
        return this.content;
    }
    
    public void setContent(int content) {
        this.content = content;
        pcs.firePropertyChange("content", null, content);
    }
    
}
