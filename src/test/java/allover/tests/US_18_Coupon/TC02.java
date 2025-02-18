package allover.tests.US_18_Coupon;

import allover.pages.*;
import allover.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 {
    @Test
    public void descriptionTest() {
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
        ExtentReportsListener.extentTestInfo("StoreManger Butonuna tıklar");


        ReusableMethods.scroll(couponPage.CouponButton);
        JSUtils.JSclickWithTimeout(couponPage.CouponButton);
        ExtentReportsListener.extentTestInfo("Coupon Butonuna tıklar");
        //couponPage.CouponButton.click();


        //couponPage.AddNewButton.click();
        //JSUtils.JSclickWithTimeout(couponPage.AddNewButton);
        ReusableMethods.click(couponPage.AddNewButton);
        ExtentReportsListener.extentTestInfo("AddNew Butonuna tıklar");

        couponPage.DescriptionTextArea.sendKeys("urun aciklaması");
        ExtentReportsListener.extentTestInfo("Description TextArea a description yazabilmeliyim ");
        JSUtils.JSclickWithTimeout(couponPage.SubmitButton);

        Assert.assertTrue(couponPage.DescriptionTextArea.isDisplayed());
        ExtentReportsListener.extentTestPass("Submit Butonuna tıklanarak desciription un yazildigi dogrulanir");


        Driver.closeDriver();
    }
}
