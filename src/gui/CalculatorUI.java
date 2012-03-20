package gui;

import functions.Logic;
import io.ClearListener;
import io.NumberListener;
import io.OperatorListener;

import javax.swing.*;
import java.awt.*;


public class CalculatorUI extends JFrame {

    public static final Font BIGGER_FONT = new Font("monspaced", Font.PLAIN, 20);
    public JTextField _displayField;
    public boolean _startNumber = true;
    public String _previousOp  = "=";
    public Logic _logic = new Logic();
    private ClearListener cl = new ClearListener();
    private NumberListener nl = new NumberListener();
    private OperatorListener ol = new OperatorListener();
    
    public CalculatorUI() {
        _displayField = new JTextField("0", 12);
        _displayField.setHorizontalAlignment(JTextField.RIGHT);
        _displayField.setFont(BIGGER_FONT);

        JButton clearButton = new JButton("Clear");
        clearButton.setFont(BIGGER_FONT);
        clearButton.addActionListener(cl);

        String buttonOrder = "789456123 0 ";
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 3, 2, 2));
        for (int i = 0; i < buttonOrder.length(); i++) {
            String keyTop = buttonOrder.substring(i, i+1);
            JButton b = new JButton(keyTop);
            if (keyTop.equals(" ")) {
                b.setEnabled(false);
            } else {
                b.addActionListener(nl);
                b.setFont(BIGGER_FONT);
            }
            buttonPanel.add(b);
        }

        JPanel opPanel = new JPanel();
        opPanel.setLayout(new GridLayout(5, 1, 2, 2));
        String[] opOrder = {"+", "-", "*", "/", "="};
        for (int i = 0; i < opOrder.length; i++) {
            JButton b = new JButton(opOrder[i]);
            b.addActionListener(ol);
            b.setFont(BIGGER_FONT);
            opPanel.add(b);
        }

        JPanel clearPanel = new JPanel();
        clearPanel.setLayout(new FlowLayout());
        clearPanel.add(clearButton);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout(5, 5));
        content.add(_displayField, BorderLayout.NORTH );
        content.add(buttonPanel   , BorderLayout.CENTER);
        content.add(opPanel       , BorderLayout.EAST  );
        content.add(clearPanel    , BorderLayout.SOUTH );

        content.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        this.setContentPane(content);
        this.pack();
        this.setTitle("Simple Calc");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void actionClear() {
        _startNumber = true;         // Expecting number, not op.
        _displayField.setText("0");
        _previousOp  = "=";
        _logic.setTotal("0");
    }
}
