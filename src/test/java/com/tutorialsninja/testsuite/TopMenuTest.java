package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.TestBase;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TopMenuTest extends TestBase {
    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();
    LaptopsAndNotebooksPage notebooksPage = new LaptopsAndNotebooksPage();
    ComponentsPage componentsPage = new ComponentsPage();

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = homePage.getTopMenuList();
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = homePage.getTopMenuList();
        }

        homePage.clickOnMenuOption(menu);

    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        homePage.mouseHoverOnDesktop();
        Thread.sleep(2000);
        selectMenu("Show AllDesktops");
        Assert.assertEquals(desktopsPage.getDesktopPageTitle(), "Desktops",
                "Not navigate to Desktop page");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverOnLaptopAndNotBook();
        selectMenu("Show AllLaptops & Notebooks");
        Assert.assertEquals(notebooksPage.getTitleOfLaptopAndNotBookPage(),
                "Laptops & Notebooks", "Not navigate to Laptops and Notebooks page");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverOnComponents();
        selectMenu("Show AllComponents");
        Assert.assertEquals(componentsPage.getPageTitleOfComponents(), "Components",
                "Not navigate to Components page");
    }

}
