package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {
    By LaptopAndNotBook = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By listOfProductPrice = By.xpath("//p[@class ='price']");
    By productSorting = By.id("input-sort");

    public String getTitleOfLaptopAndNotBookPage() {
        return getTextFromElement(LaptopAndNotBook);
    }

    public List<WebElement> getListsOfProductPrice(){
        return getWebElements(listOfProductPrice);
    }

    public void selectSortByZToA(String option){
        selectByVisibleTextFromDropDown(productSorting, option);
    }

    public void clickOnYourSelectedProduct(String productName){
        clickOnElement(By.linkText(productName));
    }

}
