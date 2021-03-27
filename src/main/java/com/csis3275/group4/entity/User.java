package com.csis3275.group4.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
    @Id
    private String id;
    private String User_Name;
    private String Password;

    public User(String User_Name, String Password){
        this.User_Name = User_Name;
        this.Password = Password;
    }

    public String getId() {
        return id;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public String getPassword() {
        return Password;
    }
}
