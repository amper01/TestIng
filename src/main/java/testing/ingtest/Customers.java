package testing.ingtest;

import javax.persistence.*;


import java.util.ArrayList;


import java.util.List;
import java.util.Set;

@Entity
public class Customers {

    @Id
    private int customerid;

    private String name;
    private String region;
    private String brand;
    private int phnumber;
    private String email;
    private String startDate;

    public Customers() {
    }

    public Customers(int customerid, String name, String region, String brand, int phnumber, String email, String startDate) {
        this.customerid = customerid;
        this.name = name;
        this.region = region;
        this.brand = brand;
        this.phnumber = phnumber;
        this.email = email;
        this.startDate = startDate;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPhnumber() {
        return phnumber;
    }

    public void setPhnumber(int phnumber) {
        this.phnumber = phnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

}
