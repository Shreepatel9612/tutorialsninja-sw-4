package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {
    By pageTitle = By.xpath("(//h1)[2]");
    By productName = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By deliveryDate = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    By productModel = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");
    By totalPrice = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");
    By changeQuantity = By.xpath("//input[contains(@name, 'quantity')]");
    By updateBtn = By.xpath("//button[contains(@data-original-title, 'Update')]");
    By messageOfProductUpdate = By.xpath("//div[@id='checkout-cart']/div[1]");

    public String getShoppingCartPageTitle() {
        return getTextFromElement(pageTitle);
    }

    public String getProductName() {
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        return getTextFromElement(deliveryDate);
    }

    public String getProductModel() {
        return getTextFromElement(productModel);
    }

    public String getProductTotalPrise() {
        return getTextFromElement(totalPrice);
    }

    public void changeQuantity(String qty){
        sendTextToElementWithClearText(changeQuantity, qty);
    }

    public void clickOnUpdateButton(){
        clickOnElement(updateBtn);
    }

    public String getProductUpdateSuccessMessage() {
        return getTextFromElement(messageOfProductUpdate);
    }

}
