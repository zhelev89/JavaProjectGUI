package frames;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class MainDataProvider {

    public MainFrame currentFrame;

    public List<User> users;
    public List<Table> tables;
    public List<Order> orders;
    public List<Category> categories;
    public List<Product> products;
    public String loggedType;
    public String loggedName;
    private HttpClient client;
    private HttpRequest request;
    private ObjectMapper objectMapper;
    private HttpResponse<String> response;

    public MainDataProvider(MainFrame currentFrame) {
        this.currentFrame = currentFrame;

    }

    public List<User> fetchUsers() throws IOException, InterruptedException {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/users"))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        objectMapper = new ObjectMapper();

        users = objectMapper.readValue(json, new TypeReference<>() {
        });

        return users;
    }

    public List<Table> fetchTables() throws IOException, InterruptedException {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/tables"))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        objectMapper = new ObjectMapper();

        tables = objectMapper.readValue(json, new TypeReference<>() {
        });
        return tables;
    }

    public List<Product> fetchProducts() throws IOException, InterruptedException {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/products"))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        ObjectMapper objectMapper = new ObjectMapper();

        products = objectMapper.readValue(json, new TypeReference<>() {
        });
        return products;
    }

    public List<Category> fetchCategories() throws IOException, InterruptedException {

        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/categories"))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        ObjectMapper objectMapper = new ObjectMapper();

        categories = objectMapper.readValue(json, new TypeReference<>() {
        });
        return categories;

    }

    public boolean isPinCorrect(String pinCode) {
        for (User user : users) {
            if (pinCode.equals(user.getPinCode())) {
                this.loggedName = user.getName();
                this.loggedType = user.getUserType().getType();
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
