package allover.tests.US_18_Coupon;

import allover.pages.*;
import allover.utilities.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 {
    @Test
    public void ExpirydateTextBoxTest() {
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


        ActionsUtils.scrollDown();
        couponPage.ExpirydateTextBox.click();
        couponPage.ExpirydateTextBox.sendKeys("2025-02-20");
        ExtentReportsListener.extentTestInfo("Expirydate date yazabilmeli");
        JSUtils.JSclickWithTimeout(couponPage.SubmitButton);

        Assert.assertTrue(couponPage.ExpirydateTextBox.isDisplayed());
        ExtentReportsListener.extentTestPass("Submit Butonuna tıklanarak Expirydate date yazabildigi dogrulanir");


        Driver.closeDriver();

    }
}
