package frames;

import panels.AdminPanel;
import panels.LoginPanel;
import panels.OrdersPanel;
import panels.TablesPanel;

import java.io.IOException;

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

    public void showOrdersPanel(int tableNumber) throws IOException, InterruptedException {
        OrdersPanel ordersPanel = new OrdersPanel(frame, tableNumber);
        frame.setContentPane(ordersPanel);
        frame.validate();
    }

    public void showAdminPanel() {
        AdminPanel adminPanel = new AdminPanel(frame);
        frame.setContentPane(adminPanel);
        frame.validate();
    }
}
