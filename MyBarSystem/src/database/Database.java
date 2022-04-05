package database;

import models.*;

import java.util.ArrayList;

public class Database {

    public static ArrayList<User> getUsers() {

        ArrayList<User> users = new ArrayList<>();

        User user1 = new User("Silvia Ivanova", "0899123123", "0101", UserType.Waitress);
        User user2 = new User("Maria Georgieva", "0882882882", "2222", UserType.Waitress);
        User user3 = new User("Zhivko Zhelev", "0899123999", "0000", UserType.Manager);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }

    public static ArrayList<Product> getProducts() {

        ArrayList<Product> products = new ArrayList<>();

        Product a1 = new Product("a1", ProductType.Alcoholic, "Whiskey", "Jack Daniels", 5.00, 140);
        Product a2 = new Product("a2", ProductType.Alcoholic, "Whiskey", "Johnny Walker", 4.50, 140);
        Product a3 = new Product("a3", ProductType.Alcoholic, "Whiskey", "Bushmills", 4.50, 140);
        Product a4 = new Product("a4", ProductType.Alcoholic, "Whiskey", "Black Ram", 3.00, 140);
        Product a5 = new Product("a5", ProductType.Alcoholic, "Whiskey", "Passport", 4.00, 140);
        Product b1 = new Product("b1", ProductType.Alcoholic, "Vodka", "Beluga", 5.00, 140);
        Product b2 = new Product("b2", ProductType.Alcoholic, "Vodka", "Russian Standard", 4.50, 140);
        Product b3 = new Product("b3", ProductType.Alcoholic, "Vodka", "Absolute", 3.50, 140);
        Product b4 = new Product("b4", ProductType.Alcoholic, "Vodka", "Flirt", 2.00, 140);
        Product b5 = new Product("b5", ProductType.Alcoholic, "Vodka", "Savoy", 2.00, 140);
        Product c1 = new Product("c1", ProductType.Beer, "Beer", "Haineken", 4.00, 140);
        Product c2 = new Product("c2", ProductType.Beer, "Beer", "Stella Artois", 4.00, 140);
        Product c3 = new Product("c3", ProductType.Beer, "Beer", "Zagorka", 2.50, 140);
        Product c4 = new Product("c4", ProductType.Beer, "Beer", "Kamenitca", 2.50, 140);
        Product d1 = new Product("d1", ProductType.NonAlcoholic, "Juices", "Cappy", 4.50, 100);
        Product d2 = new Product("d2", ProductType.NonAlcoholic, "Juices", "Queens", 4.50, 100);
        Product e1 = new Product("e1", ProductType.NonAlcoholic, "NonAlcoholic", "Coca Cola", 2.20, 100);
        Product e2 = new Product("e2", ProductType.NonAlcoholic, "NonAlcoholic", "Fanta", 2.20, 100);
        Product e3 = new Product("e3", ProductType.NonAlcoholic, "NonAlcoholic", "Sprite", 2.20, 100);
        Product e4 = new Product("e4", ProductType.NonAlcoholic, "NonAlcoholic", "Soda", 2.00, 100);
        Product f1 = new Product("f1", ProductType.NonAlcoholic, "Water", "Devin 0.330л", 2.00, 100);
        Product f2 = new Product("f2", ProductType.NonAlcoholic, "Water", "Devin 1.500л", 4.50, 100);
        Product g1 = new Product("g1", ProductType.HotDrinks, "Coffee", "Espresso", 2.50, 100);
        Product g2 = new Product("g2", ProductType.HotDrinks, "Coffee", "Coffee whit milk", 3.00, 100);
        Product g3 = new Product("g3", ProductType.HotDrinks, "Coffee", "Cappuccino", 3.00, 100);
        Product k1 = new Product("k1", ProductType.Food, "Nuts", "Almonds", 5.00, 30);
        Product k2 = new Product("k2", ProductType.Food, "Nuts", "Peanuts", 5.00, 30);
        Product l1 = new Product("l1", ProductType.Wine, "Red wine", "Mavrud Asenovgrad", 5.00, 100);
        Product l2 = new Product("l1", ProductType.Wine, "Red wine", "Cherga", 5.00, 100);
        Product l3 = new Product("l1", ProductType.Wine, "White wine", "Misket", 5.00, 100);

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

    public static ArrayList<Integer> getTables () {

        ArrayList<Integer> tables = new ArrayList<>();
        tables.add(1);
        tables.add(2);
        tables.add(3);
        tables.add(4);
        tables.add(5);
        tables.add(6);
        tables.add(7);
        tables.add(8);
        tables.add(9);
        tables.add(10);
        tables.add(11);
        tables.add(12);
        return tables;
    }

    public static ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(ProductType.Alcoholic, "Alcohol"));
        categories.add(new Category(ProductType.Wine, "Wine"));
        categories.add(new Category(ProductType.Beer, "Beer"));
        categories.add(new Category(ProductType.NonAlcoholic, "NonAlcohol"));
        categories.add(new Category(ProductType.HotDrinks, "HotDrinks"));
        categories.add(new Category(ProductType.Food, "Food"));
        return categories;
    }
}
