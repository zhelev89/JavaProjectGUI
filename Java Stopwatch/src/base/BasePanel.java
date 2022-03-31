package base;

import frames.MainFrame;

import javax.swing.*;
import java.awt.*;

public class BasePanel extends JPanel {

    public MainFrame frame;

    public BasePanel(MainFrame frame) {
        this.frame = frame;
        setLayout(null);
        setBackground(new Color(179,185,90));
    }
}
