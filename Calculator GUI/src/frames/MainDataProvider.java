package frames;

import javax.swing.*;
import java.awt.*;

public class MainDataProvider {

    private MainFrame frame;
    public JButton[] functionButtons;
    public JButton[] numberButtons;
    public JButton addButton, subButton, mulButton, divButton;
    public JButton decButton, equButton, delButton, clrButton, negButton;

    public MainDataProvider(MainFrame frame) {
        this.frame = frame;
    }

    public Font myFont() {
        Font myFont = new Font("Ink free", Font.BOLD, 30);
        return myFont;
    }

    public void fetchNumberButtons() {
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].setFont(myFont());
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(0, 230, 230));

        }
    }

    public void fetchFunctionButtons() {
        functionButtons = new JButton[9];

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        addButton.setBackground(new Color(255, 180, 100));
        subButton.setBackground(new Color(255, 180, 100));
        mulButton.setBackground(new Color(255, 180, 100));
        divButton.setBackground(new Color(255, 180, 100));
        decButton.setBackground(new Color(150, 200 , 220));
        equButton.setBackground(new Color(150, 220, 0));
        delButton.setBackground(new Color(200, 100 , 100));
        clrButton.setBackground(new Color(200, 100 , 100));
        negButton.setBackground(new Color(200, 100, 100));

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].setFont(myFont());
            functionButtons[i].setFocusable(false);
        }
    }
}
