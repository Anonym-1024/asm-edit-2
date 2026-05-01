/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.gui;



import asmedit.machine.Memory;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.beans.PropertyChangeEvent;


/**
 *
 * @author koukola
 */
public class MemoryWindow extends JFrame {
    private final JTable table;
    private final MemoryTableModel model;
    private int highlightedAddress = -1;

    public MemoryWindow(Memory memory) {
        super("Memory Viewer");
        this.model = new MemoryTableModel(memory);
        this.table = new JTable(model);

        // Efficiency: Use a custom renderer for highlighting
        table.setDefaultRenderer(Object.class, new MemoryCellRenderer());
        
        table.getColumnModel().getColumn(0).setPreferredWidth(100); 
        table.getColumnModel().getColumn(0).setMinWidth(80);
        
        // Put table in a scroll pane for efficiency
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
        
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        memory.addListener("address", e -> addressChanged(e));
        
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    protected void highlightAddress(int address) {
        this.highlightedAddress = address;
        model.fireTableDataChanged(); // Trigger a repaint
        
        // Optional: Auto-scroll to the highlighted address
        int row = address / 16;
        table.scrollRectToVisible(table.getCellRect(row, 0, true));
    }
    
    public void addressChanged(PropertyChangeEvent e) {
        this.highlightAddress((Integer)e.getNewValue());
    }

    // Inner class to handle custom cell colors
    private class MemoryCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, 
                boolean isSelected, boolean hasFocus, int row, int col) {
            
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
            
            int currentAddr = (row * 16) + (col - 1);
            if (col > 0 && currentAddr == highlightedAddress) {
                c.setBackground(Color.GREEN);
                c.setForeground(Color.BLACK);
            } else {
                c.setBackground(isSelected ? table.getSelectionBackground() : Color.WHITE);
                c.setForeground(isSelected ? table.getSelectionForeground() : Color.BLACK);
            }
            return c;
        }
    }
}