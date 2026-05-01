/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.gui;


import asmedit.machine.Memory;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author koukola
 */
public class MemoryTableModel extends AbstractTableModel {
    private final Memory memory;
    private final int bytesPerRow = 16;

    public MemoryTableModel(Memory memory) {
        this.memory = memory;
        // Listen for changes in the memory to refresh the UI
        memory.addListener("content", evt -> fireTableDataChanged());
    }

    @Override
    public int getRowCount() {
        return memory.getLength() / bytesPerRow;
    }

    @Override
    public int getColumnCount() {
        return bytesPerRow + 1; // +1 for the Address column
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            // Display address in Hex: 0x0000, 0x0010, etc.
            return String.format("0x%05X", rowIndex * bytesPerRow);
        }
        int address = (rowIndex * bytesPerRow) + (columnIndex - 1);
        return String.format("%02X", memory.getByte(address));
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) return "Address";
        return String.format("%X", column - 1);
    }
}