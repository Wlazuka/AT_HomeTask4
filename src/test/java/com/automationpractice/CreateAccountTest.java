package com.automationpractice;

import com.automationpractice.utils.PropertyManager;
import com.automationpractice.valueObjects.Customer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {

    Customer customer = new Customer(propertyManager);
    private static final String MY_ACC_PAGE_TITLE = PropertyManager.getProperty("myAccount.pageTitle");

    @Test()
    public void createAccountTest(){

        homePage.open()
                .signIn();
        signInPage
                .createAccount(customer.email);
        createAccountPage
                .createNewAccount(customer);
        myAccountPage.checkPageTitle(MY_ACC_PAGE_TITLE);
        Assert.assertTrue(myAccountPage.welcomeMsgIsDisplayed());
    }
}
