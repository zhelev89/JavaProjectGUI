package base;

import frames.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasePanel extends JPanel {

    public MainFrame frame;
    public Date currentlyDate;
    public SimpleDateFormat date;
    public SimpleDateFormat time;

    public BasePanel(MainFrame frame) {
        this.frame = frame;
        setLayout(null);
        setBackground(new Color(128, 175, 175));
        //Create Date and Time on every panel
        currentlyDate = new Date();
        date = new SimpleDateFormat("dd.MM.yy");
        time = new SimpleDateFormat("HH:mm");
        JLabel dateLabel = new JLabel("Date: " + date.format(currentlyDate) + " / " + time.format(currentlyDate));
        add(dateLabel);
        dateLabel.setBounds(frame.getWidth() - 160, 0, 160, 30);
        dateLabel.setFont(new Font(Font.SERIF, Font.BOLD, 14));


    }
}
