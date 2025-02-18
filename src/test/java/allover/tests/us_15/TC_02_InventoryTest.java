package allover.tests.us_15;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.pages.StoreManagerPage;
import allover.utilities.*;
import org.testng.annotations.Test;

public class TC_02_InventoryTest {
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

        JSUtils.JSclickWithTimeout(storeManagerPage.InventoryButton);
        storeManagerPage.InventoryButton.click();
        ActionsUtils.pressTab();
        ActionsUtils.pressTab();
        JSUtils.JSclickWithTimeout(storeManagerPage.ManageStockCheckBox);
        ReusableMethods.click(storeManagerPage.ManageStockCheckBox);
        ActionsUtils.pressTab();
        storeManagerPage.StockQtyTextBox.sendKeys("2");
        ActionsUtils.pressTab();
        storeManagerPage.AllowBackorders.click();

        ReusableMethods.ddmValue(storeManagerPage.AllowBackorders,"notify");
        ReusableMethods.click(storeManagerPage.SoldIndividually);
        storeManagerPage.SubmitButton.click();
        WaitUtils.waitFor(3);
        ReusableMethods.takeScreenShot();

        Driver.closeDriver();

    }
}



