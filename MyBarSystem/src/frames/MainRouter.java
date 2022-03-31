package frames;

import panels.LoginPanel;
import panels.OrdersPanel;
import panels.TablesPanel;

public class MainRouter {

    public MainFrame frame;

    public MainRouter(MainFrame currentFrame) {
        this.frame = currentFrame;
    }

    public void showLoginPanel() {
        LoginPanel loginPanel = new LoginPanel(frame);
        frame.setContentPane(loginPanel);
        frame.validate();
    }

    public void showTablesPanel() {
        TablesPanel tablesPanel = new TablesPanel(frame);
        frame.setContentPane(tablesPanel);
        frame.validate();
    }

    public void showOrdersPanel(int tableNumber) {
        OrdersPanel ordersPanel = new OrdersPanel(frame, tableNumber);
        frame.setContentPane(ordersPanel);
        frame.validate();
    }
}
