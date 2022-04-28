package frames;

import database.Database;
import models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MainDataProvider {

    public MainFrame currentFrame;

    public ArrayList<User> users;
    public ArrayList<Integer> tables;
    public ArrayList<Order> orders;
    public ArrayList<Category> categories;
    public UserType loggedType;
    public String loggedName;

    public MainDataProvider(MainFrame currentFrame) {
        this.currentFrame = currentFrame;

    }

    public void fetchUsers() {
        users = Database.getUsers();

    }

    public void fetchTables() {
        tables = Database.getTables();
    }

    public void fetchCategories() {
        this.categories = Database.getCategories();
    }

    public boolean isPinCorrect(String pinCode) {
        for (User user : users) {
            if (pinCode.equals(user.getPin())) {
                this.loggedName = user.getName();
                this.loggedType = user.getType();
                return true;
            }
        }
        return false;
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public int showQuestionMessage(String message) {
        return JOptionPane.showConfirmDialog(null, message,
                "Attention!", JOptionPane.YES_NO_OPTION);
    }

    public int showInputDialog(String message) {
        Integer[] option = {0, 10, 20, 30, 50};
        int discount = (Integer) (JOptionPane.showInputDialog(null, message, "Please select", JOptionPane.QUESTION_MESSAGE, null, option, option[2]));
        return discount;
    }

    public void backButtonConfigure(JButton backButton) {
        backButton.setText("<= back");
        backButton.setBounds(5, 5, 120, 44);
        backButton.setBackground(new Color(255, 180, 100));

    }

    public void loggedNameLabel(JLabel loggedNameLabel) {
        loggedNameLabel.setText(this.loggedType.toString() + ": " + this.loggedName);
        loggedNameLabel.setBounds(130, 5, 200, 30);
        loggedNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loggedNameLabel.setFont(new Font(Font.SERIF, Font.BOLD, 14));
    }

    public void refreshOrderLabel(DefaultTableModel defaultTableModel, int tableNumber) {
        defaultTableModel.setRowCount(0);
        for (Order order : this.orders) {
            if (order.getTableNumber() == tableNumber) {
                String[] row = new String[4];
                row[0] = order.getUidString();
                row[1] = order.getTime();
                row[2] = order.getProductsCount();
                row[3] = order.getTotalAmountString();
                defaultTableModel.addRow(row);
            }
        }
    }

    public void loadProductIntTable(DefaultTableModel defaultTableModel, Order order) {
        defaultTableModel.setRowCount(0);
        for (Product product : order.getProducts()) {
            String[] row = new String[4];
            row[0] = product.getProductName();
            row[1] = product.getCountString();
            row[2] = product.getPriceString();
            row[3] = product.getTotalPriceString();
            defaultTableModel.addRow(row);

        }
    }
}
