package com.csis3275.group4.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Booking {
    private String id;
    private Customer customer;
    private Date Booking_Date;
    private Time Booking_Time;
    private List<Service> services;
    private List<Table> tables;
    private List<Staff> staff;

    protected Booking() {
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

    public Date getBooking_Date() {
        return Booking_Date;
    }

    public void setBooking_Date(Date booking_Date) {
        Booking_Date = booking_Date;
    }

    public Time getBooking_Time() {
        return Booking_Time;
    }

    public void setBooking_Time(Time booking_Time) {
        Booking_Time = booking_Time;
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
