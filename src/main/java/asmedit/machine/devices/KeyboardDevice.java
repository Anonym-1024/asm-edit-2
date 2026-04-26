/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.machine.devices;

import asmedit.machine.Device;
import asmedit.machine.InterruptRegister;

/**
 *
 * @author koukola
 */
public class KeyboardDevice extends Device{

    
    public KeyboardDevice() {
        super();
    }
    
    public void write(int data) {
        
    }

    protected int keyRegister;
    
    public void setKeyRegister(int keyRegister) {
        this.keyRegister = keyRegister;
        announceDataAvailable();
    }
    
    
    public int read() {
        clearDataAvailable();
        return keyRegister;
    }
    
}
