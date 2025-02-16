package allover.tests.US_18_Coupon;

import allover.pages.*;
import allover.utilities.*;
import org.testng.annotations.Test;

public class TC01 {
    @Test
    public void codeTest() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        StoreManagerPage storeManagerPage = new StoreManagerPage();
        CouponPage couponPage=new CouponPage();
        homePage.signIn.click();

        signInPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("vendorEmail"));

        signInPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("vendorPassword"));

        signInPage.SignInButton.click();
        // ReusableMethods.scroll(homePage.myAccount);
        ReusableMethods.scroll(homePage.myAccount);
        ReusableMethods.visibleWait(homePage.myAccount, 5);
        homePage.myAccount.click();
        myAccountPage.StoreManagerButton.click();

        ReusableMethods.scroll(couponPage.CouponButton);
        JSUtils.JSclickWithTimeout(couponPage.CouponButton);
        couponPage.CouponButton.click();

       // ReusableMethods.scroll(couponPage.AddNewButton);
        ActionsUtils.scrollDown();
       // couponPage.AddNewButton.click();
        JSUtils.JSclickWithTimeout(couponPage.AddNewButton);
        couponPage.AddNewButton.click();
        couponPage.CodeTextBox.sendKeys("KPTech");

    }
}
