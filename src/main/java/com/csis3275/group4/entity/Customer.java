package com.csis3275.group4.entity;

public class Customer {
    private String Customer_Name;
    private String Customer_Phone;

    protected Customer() {}

    public Customer(String Customer_Name, String Customer_Phone){
        this.Customer_Name = Customer_Name;
        this.Customer_Phone = Customer_Phone;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public String getCustomer_Phone() {
        return Customer_Phone;
    }
}
