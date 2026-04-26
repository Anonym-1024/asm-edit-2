/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.gui;

import asmedit.machine.Register;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author koukola
 */
public class RegisterView extends JPanel {
    private JTextField textField;
    private JComboBox<String> radixPicker;
    private JLabel label;
    
    protected String registerName;
    protected int content;
    
    
    // TODO: replace event emmitter with register inteface 
    public RegisterView(String registerName, EventEmitter r) {
        this.registerName = registerName;
        this.content = 0;
        
        r.addListener(e -> updateValue(e));
        
        initComponents();
    }
    
    public RegisterView() {
        this.registerName = "test";
        
        
        initComponents();
    }
    
    private void initComponents() {
        
        
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
       
        label = new JLabel(registerName + ": ");
        label.setPreferredSize(new Dimension(50, 20));
        label.setHorizontalAlignment(JLabel.RIGHT);
        this.add(label);
        
        textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setPreferredSize(new Dimension(100, 20));
        add(textField);
        
        
        radixPicker = new JComboBox<>(new String[]{"BIN", "DEC", "HEX"});
        radixPicker.setSelectedItem("DEC");
        radixPicker.addActionListener((e) -> updateView());
        add(radixPicker);
        
        updateView();
        
    }
    
    private void updateView() {
        switch ((String)radixPicker.getSelectedItem()) {
            case "BIN":
                this.textField.setText(Integer.toBinaryString(this.content));
                break;
            case "HEX":
                this.textField.setText(Integer.toHexString(this.content));
                break;
            default:
                this.textField.setText(Integer.toString(this.content));
                break;
        }
    }
    
    
    
    private void updateValue(PropertyChangeEvent e) {
        this.content = ((Integer)e.getNewValue()).intValue();
        updateView();
    }
}
