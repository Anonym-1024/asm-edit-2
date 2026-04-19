/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmedit.gui;

/**
 *
 * @author koukola
 */


import javax.swing.*;
import java.awt.*;

public class RegisterView extends JPanel {
    
    private int registerValue; // Stores the underlying numeric value
    private String registerName;
    
    private final JTextField displayField;
    private final JComboBox<String> radixSelector;

    public RegisterView() {
        this.registerName = "Register";
        this.registerValue = 0;
       
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(BorderFactory.createTitledBorder("Register Content"));

        
        displayField = new JTextField(15);
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14)); // Monospaced is better for reading hex/binary
        add(displayField);

        
        
        
        
        String[] options = {"BIN", "DEC", "HEX"};
        radixSelector = new JComboBox<>(options);
        
       
        radixSelector.setSelectedItem("DEC");
        
        add(radixSelector);
        

        radixSelector.addActionListener(e -> updateDisplay());

        // 5. Initialize the display
        updateDisplay();
    }

    
    public void setValue(int value) {
        this.registerValue = value;
        updateDisplay();
    }

   
    

    
    private void updateDisplay() {
        String selectedRadix = (String) radixSelector.getSelectedItem();
        
        if ("BIN".equals(selectedRadix)) {
            displayField.setText(Integer.toBinaryString(registerValue));
        } else if ("HEX".equals(selectedRadix)) {
            displayField.setText(Integer.toHexString(registerValue).toUpperCase());
        } else {
            displayField.setText(Integer.toString(registerValue));
        }
    }

    
}