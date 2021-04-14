package com.automationpractice;

import com.automationpractice.utils.PropertyManager;
import com.automationpractice.valueObjects.Customer;

import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {

    Customer customer = new Customer(propertyManager);
    private static final String CREATE_ACC_PAGE_TITLE = PropertyManager.getProperty("createAccount.pageTitle");

    @Test()
    public void createAccountTest() throws InterruptedException {

        homePage.open()
                .signIn();
        signInPage
                .createAccount(customer.email);
        Thread.sleep(5000);
        createAccountPage
                .checkPageTitle(CREATE_ACC_PAGE_TITLE);
        createAccountPage
                .createNewAccount(customer);
    }

//    private void checkAddressInProfile(Customer customer){
//        checkName(customer);
//        checkAddressDetails(customer.address);
//    }

//    private void checkName(Customer customer){
//        if (customer.address.name.isEmpty()) {
//            Assert.assertEquals(myAddressesPage.firstAddressName.getText(), customer.name);
//        } else {
//            Assert.assertEquals(myAddressesPage.firstAddressName.getText(), customer.address.name);
//        }
//        if (customer.address.lastName.isEmpty()) {
//            Assert.assertEquals(myAddressesPage.firstAddressLastName.getText(), customer.lastName);
//        } else {
//            Assert.assertEquals(myAddressesPage.firstAddressLastName.getText(), customer.address.lastName);
//        }
//    }

//    private void checkAddressDetails(Address address){
//        Assert.assertEquals(myAddressesPage.firstAddressLine1.getText().trim(), address.addressLine1);
//        Assert.assertEquals(myAddressesPage.firstAddressLine2.getText().trim(), address.addressLine2);
//        Assert.assertEquals(myAddressesPage.firstAddressCompany.getText().trim(), address.company);
//        Assert.assertEquals(myAddressesPage.firstAddressCity.getText().trim(), address.city + ",");
//        Assert.assertEquals(myAddressesPage.firstAddressState.getText().trim(), address.state);
//        Assert.assertEquals(myAddressesPage.firstAddressPostalCode.getText().trim(), address.postalCode);
//        Assert.assertEquals(myAddressesPage.firstAddressCountry.getText().trim(), address.country);
//        Assert.assertEquals(myAddressesPage.firstAddressHomePhone.getText().trim(), address.homePhone);
//        Assert.assertEquals(myAddressesPage.firstAddressHomeMobilePhone.getText().trim(), address.mobilePhone);
//        Assert.assertEquals(myAddressesPage.firstAddressAlias.getText().trim(), address.addressAlias.toUpperCase(Locale.ROOT));
//    }
}
