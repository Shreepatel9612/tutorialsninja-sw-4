package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By topMenuList = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By desktop = By.linkText("Desktops");
    By laptopAndNotBook = By.linkText("Laptops & Notebooks");
    By components = By.linkText("Components");
    By currency = By.xpath("//span[contains(text(),'Currency')]");
    By selectPound = By.xpath("//ul[@class = 'dropdown-menu']/li");
    By listOfAccountOption = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");

    By myAccount = By.xpath("//span[contains(text(),'My Account')]");
    By confirmationMsgOfLogOut = By.xpath("//h1[contains(text(),'Account Logout')]");
    By btnContinue = By.xpath("//a[contains(text(),'Continue')]");


    public List<WebElement> getTopMenuList() {
        return getWebElements(topMenuList);
    }

    public void clickOnMenuOption(String name) {
        clickOnElement(By.linkText(name));
    }

    public void mouseHoverOnDesktop() {
        mouseHoverToElement(desktop);
    }

    public void mouseHoverOnLaptopAndNotBook() {
        mouseHoverToElement(laptopAndNotBook);
    }

    public void mouseHoverOnComponents() {
        mouseHoverToElement(components);
    }

    public void mouseHoverOnCurrencyAndClickOn(){
        mouseHoverToElementAndClick(currency);
    }

    public void selectCurrencyAsAPound(String option){
        selectByContainsTextFromDropDown(selectPound, option);
    }

    public List<WebElement> getListOfMyAccountOption() {
        return getWebElements(listOfAccountOption);
    }

    public void clickOnMyAccount(){
        clickOnElement(myAccount);
    }

    public String getConfirmationMessageOfLogout(){
        return getTextFromElement(confirmationMsgOfLogOut);
    }

    public void clickOnContinueButton(){
        clickOnElement(btnContinue);
    }
}
