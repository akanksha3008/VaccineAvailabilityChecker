package com.example.vaccinenotifier;

import java.util.ArrayList;
import java.util.List;

public class CenterModel {
    private int center_id;
    private String name;
    private String address;
    private int pincode;
    private String fee_type;
    private int min_age_limit;
    private int available_capacity;
    private String date;

    @Override
    public String toString() {
        return "CenterModel{" +
                "center_id=" + center_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", pincode=" + pincode +
                ", fee_type='" + fee_type + '\'' +
                ", min_age_limit=" + min_age_limit +
                ", available_capacity=" + available_capacity +
                ", date='" + date + '\'' +
                ", vaccine='" + vaccine + '\'' +
                '}';
    }

    public CenterModel(int center_id, String name, String address, int pincode, String fee_type, int min_age_limit, int available_capacity, String date, String vaccine) {
        this.center_id = center_id;
        this.name = name;
        this.address = address;
        this.pincode = pincode;
        this.fee_type = fee_type;
        this.min_age_limit = min_age_limit;
        this.available_capacity = available_capacity;
        this.date = date;
        this.vaccine = vaccine;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCenter_id() {
        return center_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public int getMin_age_limit() {
        return min_age_limit;
    }

    public void setMin_age_limit(int min_age_limit) {
        this.min_age_limit = min_age_limit;
    }

    public int getAvailable_capacity() {
        return available_capacity;
    }

    public void setAvailable_capacity(int available_capacity) {
        this.available_capacity = available_capacity;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    private String vaccine;

}
