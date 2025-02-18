package allover.tests.us_15_VendorStoreManegement;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.pages.StoreManagerPage;
import allover.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01_DisplayMenuTest {
    @Test
    public void displayMenuTest() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportsListener.extentTestInfo("Sayfaya gidilir.");

        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        StoreManagerPage storeManagerPage = new StoreManagerPage();

        homePage.signIn.click();
        ExtentReportsListener.extentTestInfo("Sign in tiklanir.");

        signInPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        ExtentReportsListener.extentTestInfo("Vendor email girilir.");

        signInPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("vendorPassword"));
        ExtentReportsListener.extentTestInfo("Vendor password girilir.");

        signInPage.SignInButton.click();
        ExtentReportsListener.extentTestInfo("Sign in butonuna tiklanir.");

        ReusableMethods.scroll(homePage.myAccount);
        ReusableMethods.scroll(homePage.myAccount);
        ReusableMethods.visibleWait(homePage.myAccount, 5);
        ExtentReportsListener.extentTestInfo("Scroll downn yapilir.");

        homePage.myAccount.click();
        ExtentReportsListener.extentTestInfo("My account a tiklanir.");

        myAccountPage.StoreManagerButton.click();
        ExtentReportsListener.extentTestInfo("Store manager a tiklanir.");

        ReusableMethods.scroll(storeManagerPage.ProductsButton);
        ReusableMethods.visibleWait(storeManagerPage.ProductsButton, 5);
        storeManagerPage.ProductsButton.click();
        ExtentReportsListener.extentTestInfo("Products a yiklanir.");

        storeManagerPage.SearchBox.click();
        storeManagerPage.SearchBox.sendKeys("tea maker");
        ExtentReportsListener.extentTestInfo("Search box a 'tea maker' yazilir.");

        ReusableMethods.scroll(storeManagerPage.TeaMaker);
        ActionsUtils.scrollDown();
        WaitUtils.waitForClickablility(storeManagerPage.TeaMaker, 5);
        storeManagerPage.TeaMaker.click();
        ExtentReportsListener.extentTestInfo("tea maker a tiklanir.");

        ActionsUtils.scrollDown();
        ActionsUtils.scrollDown();
        ActionsUtils.scrollDown();
        JSUtils.JSclickWithTimeout(storeManagerPage.InventoryButton);

        Assert.assertTrue(storeManagerPage.InventoryButton.isDisplayed());
        Assert.assertTrue(storeManagerPage.ShippingButton.isDisplayed());
        Assert.assertTrue(storeManagerPage.AttributesButton.isDisplayed());
        Assert.assertTrue(storeManagerPage.LinkedButton.isDisplayed());
        Assert.assertTrue(storeManagerPage.SeoButton.isDisplayed());
        Assert.assertTrue(storeManagerPage.AdvancedButton.isDisplayed());
        ExtentReportsListener.extentTestInfo("Inventory, Shipping, Attributes, Linked, Seo, Advanced munuleri goruntulendigi dogrulanir.");

        Driver.closeDriver();
    }
}



