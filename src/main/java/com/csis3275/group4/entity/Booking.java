package com.csis3275.group4.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Document(collection ="Booking")
public class Booking {
    @Id
    private String id;
    private Customer customer;
    private String bookingDate;
    private int bookingTime;
    private List<Service> services;
    private List<Table> tables;
    private List<Staff> staff;

    public Booking() {
        this.services = new ArrayList<Service>();
        this.tables = new ArrayList<Table>();
        this.staff = new ArrayList<Staff>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getBooking_Date() {
        return bookingDate;
    }

    public void setBooking_Date(String booking_Date) {
        bookingDate = booking_Date;
    }

    public int getBooking_Time() {
        return bookingTime;
    }

    public void setBooking_Time(int booking_Time) {
        bookingTime = booking_Time;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }
}
