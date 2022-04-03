package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterScreen extends JFrame implements ActionListener {
    public JPanel jPanel;
    public JLabel firstnameLabel;
    public JLabel lastnameLabel;
    public JLabel phoneLabel;
    public JLabel emailLabel;
    public JLabel countryLabel;
    public JLabel cityLabel;
    public JLabel streetLabel;
    public JLabel postalCodeLabel;
    public JLabel passwordLabel;
    public JLabel confirmPasswordLabel;
    public JLabel checkBoxLabel;
    public JTextField firstnameField;
    public JTextField lastnameField;
    public JTextField phoneField;
    public JTextField emailField;
    public JTextField countryField;
    public JTextField cityField;
    public JTextField streetField;
    public JTextField postalCodeField;
    public JTextField passwordField;
    public JTextField confirmPasswordField;
    public JRadioButton maleRadioButton;
    public JRadioButton femaleRadioButton;
    public JButton registerButton;
    public JCheckBox checkBox;
    public String gender;
    public MyListener listener = new MyListener();

    public RegisterScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setTitle("New registration");
        setResizable(false);


        configureActivity();

    }

    private void configureActivity() {

        // JPanel
        jPanel = new JPanel();
        setContentPane(jPanel);
        jPanel.setLayout(null);

        // JLabels
        firstnameLabel = new JLabel("First name");
        add(firstnameLabel);
        firstnameLabel.setBounds(20, 20, 120, 20);

        //
        lastnameLabel = new JLabel("Last name");
        add(lastnameLabel);
        lastnameLabel.setBounds(20, 60, 120, 20);

        //
        phoneLabel = new JLabel("Phone number");
        add(phoneLabel);
        phoneLabel.setBounds(20, 100, 120, 20);

        //
        emailLabel = new JLabel("Email address");
        add(emailLabel);
        emailLabel.setBounds(20, 140, 120, 20);

        //
        passwordLabel = new JLabel("Password");
        add(passwordLabel);
        passwordLabel.setBounds(20, 220, 120, 20);

        //
        confirmPasswordLabel = new JLabel("Confirm pass");
        add(confirmPasswordLabel);
        confirmPasswordLabel.setBounds(20, 260, 120, 20);

        //
        countryLabel = new JLabel("Country");
        add(countryLabel);
        countryLabel.setBounds(300, 20, 120, 20);

        //
        cityLabel = new JLabel("City");
        add(cityLabel);
        cityLabel.setBounds(300, 60, 120, 20);

        //
        streetLabel = new JLabel("Street");
        add(streetLabel);
        streetLabel.setBounds(300, 100, 120, 20);

        //
        postalCodeLabel = new JLabel("Postal code");
        add(postalCodeLabel);
        postalCodeLabel.setBounds(300, 140, 120, 20);

        //
        checkBoxLabel = new JLabel("Terms");
        add(checkBoxLabel);
        checkBoxLabel.setBounds(45, 300, 120, 20);
        listener.myLabelListener(checkBoxLabel);

        // JTextField
        firstnameField = new JTextField("Enter your first name");
        add(firstnameField);
        firstnameField.setBounds(120, 20, 120, 20);
        listener.myMouseListener(firstnameField);

        //
        lastnameField = new JTextField("Enter your last name");
        add(lastnameField);
        lastnameField.setBounds(120, 60, 120, 20);
        listener.myMouseListener(lastnameField);

        //
        phoneField = new JTextField("Enter your phone");
        add(phoneField);
        phoneField.setBounds(120, 100, 120, 20);
        listener.myMouseListener(phoneField);

        //
        emailField = new JTextField("Enter your email");
        add(emailField);
        emailField.setBounds(120, 140, 120, 20);
        listener.myMouseListener(emailField);

        //
        passwordField = new JPasswordField("**********");
        add(passwordField);
        passwordField.setBounds(120, 220, 120, 20);
        listener.myMouseListener(passwordField);

        //
        confirmPasswordField = new JPasswordField("**********");
        add(confirmPasswordField);
        confirmPasswordField.setBounds(120, 260, 120, 20);
        listener.myMouseListener(confirmPasswordField);

        //
        countryField = new JTextField("Enter your Country");
        add(countryField);
        countryField.setBounds(400, 20, 120, 20);
        listener.myMouseListener(countryField);

        //
        cityField = new JTextField("Enter your city");
        add(cityField);
        cityField.setBounds(400, 60, 120, 20);
        listener.myMouseListener(cityField);

        //
        streetField = new JTextField("Enter your street");
        add(streetField);
        streetField.setBounds(400, 100, 120, 20);
        listener.myMouseListener(streetField);

        //
        postalCodeField = new JTextField("Enter your post code");
        add(postalCodeField);
        postalCodeField.setBounds(400, 140, 120, 20);
        listener.myMouseListener(postalCodeField);

        // JRadioButton
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");

        ButtonGroup group = new ButtonGroup();
        group.add(maleRadioButton);
        group.add(femaleRadioButton);

        add(maleRadioButton);
        maleRadioButton.setBounds(20, 180, 80, 20);
        add(femaleRadioButton);
        femaleRadioButton.setBounds(100, 180, 80, 20);

        // JButton
        registerButton = new JButton("Registration");
        add(registerButton);
        registerButton.setBounds(20, 340, 200, 40);
        registerButton.addActionListener(this);

        // JCheckBox
        checkBox = new JCheckBox();
        add(checkBox);
        checkBox.setBounds(20, 300, 20, 20);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isContain359 = phoneField.getText().startsWith("+359");
        boolean isConfirm = passwordField.getText().equals(confirmPasswordField.getText());
        if (maleRadioButton.isSelected()) {
            this.gender = "Male";
        }
        if (femaleRadioButton.isSelected()) {
            this.gender = "female";
        }

        if (e.getSource() == registerButton) {
            if (firstnameField.getText().length() < 2) {
                JOptionPane.showMessageDialog(null, "Your first name is incorrect",
                        "Incorrect name", JOptionPane.ERROR_MESSAGE);
            } else if (lastnameField.getText().length() < 2) {
                JOptionPane.showMessageDialog(null, "Your last name is incorrect",
                        "Incorrect name", JOptionPane.ERROR_MESSAGE);
            } else if (!isContain359) {
                JOptionPane.showMessageDialog(null, "Your phone should start with +359",
                        "Wrong phone number", JOptionPane.INFORMATION_MESSAGE);
            } else if (phoneField.getText().length() < 13) {
                JOptionPane.showMessageDialog(null, "Your phone number is incorrect",
                        "Incorrect phone", JOptionPane.ERROR_MESSAGE);
            } else if (emailField.getText().length() < 7 || !isEmail()) {
                JOptionPane.showMessageDialog(null, "Your email address is incorrect",
                        "Incorrect email", JOptionPane.ERROR_MESSAGE);
            } else if (this.gender == null) {
                JOptionPane.showMessageDialog(null, "Your gender status is incorrect",
                        "Your gender status is incorrect", JOptionPane.ERROR_MESSAGE);
            } else if (this.countryField.getText().length() < 2) {
                JOptionPane.showMessageDialog(null, "Your Country is incorrect",
                        "Your Country is incorrect", JOptionPane.ERROR_MESSAGE);
            } else if (this.cityField.getText().length() < 2) {
                JOptionPane.showMessageDialog(null, "Your city is incorrect",
                        "Your city is incorrect", JOptionPane.ERROR_MESSAGE);
            } else if (this.streetField.getText().length() < 2) {
                JOptionPane.showMessageDialog(null, "Your Street is incorrect",
                        "Your Street is incorrect", JOptionPane.ERROR_MESSAGE);
            } else if (this.postalCodeField.getText().length() < 2) {
                JOptionPane.showMessageDialog(null, "Your Postal code is incorrect",
                        "Your Postal code is incorrect", JOptionPane.ERROR_MESSAGE);
            } else if (!checkBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please agree to the terms",
                        "Please agree to the terms", JOptionPane.ERROR_MESSAGE);
            } else if (!isConfirm || passwordField.getText().length() < 8) {
                JOptionPane.showMessageDialog(null, "Wrong password confirmation",
                        "Wrong password confirmation", JOptionPane.ERROR_MESSAGE);
            } else if (!isPassContain()) {
                JOptionPane.showMessageDialog(null, "Your password must contain one number or one symbol",
                        "Wrong password", JOptionPane.ERROR_MESSAGE);
            } else {
                Location location = new Location(countryField.getText(), cityField.getText(), streetField.getText(),
                        postalCodeField.getText());

                User user = new User(firstnameField.getText(), lastnameField.getText(), phoneField.getText(), emailField.getText(),
                        gender, location);
                user.printFullInfo();
            }

            //System.out.println(isEmail());
        }
    }

    public boolean isPassContain() {
        boolean isPassContain = passwordField.getText().contains("1") || passwordField.getText().contains("2") ||
                passwordField.getText().contains("3") || passwordField.getText().contains("4") ||
                passwordField.getText().contains("5") || passwordField.getText().contains("6") ||
                passwordField.getText().contains("7") || passwordField.getText().contains("8") ||
                passwordField.getText().contains("9") || passwordField.getText().contains("0") ||
                passwordField.getText().contains(";") || passwordField.getText().contains("!") ||
                passwordField.getText().contains("#") || passwordField.getText().contains("$") ||
                passwordField.getText().contains("%") || passwordField.getText().contains("&") ||
                passwordField.getText().contains("*") || passwordField.getText().contains("-") ||
                passwordField.getText().contains("_");
        return isPassContain;
    }

    public boolean isEmail() {
        boolean isEmail = false;
        int index = emailField.getText().lastIndexOf(".") - emailField.getText().lastIndexOf("@");
        int lastIndex = emailField.getText().length() - emailField.getText().lastIndexOf(".");

        if ((emailField.getText().indexOf("@") >= 2) && (index > 2) && (lastIndex > 2)) {
            isEmail = true;
        }
        return isEmail;
    }
}
