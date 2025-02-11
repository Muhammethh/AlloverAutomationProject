package allover.tests.US_15;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.pages.StoreManagerPage;
import allover.utilities.ActionsUtils;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class TC_01_DisplayMenuTest {
    @Test
    public void displayMenuTest() throws InterruptedException {
        //Websiteye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        StoreManagerPage storeManagerPage = new StoreManagerPage();

        homePage.signIn.click();

        signInPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("vendorEmail"));

        signInPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("vendorPassword"));

        signInPage.SignInButton.click();
        ReusableMethods.waitForSecond(2);

        ReusableMethods.scroll(homePage.myAccount);

        homePage.myAccount.click();
        ReusableMethods.visibleWait(storeManagerPage.Products,5);


        storeManagerPage.Products.click();
        ReusableMethods.visibleWait(homePage.myAccount,5);

        Driver.closeDriver();

    }
}



