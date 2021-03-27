package com.csis3275.group4.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Staff")
public class Staff {
    @Id
    private String id;
    private String Staff_Name;
    private Date Staff_DOB;
    private String Staff_Address;
    private List<String> Staff_Shift;

    protected Staff() {}

    public Staff(String Staff_Name, Date Staff_DOB, String Staff_Address, List<String> Staff_Shift){
        this.Staff_Name = Staff_Name;
        this.Staff_DOB = Staff_DOB;
        this.Staff_Address = Staff_Address;
        this.Staff_Shift = Staff_Shift;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStaff_Name() {
        return Staff_Name;
    }

    public void setStaff_Name(String staff_Name) {
        Staff_Name = staff_Name;
    }

    public Date getStaff_DOB() {
        return Staff_DOB;
    }

    public void setStaff_DOB(Date staff_DOB) {
        Staff_DOB = staff_DOB;
    }

    public String getStaff_Address() {
        return Staff_Address;
    }

    public void setStaff_Address(String staff_Address) {
        Staff_Address = staff_Address;
    }

    public List<String> getStaff_Shift() {
        return Staff_Shift;
    }

    public void setStaff_Shift(List<String> staff_Shift) {
        Staff_Shift = staff_Shift;
    }
}
