package io;

import gui.CalculatorUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClearListener extends CalculatorUI implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        actionClear();
    }
}