package allover.tests.US_18_Coupon;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.pages.StoreManagerPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.JSUtils;
import allover.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class TC01 {
    @Test
    public void codeTest(){
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        StoreManagerPage storeManagerPage = new StoreManagerPage();

        homePage.signIn.click();

        signInPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("vendorEmail"));

        signInPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("vendorPassword"));

        signInPage.SignInButton.click();
       // ReusableMethods.scroll(homePage.myAccount);
        ReusableMethods.scroll(homePage.myAccount);
        ReusableMethods.visibleWait(homePage.myAccount,5);
        homePage.myAccount.click();
        myAccountPage.StoreManagerButton.click();
        ReusableMethods.scroll(storeManagerPage.CouponButton);
        JSUtils.JSclickWithTimeout(storeManagerPage.CouponButton);
        storeManagerPage.CouponButton.click();


    }
}
