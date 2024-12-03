package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By loginPageTile = By.xpath("//h2[contains(text(),'Returning Customer')]");

    By email = By.id("input-email");
    By password = By.id("input-password");
    By btnLogin = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

    public String getLoginPageTitle(){
        return getTextFromElement(loginPageTile);
    }

    public void enterEmail(String mail) {
        sendTextToElement(email, mail);
    }

    public void enterPassword(String pass) {
        sendTextToElement(password, pass);
    }

    public void clickOnLogInButton() {
        clickOnElement(btnLogin);
    }
}
