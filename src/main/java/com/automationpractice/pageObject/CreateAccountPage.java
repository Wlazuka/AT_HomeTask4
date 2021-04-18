package com.automationpractice.pageObject;

import com.automationpractice.utils.PropertyManager;
import com.automationpractice.valueObjects.Address;
import com.automationpractice.valueObjects.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage{

    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement genderCheckBox;
    @FindBy(xpath = "//input[@id='customer_firstname']")
    public WebElement firstName;
    @FindBy(xpath = "//input[@id='customer_lastname']")
    public WebElement lastName;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailFieldOnCreationForm;
    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement passwordFieldOnCreationForm;
    @FindBy(xpath = "//select[@id='days']")
    public WebElement birthDayDropdown;
    @FindBy(xpath = "//select[@id='months']")
    public WebElement birthMonthDropdown;
    @FindBy(xpath = "//select[@id='years']")
    public WebElement birtYearDropdown;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement addressFirstName;
    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement addressLastName;
    @FindBy(xpath = "//input[@id='company']")
    public WebElement addressCompany;
    @FindBy(xpath = "//input[@id='address1']")
    public WebElement addressLine1;
    @FindBy(xpath = "//input[@id='address2']")
    public WebElement addressLine2;
    @FindBy(xpath = "//input[@id='city']")
    public WebElement addressCity;
    @FindBy(xpath = "//select[@id='id_state']")
    public WebElement addressStateDropdown;
    @FindBy(xpath = "//input[@id='postcode']")
    public WebElement addressPostCode;
    @FindBy(xpath = "//select[@id='id_country']")
    public WebElement addressCountry;
    @FindBy(xpath = "//textarea[@id='other']")
    public WebElement addressAdditonalInfo;
    @FindBy(xpath = "//input[@id='phone']")
    public WebElement addressHomePhone;
    @FindBy(xpath = "//input[@id='phone_mobile']")
    public WebElement addressMobilePhone;
    @FindBy(xpath = "//input[@id='alias']")
    public WebElement addressAlias;
    @FindBy(xpath = "//button[@id='submitAccount']")
    public WebElement submitNewAccountButton;

    public CreateAccountPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public CreateAccountPage createNewAccount(Customer customer){
        wait.forElementToLoad(genderCheckBox);
        enterPersonalInformation(customer);
        enterAddress(customer.address);
        submitNewAccountButton.click();
        return this;
    }

    private CreateAccountPage enterPersonalInformation(Customer customer) {
        genderCheckBox.click();
        firstName.sendKeys(customer.name);
        lastName.sendKeys(customer.lastName);
        emailFieldOnCreationForm.clear();
        emailFieldOnCreationForm.sendKeys(customer.email);
        passwordFieldOnCreationForm.sendKeys(customer.password);
        selectFromDropdownByValue(birthDayDropdown, customer.birthDay);
        selectFromDropdownByText(birthMonthDropdown, customer.birthMonth);
        selectFromDropdownByValue(birtYearDropdown, customer.birthYear);
        return this;
    }

    private CreateAccountPage enterAddress(Address address) {
//        addressFirstName.sendKeys(address.name);
//        addressLastName.sendKeys(address.lastName);
        addressCompany.sendKeys(address.company);
        addressLine1.sendKeys(address.addressLine1);
        addressLine2.sendKeys(address.addressLine2);
        addressCity.sendKeys(address.city);
        selectFromDropdownByText(addressStateDropdown, address.state);
        addressPostCode.sendKeys(address.postalCode);
        selectFromDropdownByText(addressCountry, address.country);
        addressAdditonalInfo.sendKeys(address.additionalInfo);
        addressHomePhone.sendKeys(address.homePhone);
        addressMobilePhone.sendKeys(address.mobilePhone);
        addressAlias.clear();
        addressAlias.sendKeys(address.addressAlias);
        return this;
    }


}
