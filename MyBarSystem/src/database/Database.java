package database;

import models.*;

import java.util.ArrayList;

public class Database {

    public static ArrayList<User> getUsers() {

        ArrayList<User> users = new ArrayList<>();

        User user1 = new User("Силвия Иванова", "0899123123", "0101", UserType.Сервитьор);
        User user2 = new User("Мария Георгиева", "0882882882", "2222", UserType.Сервитьор);
        User user3 = new User("Живко Желев", "0899123999", "0000", UserType.Управител);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }

    public static ArrayList<Product> getProducts() {

        ArrayList<Product> products = new ArrayList<>();

        Product a1 = new Product("a1", ProductType.Алкохолни, "Уиски", "Jack Daniels", 5.00, 140);
        Product a2 = new Product("a2", ProductType.Алкохолни, "Уиски", "Johnny Walker", 4.50, 140);
        Product a3 = new Product("a3", ProductType.Алкохолни, "Уиски", "Bushmills", 4.50, 140);
        Product a4 = new Product("a4", ProductType.Алкохолни, "Уиски", "Black Ram", 3.00, 140);
        Product a5 = new Product("a5", ProductType.Алкохолни, "Уиски", "Passport", 4.00, 140);
        Product b1 = new Product("b1", ProductType.Алкохолни, "Водка", "Beluga", 5.00, 140);
        Product b2 = new Product("b2", ProductType.Алкохолни, "Водка", "Russian Standard", 4.50, 140);
        Product b3 = new Product("b3", ProductType.Алкохолни, "Водка", "Absolute", 3.50, 140);
        Product b4 = new Product("b4", ProductType.Алкохолни, "Водка", "Flirt", 2.00, 140);
        Product b5 = new Product("b5", ProductType.Алкохолни, "Водка", "Savoy", 2.00, 140);
        Product c1 = new Product("c1", ProductType.Бира, "Бира", "Хайникен", 4.00, 140);
        Product c2 = new Product("c2", ProductType.Бира, "Бира", "Стела Артоа", 4.00, 140);
        Product c3 = new Product("c3", ProductType.Бира, "Бира", "Загорка", 2.50, 140);
        Product c4 = new Product("c4", ProductType.Бира, "Бира", "Каменица", 2.50, 140);
        Product d1 = new Product("d1", ProductType.Безалкохолни, "Сокове", "Cappy", 4.50, 100);
        Product d2 = new Product("d2", ProductType.Безалкохолни, "Сокове", "Queens", 4.50, 100);
        Product e1 = new Product("e1", ProductType.Безалкохолни, "Безалк.", "Coca Cola", 2.20, 100);
        Product e2 = new Product("e2", ProductType.Безалкохолни, "Безалк.", "Fanta", 2.20, 100);
        Product e3 = new Product("e3", ProductType.Безалкохолни, "Безалк.", "Sprite", 2.20, 100);
        Product e4 = new Product("e4", ProductType.Безалкохолни, "Безалк.", "Soda", 2.00, 100);
        Product f1 = new Product("f1", ProductType.Безалкохолни, "Мин.Вода", "Девин 0.330л", 2.00, 100);
        Product f2 = new Product("f2", ProductType.Безалкохолни, "Мин.Вода", "Девин 1.500л", 4.50, 100);
        Product g1 = new Product("g1", ProductType.ТоплиНапитки, "Кафе", "Еспресо", 2.50, 100);
        Product g2 = new Product("g2", ProductType.ТоплиНапитки, "Кафе", "Кафе с мляко", 3.00, 100);
        Product g3 = new Product("g3", ProductType.ТоплиНапитки, "Кафе", "Капучино", 3.00, 100);
        Product k1 = new Product("k1", ProductType.Храни, "Ядки", "Бадеми", 5.00, 30);
        Product k2 = new Product("k2", ProductType.Храни, "Ядки", "Кашу", 5.00, 30);
        Product l1 = new Product("l1", ProductType.Вино, "Червено вино", "Мавруд Асеновград", 5.00, 100);
        Product l2 = new Product("l1", ProductType.Вино, "Червено вино", "Вино Черга", 5.00, 100);
        Product l3 = new Product("l1", ProductType.Вино, "Бяло вино", "Мискет", 5.00, 100);

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
        categories.add(new Category(ProductType.Алкохолни, "Алкохол"));
        categories.add(new Category(ProductType.Вино, "Вино"));
        categories.add(new Category(ProductType.Бира, "Бира"));
        categories.add(new Category(ProductType.Безалкохолни, "Безалкохолни"));
        categories.add(new Category(ProductType.ТоплиНапитки, "Топли напитки"));
        categories.add(new Category(ProductType.Храни, "Храни"));
        return categories;
    }
}
