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

    public String getDefaultMemoryFile() {
        return defaultMemoryFile;
    }

    public void setDefaultMemoryFile(String defaultMemoryFile) {
        this.defaultMemoryFile = defaultMemoryFile;
    }

    public String getDefaultVirtualMemoryFile() {
        return defaultVirtualMemoryFile;
    }

    public void setDefaultVirtualMemoryFile(String defaultVirtualMemoryFile) {
        this.defaultVirtualMemoryFile = defaultVirtualMemoryFile;
    }

    

    public int getPageTableAddress() {
        return pageTableAddress;
    }

    public void setPageTableAddress(int virtualMemoryAddress) {
        this.pageTableAddress = virtualMemoryAddress;
    }

    
    
    

    public MachineConfig() {
        this.bootAddress = 0x0000;
        this.interruptAddress = 0x0000;
        this.pageTableAddress = 0x0000;
        this.defaultMemoryFile = "";
        this.defaultVirtualMemoryFile = "";
    }
    
    
    
    protected int bootAddress;
    protected int interruptAddress;
    protected String defaultMemoryFile;
    protected int pageTableAddress;
    protected String defaultVirtualMemoryFile;
    
    
}
