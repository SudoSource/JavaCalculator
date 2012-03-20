package io;

import gui.CalculatorUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberListener extends CalculatorUI implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        String digit = e.getActionCommand(); // Get text from button
        if (_startNumber) {
            //... This is the first digit, clear field and set
            _displayField.setText(digit);
            _startNumber = false;
        } else {
            //... Add this digit to the end of the display field
            _displayField.setText(_displayField.getText() + digit);
        }
    }
}