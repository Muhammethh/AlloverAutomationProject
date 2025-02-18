package allover.tests.us_15_VendorStoreManegement;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.pages.StoreManagerPage;
import allover.utilities.*;
import org.testng.annotations.Test;

public class TC_03_ShippingTest {
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

        JSUtils.JSclickWithTimeout(storeManagerPage.ShippingButton);
        storeManagerPage.ShippingButton.click();
        ExtentReportsListener.extentTestInfo("Shipping e tiklanir.");

        WaitUtils.waitFor(2);
        ActionsUtils.pressTab();
        WaitUtils.waitFor(2);
        storeManagerPage.WeightTextBox.sendKeys("10");
        ActionsUtils.pressTab();
        ExtentReportsListener.extentTestInfo("Weight kismina '10' yazilir.");

        storeManagerPage.LengthTextBox.sendKeys("1000");
        ExtentReportsListener.extentTestInfo("Length kismina '1000' yazilir.");

        ActionsUtils.pressTab();
        storeManagerPage.WidthTextBox.sendKeys("2000");
        ExtentReportsListener.extentTestInfo("Width kismina '2000' yazilir.");

        ActionsUtils.pressTab();
        storeManagerPage.HeightTextBox.sendKeys("2000");
        ExtentReportsListener.extentTestInfo("Height kismina '2000' yazilir.");

        ActionsUtils.pressTab();
        ActionsUtils.pressArrowDown();
        ActionsUtils.pressEnter();
        ActionsUtils.pressTab();
        ActionsUtils.pressArrowDown();
        ActionsUtils.pressArrowDown();
        JSUtils.JSclickWithTimeout(storeManagerPage.SubmitButton);
        ReusableMethods.click(storeManagerPage.SubmitButton);
        ExtentReportsListener.extentTestInfo("Submit button a tiklanir");

        ReusableMethods.takeScreenShot();
        ExtentReportsListener.extentTestInfo("Screenshot alinir ve testin gecip gecmedigi gozlemlenir.");

        Driver.closeDriver();
    }
}



