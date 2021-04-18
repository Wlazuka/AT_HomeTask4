package com.automationpractice;

import com.automationpractice.utils.PropertyManager;
import org.testng.annotations.Test;

public class CreateAccountInvalidEmailTest extends BaseTest {
    private static final String INVALID_EMAIL = PropertyManager.getProperty("createAccount.invalidEmail");
    private static final String INVALID_EMAIL_ALERT = PropertyManager.getProperty("createAccount.invalidEmailAlert");


    @Test
    public void signInFailTest() {
        homePage.open()
                .signIn();
        signInPage
                .createAccount(INVALID_EMAIL);
        System.out.println(signInPage.alertText());
    }
}
