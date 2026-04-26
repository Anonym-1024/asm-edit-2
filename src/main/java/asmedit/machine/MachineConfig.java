/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.machine;

/**
 *
 * @author koukola
 */
public class MachineConfig {

    public int getBootAddress() {
        return bootAddress;
    }

    public void setBootAddress(int bootAddress) {
        this.bootAddress = bootAddress;
    }

    public int getInterruptAddress() {
        return interruptAddress;
    }

    public void setInterruptAddress(int interruptAddress) {
        this.interruptAddress = interruptAddress;
    }

    public byte[] getDefaultMemory() {
        return defaultMemory;
    }

    public void setDefaultMemory(byte[] defaultMemory) {
        this.defaultMemory = defaultMemory;
    }

    public int getPageTableAddress() {
        return pageTableAddress;
    }

    public void setPageTableAddress(int virtualMemoryAddress) {
        this.pageTableAddress = virtualMemoryAddress;
    }

    public byte[] getDefaultVirtualMemory() {
        return defaultVirtualMemory;
    }

    public void setDefaultVirtualMemory(byte[] defaultVirtualMemory) {
        this.defaultVirtualMemory = defaultVirtualMemory;
    }
    
    

    public MachineConfig() {
        this.bootAddress = 0x0000;
        this.interruptAddress = 0x0000;
        this.pageTableAddress = 0x0000;
        this.defaultMemory = new byte[0];
        this.defaultVirtualMemory = new byte[0];
    }
    
    
    
    protected int bootAddress;
    protected int interruptAddress;
    protected byte[] defaultMemory;
    protected int pageTableAddress;
    protected byte[] defaultVirtualMemory;
    
    
}
