package allover.tests.US_18_Coupon;

import allover.pages.*;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.JSUtils;
import allover.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class TC03 {
    @Test
    public void discountTypeTest() {
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
        ReusableMethods.click(couponPage.AddNewButton);
       // storeManagerPage.AddNewButton.click();


        couponPage.DropdownInput.click();
        couponPage.DropdownOption.click();


    }
}
