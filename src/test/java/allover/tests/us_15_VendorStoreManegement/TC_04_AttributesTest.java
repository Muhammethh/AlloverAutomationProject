package allover.tests.us_15_VendorStoreManegement;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.pages.StoreManagerPage;
import allover.utilities.*;
import org.testng.annotations.Test;

public class TC_04_AttributesTest {
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

        JSUtils.JSclickWithTimeout(storeManagerPage.AttributesButton);
        ReusableMethods.click(storeManagerPage.AttributesButton);
        ExtentReportsListener.extentTestInfo("Attributes button a tiklanir.");

        JSUtils.JSclickWithTimeout(storeManagerPage.ColorButton);
        ReusableMethods.click(storeManagerPage.ColorButton);
        ExtentReportsListener.extentTestInfo("Color button a tiklanir.");

        storeManagerPage.ColorSearchBox.sendKeys("Red");
        ExtentReportsListener.extentTestInfo("Color search box a 'red' yazdirilir.");

        ActionsUtils.pressEnter();
        JSUtils.JSclickWithTimeout(storeManagerPage.ColorVisibleOnSearchBoxButton);
        storeManagerPage.ColorVisibleOnSearchBoxButton.click();
        ExtentReportsListener.extentTestInfo("Color visible on search box button a tiklanir");

        ReusableMethods.click(storeManagerPage.SizeButton);
        ExtentReportsListener.extentTestInfo("Size button a tiklanir.");

        JSUtils.JSclickWithTimeout(storeManagerPage.SizeSearchBox);
        ActionsUtils.pressArrowDown();
        ActionsUtils.pressArrowDown();
        ActionsUtils.pressEnter();
        ExtentReportsListener.extentTestInfo("Size search box dropdown ikinci secenek secilir.");

        ReusableMethods.click(storeManagerPage.SizeVisibleOnSearchBoxButton);
        ExtentReportsListener.extentTestInfo("Size visible on search box button a tiklanir");

        ReusableMethods.click(storeManagerPage.SubmitButton);
        ExtentReportsListener.extentTestInfo("Submit button a tiklanir");

        WaitUtils.waitFor(2);
        ReusableMethods.takeScreenShot();
        ExtentReportsListener.extentTestInfo("Screenshot alinir ve testin gecip gecmedigi gozlemlenir.");

        Driver.closeDriver();


  }
}



