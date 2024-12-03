package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.MyAccountsPage;
import com.tutorialsninja.pages.RegisterAccountPage;
import com.tutorialsninja.testbase.TestBase;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MyAccountsTest extends TestBase {
    HomePage homePage = new HomePage();
    RegisterAccountPage register = new RegisterAccountPage();
    LoginPage loginPage = new LoginPage();
    MyAccountsPage myAccountPage = new MyAccountsPage();

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = homePage.getListOfMyAccountOption();
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = homePage.getListOfMyAccountOption();
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homePage.clickOnMyAccount();
        selectMyAccountOptions("Register");
        Assert.assertEquals(register.getRegisterAccountTitle(), "Register Account",
                "Register page not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        homePage.clickOnMyAccount();
        selectMyAccountOptions("Login");
        Assert.assertEquals(loginPage.getLoginPageTitle(), "Returning Customer",
                "Login page not displayed");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        homePage.clickOnMyAccount();
        selectMyAccountOptions("Register");

        register.enterFirstName("Hardik" + getAlphaNumericString(4));
        register.enterLastName("Patel" + getAlphaNumericString(4));
        register.enterEmail("shree9612" + getAlphaNumericString(4) + "@gmail.com");
        register.enterPhoneNumber("07345634545");
        register.enterPassword("123654");
        register.enterConfirmPassword("123654");
        register.selectSubscribe("Yes");
        register.clickOnPrivacyPolicyCheckBox();
        register.clickOnContinueButton();
        Assert.assertEquals(register.getAccountRegistrationConformationMessage(),
                "Your Account Has Been Created!", "Your Account Not Created!");
        register.clickOnContinueWithConfirmation();

        homePage.clickOnMyAccount();
        selectMyAccountOptions("Logout");
        Assert.assertEquals(homePage.getConfirmationMessageOfLogout(),
                "Account Logout", "Not logged out");
        homePage.clickOnContinueButton();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        homePage.clickOnMyAccount();
        selectMyAccountOptions("Login");

        loginPage.enterEmail("shreepatel9612@gmail.com");
        loginPage.enterPassword("123654");
        loginPage.clickOnLogInButton();
        Assert.assertEquals(myAccountPage.getMyAccountPageTitle(), "My Account",
                "My Account Is not Matched!");
        homePage.clickOnMyAccount();
        selectMyAccountOptions("Logout");
        Assert.assertEquals(homePage.getConfirmationMessageOfLogout(),
                "Account Logout", "Not logged out");
        homePage.clickOnContinueButton();

    }
}
