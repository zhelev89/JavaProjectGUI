package database;

import models.*;

import java.util.*;

public class Database {

    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(new ProductType(1, "Alcoholics"), "Alcoholic"));
        categories.add(new Category(new ProductType(2, "NonAlcoholics"), "NonAlcoholics"));
        categories.add(new Category(new ProductType(3, "HotDrinks"), "HotDrinks"));
        categories.add(new Category(new ProductType(4, "Foods"), "Foods"));
        return categories;
    }
}
