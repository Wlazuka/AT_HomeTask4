package com.automationpractice.valueObjects;

import com.automationpractice.utils.PropertyManager;

public class Address {
    public String name;
    public String lastName;
    public String company;
    public String addressLine1;
    public String addressLine2;
    public String city;
    public String state;
    public String postalCode;
    public String country;
    public String additionalInfo;
    public String homePhone;
    public String mobilePhone;
    public String addressAlias;

    public Address(PropertyManager propertyManager) {
        this.name = propertyManager.getProperty("address.name");
        this.lastName = propertyManager.getProperty("address.last.name");
        this.company = propertyManager.getProperty("address.company");
        this.addressLine1 = propertyManager.getProperty("address.line1");
        this.addressLine2 = propertyManager.getProperty("address.line2");
        this.city = propertyManager.getProperty("address.city");
        this.state = propertyManager.getProperty("address.state");
        this.postalCode = propertyManager.getProperty("address.postal.code");
        this.country = propertyManager.getProperty("address.country");
        this.additionalInfo = propertyManager.getProperty("address.additional.info");
        this.homePhone = propertyManager.getProperty("address.home.phone");
        this.mobilePhone = propertyManager.getProperty("address.mobile.phone");
        this.addressAlias = propertyManager.getProperty("address.allias");
    }
}
