package panels;

import base.BasePanel;
import frames.MainFrame;
import models.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablesPanel extends BasePanel {

    public JButton backButton;
    private boolean isBusy;
    private JPanel panel;

    public TablesPanel(MainFrame frame) {
        super(frame);

        createHeader();
        createTableButtonPanel();
    }

    public void createTableButtonPanel() {
        panel = new JPanel();
        panel.setBounds(5, 98, 500, 345);
        panel.setLayout(new GridLayout(5, 4, 5, 5));
        panel.setBackground(new Color(128, 175, 175));
        add(panel);

        createTablesButton();
    }
    public void createTablesButton() {
        JLabel tableLabel = new JLabel("Маси:");
        add(tableLabel);
        tableLabel.setBounds(5, 53, 120, 40);
        tableLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tableLabel.setFont(new Font(Font.SERIF, Font.BOLD, 18));

        int x = 5;
        int y = 98;
        for (int i = 0; i < frame.dataProvider.tables.size(); i++) {


            Integer tablesNumber = frame.dataProvider.tables.get(i);
            JButton tableButton = new JButton(Integer.toString(tablesNumber));
            panel.add(tableButton);

            tableButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.router.showOrdersPanel(tablesNumber);
                }
            });

            tableButton.setBounds(x, y, 120, 80);
            x += 125;
            if (tablesNumber % 5 == 0) {
                x = 5;
                y += 85;
            }
            if (!isBusy(frame.dataProvider.tables.get(i))) {
                tableButton.setBackground(new Color(150, 220, 0));
            } else {
                isBusy = true;
                tableButton.setBackground(new Color(200, 100 , 100));

            }
        }
    }

    public void createHeader() {
        backButton = new JButton();
        frame.dataProvider.backButtonConfigure(backButton);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.router.showLoginPanel();
            }
        });

        JLabel loggedNameLabel = new JLabel();
        frame.dataProvider.loggedNameLabel(loggedNameLabel);
        add(loggedNameLabel);
    }

    public boolean isBusy(int tableNumber) {
        isBusy = false;
        for (Order order : frame.dataProvider.orders) {
            if (order.getTableNumber() == tableNumber) {
                isBusy = true;
                break;
            }
        }
        return isBusy;
    }
}
