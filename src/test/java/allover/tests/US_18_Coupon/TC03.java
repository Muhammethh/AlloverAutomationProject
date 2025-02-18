package allover.tests.US_18_Coupon;

import allover.pages.*;
import allover.utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
        couponPage.dropdown.click();
        ExtentReportsListener.extentTestInfo("DiscountType DropDown a tıklar");
       // ReusableMethods.ddmValue(couponPage.dropdown,"percent");
        //ReusableMethods.ddmValue(couponPage.dropdown,"fixed_product");

        ActionsUtils.pressArrowDown();
        ActionsUtils.pressEnter();

        JSUtils.JSclickWithTimeout(couponPage.SubmitButton);

        Assert.assertTrue(couponPage.dropdown.isDisplayed());
        ExtentReportsListener.extentTestPass("Submit Butonuna tıklanarak DiscountType DropDown da secim yapilabildigi dogrulanir");


        Driver.closeDriver();

//        WebElement dropdown = null;
//        Select selectdiscount= new Select(dropdown);
//
//        List<WebElement> discount=selectdiscount.getOptions();
//        for (WebElement w:discount){
//            w.click();
//        }
//
//        //selectdiscount.selectByValue("fixed_product");

    }
}
