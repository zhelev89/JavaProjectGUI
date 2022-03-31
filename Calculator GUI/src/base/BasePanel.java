package base;

import frames.MainFrame;

import javax.swing.*;
import java.awt.*;

public class BasePanel extends JPanel {

    public MainFrame frame;

    public BasePanel(MainFrame frame) {
        this.frame = frame;
        setBackground(new Color(128, 175, 175));
        setLayout(null);
    }
}
