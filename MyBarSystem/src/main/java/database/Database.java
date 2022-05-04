package database;
import models.*;
import java.util.*;

public class Database {

    private List<Table> tables;

    public static Set<User> getUsers() {

        Set<User> users = new HashSet<>();

       /* User user1 = new User("Silvia Ivanova", "0899123123", "0101", new UserType(2, "Waitress"));
        User user2 = new User("Maria Georgieva", "0882882882", "2222", new UserType(2, "Waitress"));
        User user3 = new User("Zhivko Zhelev", "0899123999", "0000", new UserType(1, "Manager"));
        User user4 = new User("Admin", "0000000000", "9999", new UserType(9, "Admin"));

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        */
        return users;
    }

    /*
    public static Set<Product> getProducts() {

        Set<Product> products = new HashSet<>();

        ProductType alcoholics = new ProductType(1, "Alcoholics");
        ProductType nonAlcoholics = new ProductType(2, "NonAlcoholics");
        ProductType hotDrinks = new ProductType(3, "HotDrinks");
        ProductType foods = new ProductType(4, "Foods");

        Product a1 = new Product("a1", alcoholics, "Whiskey", "Jack Daniels", 5.00, 140, 1);
        Product a2 = new Product("a2", alcoholics, "Whiskey", "Johnny Walker", 4.50, 140, 1);
        Product a3 = new Product("a3", alcoholics, "Whiskey", "Bushmills", 4.50, 140, 1);
        Product a4 = new Product("a4", alcoholics, "Whiskey", "Black Ram", 3.00, 140, 1);
        Product a5 = new Product("a5", alcoholics, "Whiskey", "Passport", 4.00, 140, 1);
        Product b1 = new Product("b1", alcoholics, "Vodka", "Beluga", 5.00, 140, 1);
        Product b2 = new Product("b2", alcoholics, "Vodka", "Russian Standard", 4.50, 140, 1);
        Product b3 = new Product("b3", alcoholics, "Vodka", "Absolute", 3.50, 140, 1);
        Product b4 = new Product("b4", alcoholics, "Vodka", "Flirt", 2.00, 140, 1);
        Product b5 = new Product("b5", alcoholics, "Vodka", "Savoy", 2.00, 140, 1);
        Product c1 = new Product("c1", alcoholics, "Beer", "Haineken", 4.00, 140, 1);
        Product c2 = new Product("c2", alcoholics, "Beer", "Stella Artois", 4.00, 140, 1);
        Product c3 = new Product("c3", alcoholics, "Beer", "Zagorka", 2.50, 140, 1);
        Product c4 = new Product("c4", alcoholics, "Beer", "Kamenitca", 2.50, 140, 1);
        Product d1 = new Product("d1", nonAlcoholics, "Juices", "Cappy", 4.50, 100, 1);
        Product d2 = new Product("d2", nonAlcoholics, "Juices", "Queens", 4.50, 100, 1);
        Product e1 = new Product("e1", nonAlcoholics, "NonAlcoholics", "Coca Cola", 2.20, 100, 1);
        Product e2 = new Product("e2", nonAlcoholics, "NonAlcoholics", "Fanta", 2.20, 100, 1);
        Product e3 = new Product("e3", nonAlcoholics, "NonAlcoholics", "Sprite", 2.20, 100, 1);
        Product e4 = new Product("e4", nonAlcoholics, "NonAlcoholics", "Soda", 2.00, 100, 1);
        Product f1 = new Product("f1", nonAlcoholics, "Water", "Devin 0.330л", 2.00, 100, 1);
        Product f2 = new Product("f2", nonAlcoholics, "Water", "Devin 1.500л", 4.50, 100, 1);
        Product g1 = new Product("g1", hotDrinks, "Coffee", "Espresso", 2.50, 100, 1);
        Product g2 = new Product("g2", hotDrinks, "Coffee", "Coffee whit milk", 3.00, 100, 1);
        Product g3 = new Product("g3", hotDrinks, "Coffee", "Cappuccino", 3.00, 100, 1);
        Product k1 = new Product("k1", foods, "Nuts", "Almonds", 5.00, 30, 1);
        Product k2 = new Product("k2", foods, "Nuts", "Peanuts", 5.00, 30, 1);
        Product l1 = new Product("l1", alcoholics, "Red wine", "Mavrud Asenovgrad", 5.00, 100, 1);
        Product l2 = new Product("l1", alcoholics, "Red wine", "Cherga", 5.00, 100, 1);
        Product l3 = new Product("l1", alcoholics, "White wine", "Misket", 5.00, 100, 1);

        products.add(a1);
        products.add(a2);
        products.add(a3);
        products.add(a4);
        products.add(a5);
        products.add(b1);
        products.add(b2);
        products.add(b3);
        products.add(b4);
        products.add(b5);
        products.add(c1);
        products.add(c2);
        products.add(c3);
        products.add(c4);
        products.add(d1);
        products.add(d2);
        products.add(e1);
        products.add(e2);
        products.add(e3);
        products.add(e4);
        products.add(f1);
        products.add(f2);
        products.add(g1);
        products.add(g2);
        products.add(g3);
        products.add(k1);
        products.add(k2);
        products.add(l1);
        products.add(l2);
        products.add(l3);

        return products;
    }

     */

    /*public static List<Table> getTables() {

        List<Table> tables = new ArrayList<>();
        Table table1 = new Table(null, 1);
        Table table2 = new Table(null, 2);
        Table table3 = new Table(null, 3);
        Table table4 = new Table(null, 4);
        Table table5 = new Table(null, 5);
        Table table6 = new Table(null, 6);
        Table table7 = new Table(null, 7);
        Table table8 = new Table(null, 8);
        Table table9 = new Table(null, 9);
        Table table10 = new Table(null, 10);
        Table table11 = new Table(null, 11);
        Table table12 = new Table(null, 12);

        tables.add(table1);
        tables.add(table2);
        tables.add(table3);
        tables.add(table4);
        tables.add(table5);
        tables.add(table6);
        tables.add(table7);
        tables.add(table8);
        tables.add(table9);
        tables.add(table10);
        tables.add(table11);
        tables.add(table12);


        return tables;
    }

     */

    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(new ProductType(1, "Alcoholics"), "Alcoholic"));
        categories.add(new Category(new ProductType(2, "NonAlcoholics"), "NonAlcoholics"));
        categories.add(new Category(new ProductType(3, "HotDrinks"), "HotDrinks"));
        categories.add(new Category(new ProductType(4, "Foods"), "Foods"));
        return categories;
    }
}
