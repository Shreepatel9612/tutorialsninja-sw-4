package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class RegisterAccountPage extends Utility {
    By pageTitle = By.xpath("//h1[contains(text(),'Register Account')]");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By phoneNumber = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By subScribe = By.xpath("//fieldset[3]//input");
    By privacyPolicy = By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    By btnContinue = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");
    By confirmationMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By continueConfirmation = By.xpath("//a[contains(text(),'Continue')]");

    public String getRegisterAccountTitle() {
        return getTextFromElement(pageTitle);
    }

    public void enterFirstName(String fName) {
        sendTextToElement(firstName, fName);
    }

    public void enterLastName(String lNmae) {
        sendTextToElement(lastName, lNmae);
    }

    public void enterEmail(String mail) {
        sendTextToElement(email, mail);
    }

    public void enterPhoneNumber(String number) {
        sendTextToElement(phoneNumber, number);
    }

    public void enterPassword(String pass) {
        sendTextToElement(password, pass);
    }

    public void enterConfirmPassword(String cPass) {
        sendTextToElement(confirmPassword, cPass);
    }

    public void selectSubscribe(String option) {
        selectByContainsTextFromListOfElements(subScribe, option);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicy);
    }

    public void clickOnContinueButton() {
        clickOnElement(btnContinue);
    }

    public String getAccountRegistrationConformationMessage() {
        return getTextFromElement(confirmationMessage);
    }

    public void clickOnContinueWithConfirmation() {
        clickOnElement(continueConfirmation);
    }
}
