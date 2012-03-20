package io;

import gui.CalculatorUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorListener extends CalculatorUI implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (_startNumber) {
            actionClear();
            _displayField.setText("ERROR - No operator");
        } else {
            _startNumber = true;
            try {
                String displayText = _displayField.getText();
                if (_previousOp.equals("=")) {
                    _logic.setTotal(displayText);
                } else if (_previousOp.equals("+")) {
                    _logic.add(displayText);
                } else if (_previousOp.equals("-")) {
                    _logic.subtract(displayText);
                } else if (_previousOp.equals("*")) {
                    _logic.multiply(displayText);
                } else if (_previousOp.equals("/")) {
                    _logic.divide(displayText);
                }
                _displayField.setText("" + _logic.getTotalString());
            } catch (NumberFormatException ex) {
                actionClear();
                _displayField.setText("Error");
            }
            _previousOp = e.getActionCommand();
        }
    }
}