/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.machine;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author koukola
 */

public class Machine {
    
    protected MachineConfig config;
    protected volatile State state;
    
    protected ControlUnit controlUnit;
    
    protected Register[] registers;
    protected ALU alu;
    protected ProgramCounter pc;
    protected InterruptProgramCounter intpc;
    
    protected ProcessStateRegister psr;
    protected InterruptRegister intr;
    
    protected PageTableBaseRegister ptbr;
    protected Memory memory;
    
    protected IOAddressRegister ioaddr;
    protected IOInterface io;
    
    
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    public enum State {
        IDLE,
        STOPPED,
        RUNNING,
    }
    
    

    
    
    
    public Machine() {
        
       this.config = new MachineConfig();
       this.state = State.STOPPED;
       this.controlUnit = new ControlUnit(this);
       this.registers = new Register[16];
       for (int i = 0; i < 16; i++) {
           registers[i] = new Register();
       }
       this.alu = new ALU();
       this.pc = new ProgramCounter();
       this.intpc = new InterruptProgramCounter();
       this.psr = new ProcessStateRegister();
       this.intr = new InterruptRegister();
       this.ptbr = new PageTableBaseRegister();
       this.memory = new Memory();
       
       this.ioaddr = new IOAddressRegister();
       this.io = new IOInterface(this);
        
    }

    public InterruptProgramCounter getIntpc() {
        return intpc;
    }

    public PageTableBaseRegister getPtbr() {
        return ptbr;
    }

    public PropertyChangeSupport getPcs() {
        return pcs;
    }
    
    public Register[] getRegisters() {
        return registers;
    }

    public ProgramCounter getPc() {
        return pc;
    }

    public InterruptRegister getIntr() {
        return intr;
    }

    public ProcessStateRegister getPsr() {
        return psr;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setConfig(MachineConfig config) {
        this.config = config;
    }

    public MachineConfig getConfig() {
        return config;
    }

    public State getState() {
        return state;
    }

    public IOAddressRegister getIoaddr() {
        return ioaddr;
    }

    public IOInterface getIo() {
        return io;
    }

    
    
    
    
    
    
    
    
    public void startAndBoot() {
        if (state != State.STOPPED) {
            return;
        }
        
        
        for (Register r: registers) {
            r.setContent(0);
        }
        
        
        pc.setContent(config.bootAddress);
        intpc.setDefaultAddress(config.interruptAddress);
        intpc.reset();
        
        psr.setContent(0);
        
        intr.clear();
        
        ptbr.setContent(0);
        
        memory.setBytes(0, readFileContent(config.getDefaultMemoryFile()));
        
        memory.setBytes(config.pageTableAddress, readFileContent(config.getDefaultVirtualMemoryFile()));
        
        io.removeAllDevices();
        
        pcs.firePropertyChange("state", null, State.IDLE);
        state = State.IDLE;
        
        
       
    }
    
    
    private byte[] readFileContent(String path) {
        
        if (path.equals("")) {
            return new byte[0];
        }
        
        File f = new File(path);
        
        try (FileInputStream str = new FileInputStream(f)) {
            return str.readAllBytes();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error occurred while reading '" + path + "'.");
            return new byte[0];
        }
        
    }
    
    
    
    public void nextCycle() {
        if (state == State.IDLE) {
            controlUnit.cycle();
        }
    }
    
    public void run() {
        state = State.RUNNING;
        pcs.firePropertyChange("state", null, State.RUNNING);
        while (state == State.RUNNING) {
            controlUnit.cycle();
        }
    }
    
    public void stop() {
        pcs.firePropertyChange("state", null, State.STOPPED);
        state = State.STOPPED;
    }
   
    public void pause() {
        pcs.firePropertyChange("state", null, State.IDLE);
        state = State.IDLE;
    }
    
    
    
    
    public void addListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }
    
    
    
    
    
}
