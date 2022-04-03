package com.company;

public class Location {
    private String country;
    private String city;
    private String street;
    private String postCode;

    public Location(String country, String city, String street, String postCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.postCode = postCode;
    }

    public String printInfo() {
        return ("Country: " + this.country + " City: " + this.city + " Street: " + this.city +
                " Postal Code: " + this.postCode);
    }
}
