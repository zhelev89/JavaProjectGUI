package panels;

import base.BasePanel;
import frames.MainFrame;
import models.Category;
import models.Order;
import models.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrdersPanel extends BasePanel {

    private int tableNumber;
    private JButton backButton;
    private JPanel categoriesButtonPanel;
    //Order table
    private DefaultTableModel orderTableModel;
    private JTable orderTable;
    private Order selectedOrder;
    private int selectedRow;
    private List<Order> tablesOrder;
    //product table
    private DefaultTableModel productTableModel;
    private JTable productTable;
    private Product selectedProduct;
    private int currentlySelectedProductRow;
    private List<Product> products;
    //Buttons
    private List<Category> categories;
    private List<JButton> categoriesButtons;

    private List<JButton> productsButtons;


    public OrdersPanel(MainFrame frame, int tableNumber) throws IOException, InterruptedException {
        super(frame);
        this.tableNumber = tableNumber;
        categories = frame.dataProvider.fetchCategories();
        products = frame.dataProvider.fetchProducts();
        createHeader();
        createOrderButtons();
        createOrderTable();
        createProductTable();
        createCategoriesButtonPanel();

        refresh();
    }

    public void createHeader() {
        backButton = new JButton();
        frame.dataProvider.backButtonConfigure(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.router.showTablesPanel();
            }
        });
        add(backButton);

        JLabel loggedNameLabel = new JLabel();
        frame.dataProvider.loggedNameLabel(loggedNameLabel);
        add(loggedNameLabel);

        JLabel tableNumberLabel = new JLabel("Table: " + this.tableNumber);
        tableNumberLabel.setBounds(330, 5, 60, 30);
        tableNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tableNumberLabel.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        add(tableNumberLabel);

    }

    public void createOrderButtons() {
        JButton createOrderButton = new JButton("Create");
        createOrderButton.setBounds(505, 54, 120, 44);
        createOrderButton.setBackground(new Color(255, 180, 100));
        createOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createOrderAction();
            }
        });
        add(createOrderButton);

        JButton finishOrderButton = new JButton("Complete");
        finishOrderButton.setBounds(630, 54, 120, 44);
        finishOrderButton.setBackground(new Color(255, 180, 100));
        finishOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedOrder == null) {
                    frame.dataProvider.showErrorMessage("You have no order selected!");
                    return;
                }
                if (frame.dataProvider.showQuestionMessage("Complete the order?") == JOptionPane.YES_NO_OPTION) {
                    //Pop up for extract for cashier note
                    String orderNumber = "Order: " + selectedOrder.getUidString();
                    String time = "Time: " + OrdersPanel.super.time.format(currentlyDate);
                    String numbersOfProduct = "Number of items: " + selectedOrder.getProductsCount();
                    String percentDiscount = "Discount: " + selectedOrder.getDiscountPercent() + "%";
                    String totalPrice = "Total: " + selectedOrder.getTotalAmountString();
                    String lineSep = System.lineSeparator();
                    String result = "Receipt:" + lineSep + lineSep +
                            orderNumber + lineSep +
                            time + lineSep +
                            numbersOfProduct + lineSep +
                            percentDiscount + lineSep +
                            totalPrice;
                    JOptionPane.showMessageDialog(null, result);

                    frame.dataProvider.orders.remove(selectedOrder);
                    frame.router.showLoginPanel();

                }
            }
        });
        add(finishOrderButton);

        JButton increaseProductButton = new JButton("+");
        increaseProductButton.setBounds(505, 495, 120, 44);
        increaseProductButton.setBackground(new Color(200, 100, 100));
        increaseProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyProduct(true);
            }
        });
        add(increaseProductButton);

        JButton decreaseProductButton = new JButton("-");
        decreaseProductButton.setBounds(630, 495, 120, 44);
        decreaseProductButton.setBackground(new Color(200, 100, 100));
        decreaseProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyProduct(false);
            }
        });
        add(decreaseProductButton);

        JButton discountButton = new JButton("Discount %");
        discountButton.setBounds(755, 495, 120, 44);
        discountButton.setBackground(Color.cyan);
        discountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedOrder != null) {
                    try {
                        int discount = frame.dataProvider.showInputDialog("Please select a percentage!");
                        selectedOrder.setDiscountPercent(discount);
                        refresh();
                    } catch (NullPointerException ignored) {
                    }
                } else {
                    frame.dataProvider.showErrorMessage("You have no selected order!");
                }
            }

        });
        add(discountButton);
    }

    public void createCategoriesButtonPanel() throws IOException, InterruptedException {
        categoriesButtonPanel = new JPanel();
        categoriesButtonPanel.setBounds(5, 54, 495, 436);
        categoriesButtonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        categoriesButtonPanel.setBackground(new Color(128, 175, 175));
        add(categoriesButtonPanel);

        createCategoriesButton();
    }

    public void createProductButton(String title) throws IOException, InterruptedException {
        productsButtons = new ArrayList<>();
        int x = 5;
        int y = 54;
        for (int i = 0; i < frame.dataProvider.fetchProducts().size(); i++) {

            Product product = frame.dataProvider.fetchProducts().get(i);
            if (!product.getProductType().toString().equals(title)) {
                continue;
            }

            JButton productButton = new JButton();
            productButton.setLayout(new BorderLayout());
            JLabel label1 = new JLabel(product.getSubtype());
            label1.setFont(new Font(Font.SERIF, Font.BOLD, 12));
            JLabel label2 = new JLabel(product.getBrand());
            label2.setFont(new Font(Font.SERIF, Font.BOLD, 14));
            productButton.add(BorderLayout.NORTH, label1);
            productButton.add(BorderLayout.SOUTH, label2);

            productButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (selectedOrder == null) {
                        frame.dataProvider.showErrorMessage("You have no selected order!");
                    } else {
                        if (selectedOrder.getTableNumber() == tableNumber) {
                            boolean isProductFound = false;
                            for (Product product1 : selectedOrder.getProducts()) {
                                if (product1.getId().equals(product.getId())) {
                                    product1.increaseCount();
                                    isProductFound = true;
                                    break;
                                }
                            }
                            if (!isProductFound) {
                                selectedOrder.getProducts().add(product);
                            }
                            refresh();

                        }
                    }
                }
            });
            productsButtons.add(productButton);
            categoriesButtonPanel.add(productButton);


            if (product.getSubtype().equals("Whiskey")) {
                productButton.setBackground(Color.pink);
            } else if (product.getSubtype().equals("Vodka")) {
                productButton.setBackground(Color.cyan);
            } else if (product.getSubtype().equals("Juices")) {
                productButton.setBackground(Color.yellow);
            } else if (product.getSubtype().equals("NonAlcoholic")) {
                productButton.setBackground(Color.green);
            } else if (product.getSubtype().equals("Water")) {
                productButton.setBackground(Color.CYAN);
            } else if (product.getTypeString().equals("Beer")) {
                productButton.setBackground(new Color(200, 200, 100));
            } else if (product.getTypeString().equals("HotDrinks")) {
                productButton.setBackground(Color.gray);
            } else if (product.getTypeString().equals("Food")) {
                productButton.setBackground(Color.white);
            } else if (product.getSubtype().equals("Red wine")) {
                productButton.setBackground(new Color(200, 100, 100));
            } else if (product.getSubtype().equals("White wine")) {
                productButton.setBackground(new Color(255, 240, 220));
            }
            productButton.setBounds(x, y, 120, 44);
            x += 125;
            if (i % 4 == 3) {
                x = 5;
                y += 49;
            }
        }
        JButton backButton = new JButton("Back");
        backButton.setBounds(x, y, 120, 44);
        backButton.setBackground(new Color(255, 180, 100));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                categoriesButtonPanel.removeAll();
                try {
                    createCategoriesButton();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                repaint();
                validate();
            }
        });
        categoriesButtons.add(backButton);
        categoriesButtonPanel.add(backButton);
    }

    public void createCategoriesButton() throws IOException, InterruptedException {
        categoriesButtons = new ArrayList<>();
        int x = 5;
        int y = 54;
        for (int i = 0; i < frame.dataProvider.fetchCategories().size(); i++) {

            Category category = frame.dataProvider.fetchCategories().get(i);
            JButton categoryButton = new JButton(category.getTitle());

            categoryButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    categoriesButtonPanel.removeAll();
                    try {
                        createProductButton(category.getTitle());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    repaint();
                    validate();
                }
            });
            categoriesButtons.add(categoryButton);
            categoriesButtonPanel.add(categoryButton);

            if (category.getTitle().equals("Alcoholics")) {
                categoryButton.setBackground(Color.cyan);
            } else if (category.getTitle().equals("NonAlcoholics")) {
                categoryButton.setBackground(Color.orange);
            } else if (category.getTitle().equals("HotDrinks")) {
                categoryButton.setBackground(Color.gray);
            } else if (category.getTitle().equals("Foods")) {
                categoryButton.setBackground(Color.pink);
            }
            categoryButton.setBounds(x, y, 120, 44);
            x += 125;
            if (i % 3 == 2) {
                x = 5;
                y += 49;
            }
        }
    }

    public void createOrderTable() {
        String[] columns = {"Order number", "Time", "Number of items", "Total"};
        orderTableModel = new DefaultTableModel();
        orderTableModel.setColumnIdentifiers(columns);
        orderTable = new JTable(orderTableModel);
        orderTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tablesOrder = new ArrayList<>();
                for (Order order : frame.dataProvider.orders) {
                    if (order.getTableNumber() == tableNumber) {
                        tablesOrder.add(order);
                    }
                }
                selectedOrder = tablesOrder.get(orderTable.getSelectedRow());
                selectedRow = orderTable.getSelectedRow();
                refresh();

            }
        });
        JScrollPane scrollPane = new JScrollPane(orderTable);
        scrollPane.setBounds(505, 103, 370, 94);
        add(scrollPane);
    }

    public void createProductTable() {
        String[] columns = {"Items", "Quantity", "Price", "Total price"};
        productTableModel = new DefaultTableModel();
        productTableModel.setColumnIdentifiers(columns);
        productTable = new JTable(productTableModel);
        productTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                currentlySelectedProductRow = productTable.getSelectedRow();
                selectedProduct = selectedOrder.getProducts().get(currentlySelectedProductRow);

            }
        });
        JScrollPane productScrollPane = new JScrollPane(productTable);
        productScrollPane.setBounds(505, 201, 370, 289);
        add(productScrollPane);
    }

    public void modifyProduct(boolean isIncrease) {
        if (selectedProduct != null) {
            if (isIncrease) {
                selectedProduct.increaseCount();
            } else {
                if (selectedProduct.getCount() == 1) {
                    selectedOrder.getProducts().remove(selectedProduct);
                } else {
                    selectedProduct.decreaseCount();
                }
            }
            refresh();
            if (currentlySelectedProductRow < selectedOrder.getProducts().size()) {
                productTable.setRowSelectionInterval(currentlySelectedProductRow, currentlySelectedProductRow);
            }
        } else {
            frame.dataProvider.showErrorMessage("You have no selected product!");
        }
    }

    public void createOrderAction() {
        if (frame.dataProvider.showQuestionMessage("Do you want to create a new order?") == 0) {
            int uid = frame.dataProvider.orders.size() + 1;
            String time = super.time.format(super.currentlyDate);
            Order order = new Order(uid, time, tableNumber, new ArrayList<>(), 0);
            frame.dataProvider.orders.add(order);
            refresh();
        }
    }

    public void refresh() {
        frame.dataProvider.refreshOrderLabel(orderTableModel, tableNumber);
        if (selectedOrder != null) {
            loadProduct();
            orderTable.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }

    public void loadProduct() {
        frame.dataProvider.loadProductIntTable(productTableModel, selectedOrder);
    }

}
