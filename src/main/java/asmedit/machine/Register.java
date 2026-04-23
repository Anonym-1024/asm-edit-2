/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.machine;

import asmedit.gui.EventEmmitor;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.EventListener;

/**
 *
 * @author koukola
 */
public class Register implements EventEmmitor {

    protected int content;
    
    
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    
    public Register() {
        this.content = 0;
    }

    public int getContent() {
        return content & 0xFF;
    }

    public void setContent(int content) {
        this.content = content & 0xFF;
        pcs.firePropertyChange("content", null, content);
    }
    
    public void addListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }
}
