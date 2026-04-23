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
public class Memory implements EventEmmitor  {
    
    protected byte[] content;
    protected int size;
    
    
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    

    public Memory() {
        this.size = 1 << 20;
        this.content = new byte[this.size];
        
    }
    
    
    
    

   
   
   
    
    
    

    public void setBytes(int addr, byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            if (addr + i >= this.size) {
                break;
            }
            this.content[addr + i] = bytes[i];
        }
        pcs.firePropertyChange("content", null, content);
        
        
    }
    
    public void setByte(int addr, byte v) {
        if (addr >= content.length) {
            return;
        }
        
        content[addr] = v;
        
        pcs.firePropertyChange("content", null, content);
    }
    
    public byte getByte(int addr) {
        if (addr < content.length) {
            return content[addr];
        }
        return 0;
    }
    
    public int getLength() {
        return content.length;
    }
    
    public void clear() {
        this.content = new byte[this.size];
        pcs.firePropertyChange("content", null, content);
    }
    
    public void addListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }
    
    
}
