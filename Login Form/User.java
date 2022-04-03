package com.company;

public class User {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String gender;
    private Location location;

    public User(String firstName, String lastName, String phone, String email, String gender, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.location = location;
    }

    public void printFullInfo() {
        System.out.printf("Name: %s %s, Phone: %s, Email: %s, Gender: %s, %nLocation: %s %n",
                this.firstName, this.lastName, this.phone, this.email, this.gender, this.location.printInfo());

        System.out.println();
    }
}
