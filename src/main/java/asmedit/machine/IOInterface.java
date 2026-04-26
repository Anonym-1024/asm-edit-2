/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.machine;

import java.util.ArrayList;

/**
 *
 * @author koukola
 */
public class IOInterface {
    protected ArrayList<Device> devs;
    
    protected Machine m;
    
    public IOInterface(Machine m) {
        this.devs = new ArrayList();
        this.m = m;
        
                
    }
    
    public void addDevice(Device d) {
        d.setIntr(m.intr);
        this.devs.add(d);
        
    }
    
    public int readState(int addr) {
        if (addr >= devs.size()) {
            return 0;
        }
        
        return devs.get(addr).readState();
    }
    
    public int read(int addr) {
        if (addr >= devs.size()) {
            return 0;
        }
        
        return devs.get(addr).read();
    }
    
    public void write(int addr, int content) {
        if (addr >= devs.size()) {
            return;
        }
        
        devs.get(addr).write(content);
    }
    
}
