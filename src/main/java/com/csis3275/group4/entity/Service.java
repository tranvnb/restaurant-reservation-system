package com.csis3275.group4.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Service")
public class Service {

    @Id
    private String id;
    private String Service_Name;
    private int Service_Price;

    protected Service(){}

    public Service(String Service_Name, int Service_Price){
        this.Service_Name = Service_Name;
        this.Service_Price = Service_Price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getService_Name() {
        return Service_Name;
    }

    public void setService_Name(String service_Name) {
        Service_Name = service_Name;
    }

    public int getService_Price() {
        return Service_Price;
    }

    public void setService_Price(int service_Price) {
        Service_Price = service_Price;
    }
}
