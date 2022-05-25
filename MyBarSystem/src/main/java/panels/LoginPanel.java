package panels;

import base.BasePanel;
import frames.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPanel extends BasePanel {

    public JTextField pinCodeField;
    public JLabel loginLabel;
    public JButton loginButton;

    public LoginPanel(MainFrame frame) {
        super(frame);

        createComponent();
    }

    public void createComponent() {
        loginLabel = new JLabel("Welcome to Advance Bar");
        add(loginLabel);
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setBounds(frame.getWidth() / 2 - 130, 20, 260, 30);
        loginLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));

        pinCodeField = new JPasswordField("****");
        add(pinCodeField);
        pinCodeField.setBounds(frame.getWidth() / 2 - 50, 55, 100, 40);
        pinCodeField.setHorizontalAlignment(SwingConstants.CENTER);
        pinCodeField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                pinCodeField.setText("");
            }
        });

        loginButton = new JButton("Login");
        add(loginButton);
        loginButton.setBounds(frame.getWidth() / 2 - 50, 100, 100, 44);
        loginButton.setBackground(new Color(255, 180, 100));
        loginButton.setHorizontalAlignment(SwingConstants.CENTER);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frame.dataProvider.isPinCorrect(pinCodeField.getText())) {
                    frame.router.showTablesPanel();
                } else {
                    frame.dataProvider.showErrorMessage("Wrong pin code");
                }
            }
        });
    }
}
