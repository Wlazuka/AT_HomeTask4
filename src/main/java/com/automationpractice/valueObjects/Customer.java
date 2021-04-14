package com.automationpractice.valueObjects;


import com.automationpractice.utils.PropertyManager;

public class Customer {

    public String title;
    public String name;
    public String lastName;
    public String email;
    public String birthDay;
    public String birthMonth;
    public String birthYear;
    public String password;
    public Address address;

    public Customer(PropertyManager propertyManager){
        this.email = propertyManager.getProperty("customer.email");
        this.title = propertyManager.getProperty("customer.title");
        this.name = propertyManager.getProperty("customer.name");
        this.lastName = propertyManager.getProperty("customer.last.name");
        this.birthDay = propertyManager.getProperty("customer.birth.day");
        this.birthMonth = propertyManager.getProperty("customer.birth.month");
        this.birthYear = propertyManager.getProperty("customer.birth.year");
        this.password = propertyManager.getProperty("customer.password");
        this.address = new Address(propertyManager);
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setAddress(Address address){
        this.address = address;
    }
}
