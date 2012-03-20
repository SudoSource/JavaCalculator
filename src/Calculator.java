import javax.swing.*;

import gui.CalculatorUI;

public class Calculator {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception unused) {
        }
        CalculatorUI gui = new CalculatorUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }

    public Calculator() {
    }

}