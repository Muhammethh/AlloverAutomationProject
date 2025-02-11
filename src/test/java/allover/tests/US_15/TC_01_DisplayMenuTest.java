package allover.tests.US_15;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.pages.StoreManagerPage;
import allover.utilities.*;
import org.bson.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01_DisplayMenuTest {
    @Test
    public void displayMenuTest() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        StoreManagerPage storeManagerPage = new StoreManagerPage();

        homePage.signIn.click();

        signInPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("vendorEmail"));

        signInPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("vendorPassword"));

        signInPage.SignInButton.click();
        ReusableMethods.scroll(homePage.myAccount);
        ReusableMethods.scroll(homePage.myAccount);
        ReusableMethods.visibleWait(homePage.myAccount,5);

        homePage.myAccount.click();

        myAccountPage.StoreManagerButton.click();

        ReusableMethods.scroll(storeManagerPage.ProductsButton);
        ReusableMethods.visibleWait(storeManagerPage.ProductsButton,5);
        storeManagerPage.ProductsButton.click();

        storeManagerPage.SearchBox.click();
        storeManagerPage.SearchBox.sendKeys("tea maker");
        ReusableMethods.scroll(storeManagerPage.TeaMaker);


        ActionsUtils.scrollDown();
        WaitUtils.waitForClickablility(storeManagerPage.TeaMaker,5);


        storeManagerPage.TeaMaker.click();

        ActionsUtils.scrollDown();
        ActionsUtils.scrollDown();
        ActionsUtils.scrollDown();

        Assert.assertTrue(storeManagerPage.InventoryButton.isDisplayed());
        Assert.assertTrue(storeManagerPage.ShippingButton.isDisplayed());
        Assert.assertTrue(storeManagerPage.AttributesButton.isDisplayed());
        Assert.assertTrue(storeManagerPage.SeoButton.isDisplayed());
        Assert.assertTrue(storeManagerPage.AdvancedButton.isDisplayed());


        Driver.closeDriver();

    }
}



