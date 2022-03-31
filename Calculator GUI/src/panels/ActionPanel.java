package panels;

import base.BasePanel;
import frames.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionPanel extends BasePanel implements ActionListener {

    private JTextField jTextField;
    private JPanel panel;
    private JButton delButton;
    private JButton clrButton;
    private JButton negButton;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;


    public ActionPanel(MainFrame frame) {
        super(frame);

        createTextField();
        createPanel();
        createDelButtons();

    }

    private void createTextField() {
        jTextField = new JTextField();
        jTextField.setBounds(50, 25, 300, 50);
        jTextField.setFont(frame.dataProvider.myFont());
        jTextField.setBackground(Color.lightGray);
        jTextField.setEditable(false);
        add(jTextField);
    }


    //create panel for numberButtons
    private void createPanel() {
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.lightGray);
        add(panel);

        for (int i = 0; i < frame.dataProvider.numberButtons.length; i++) {
            frame.dataProvider.numberButtons[i].addActionListener(this);
        }

        for (int i = 0; i < frame.dataProvider.functionButtons.length; i++) {
            frame.dataProvider.functionButtons[i].addActionListener(this);
        }

        panel.add(frame.dataProvider.numberButtons[1]);
        panel.add(frame.dataProvider.numberButtons[2]);
        panel.add(frame.dataProvider.numberButtons[3]);
        panel.add(frame.dataProvider.functionButtons[0]);
        panel.add(frame.dataProvider.numberButtons[4]);
        panel.add(frame.dataProvider.numberButtons[5]);
        panel.add(frame.dataProvider.numberButtons[6]);
        panel.add(frame.dataProvider.functionButtons[1]);
        panel.add(frame.dataProvider.numberButtons[7]);
        panel.add(frame.dataProvider.numberButtons[8]);
        panel.add(frame.dataProvider.numberButtons[9]);
        panel.add(frame.dataProvider.functionButtons[2]);
        panel.add(frame.dataProvider.functionButtons[4]);
        panel.add(frame.dataProvider.numberButtons[0]);
        panel.add(frame.dataProvider.functionButtons[5]);
        panel.add(frame.dataProvider.functionButtons[3]);
    }

    private void createDelButtons() {
        delButton = frame.dataProvider.functionButtons[6];
        clrButton = frame.dataProvider.functionButtons[7];
        negButton = frame.dataProvider.functionButtons[8];
        delButton.setBounds(50, 430, 94, 50);
        clrButton.setBounds(153, 430, 94, 50);
        negButton.setBounds(256, 430, 94, 50);
        add(delButton);
        add(clrButton);
        add(negButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < frame.dataProvider.numberButtons.length; i++) {
            if (e.getSource() == frame.dataProvider.numberButtons[i]) {
                jTextField.setText(jTextField.getText().concat(Integer.toString(i)));
            }
        }

        if (e.getSource() == frame.dataProvider.decButton) {
            jTextField.setText(jTextField.getText().concat("."));
        } else if (e.getSource() == frame.dataProvider.addButton) {
            num1 = Double.parseDouble(jTextField.getText());
            operator = '+';
            jTextField.setText("");
        } else if (e.getSource() == frame.dataProvider.subButton) {
            num1 = Double.parseDouble(jTextField.getText());
            operator = '-';
            jTextField.setText("");
        } else if (e.getSource() == frame.dataProvider.mulButton) {
            num1 = Double.parseDouble(jTextField.getText());
            operator = '*';
            jTextField.setText("");
        } else if (e.getSource() == frame.dataProvider.divButton) {
            num1 = Double.parseDouble(jTextField.getText());
            operator = '/';
            jTextField.setText("");
        } else if (e.getSource() == frame.dataProvider.equButton) {
            num2 = Double.parseDouble(jTextField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            jTextField.setText(Double.toString(result));
            num1 = result;
        } else if (e.getSource() == clrButton) {
            jTextField.setText("");
        } else if (e.getSource() == delButton) {
            String string = jTextField.getText();
            jTextField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                jTextField.setText(jTextField.getText() + string.charAt(i));
            }
        } else if (e.getSource() == negButton) {
            double temp = Double.parseDouble(jTextField.getText());
            temp *= -1;
            jTextField.setText(Double.toString(temp));
        }

    }
}
