package panels;

import base.BasePanel;
import frames.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StopwatchPanel extends BasePanel implements ActionListener {

    private JButton startButton;
    private JButton resetButton;
    private JLabel timeLabel;
    private int elapsedTime;
    private int seconds;
    private int minutes;
    private int hours;
    private String secondsString;
    private String minutesString;
    private String hoursString;
    private Timer timer;
    private boolean isStarted;

    public StopwatchPanel(MainFrame frame) {
        super(frame);
        createComponents();
        createButtons();
    }

    public void createComponents() {
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        secondsString = String.format("%02d", seconds);
        minutesString = String.format("%02d", minutes);
        hoursString = String.format("%02d", hours);

        timeLabel = new JLabel();
        timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
        timeLabel.setBounds(100, 50, 205, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setBackground(new Color(211, 138, 90));
        add(timeLabel);

        timer = new Timer(1000, this);
    }

    public void createButtons() {
        isStarted = false;

        startButton = new JButton("START");
        startButton.setBounds(100, 155, 100, 50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.setBackground(new Color(0, 140, 140));
        startButton.addActionListener(this);
        add(startButton);


        resetButton = new JButton("RESET");
        resetButton.setBounds(205, 155, 100, 50);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.setBackground(new Color(0, 140, 140));
        resetButton.addActionListener(this);
        add(resetButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            elapsedTime += 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            secondsString = String.format("%02d", seconds);
            minutesString = String.format("%02d", minutes);
            hoursString = String.format("%02d", hours);
            timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
        }
        if (e.getSource() == startButton) {
            if (!isStarted) {
                isStarted = true;
                startButton.setText("STOP");
                timer.start();
            } else {
                isStarted = false;
                startButton.setText("START");
                timer.stop();
            }
        }
        if (e.getSource() == resetButton) {
            timerReset();
        }
    }

    public void timerReset() {
        isStarted = false;
        startButton.setText("START");
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        secondsString = String.format("%02d", seconds);
        minutesString = String.format("%02d", minutes);
        hoursString = String.format("%02d", hours);
        timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
    }
}
