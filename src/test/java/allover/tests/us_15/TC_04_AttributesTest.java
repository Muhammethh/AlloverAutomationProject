package allover.tests.us_15;

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

        JSUtils.JSclickWithTimeout(storeManagerPage.AttributesButton);
        ReusableMethods.click(storeManagerPage.AttributesButton);
        JSUtils.JSclickWithTimeout(storeManagerPage.ColorButton);
        storeManagerPage.ColorButton.click();
//      storeManagerPage.ColorSearchBox.click();

        storeManagerPage.ColorSearchBox.sendKeys("Red");
        ActionsUtils.pressEnter();
        JSUtils.JSclickWithTimeout(storeManagerPage.ColorVisibleOnSearchBoxButton);
        storeManagerPage.ColorVisibleOnSearchBoxButton.click();
        ReusableMethods.click(storeManagerPage.SizeButton);
        storeManagerPage.SizeSearchBox.sendKeys("100x100x200");

//        ActionsUtils.pressArrowDown();
//        ActionsUtils.pressArrowDown();
//        ActionsUtils.pressArrowDown();
//        ActionsUtils.pressEnter();


//        storeManagerPage.ManageStockCheckBox.click();
//        ActionsUtils.pressTab();
//        storeManagerPage.StockQtyTextBox.sendKeys("3");
//        ActionsUtils.pressTab();
//        storeManagerPage.AllowBackorders.click();
//
//        ReusableMethods.ddmValue(storeManagerPage.AllowBackorders,"Allow");
//        storeManagerPage.SoldIndividually.click();
//        storeManagerPage.SubmitButton.click();
//        ReusableMethods.alertWait(5);







//Driver.closeDriver();

    }
}



