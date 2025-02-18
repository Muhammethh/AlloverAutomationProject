package allover.tests.US_16;

<<<<<<< HEAD
import allover.pages.*;
=======
import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.pages.StoreManagerPage;
>>>>>>> master
import allover.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TC_01_Product_Default {

    WebElement driver;
    @Test
    public void productDefalt() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        StoreManagerPage storeManagerPage = new StoreManagerPage();

        homePage.signIn.click();

        signInPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("vendorEmail"));

        signInPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("vendorPassword"));

        signInPage.SignInButton.click();
        WaitUtils.waitFor(2);
        ActionsUtils.scrollDown();
<<<<<<< HEAD

=======
        //    My account a tiklanir
>>>>>>> master
        ReusableMethods.scrollEnd();
        ReusableMethods.waitForSecond(2);
        homePage.myAccount.click();

//        ReusableMethods.scroll(homePage.myAccount);
//        ReusableMethods.scroll(homePage.myAccount);
//        ReusableMethods.scrollEnd();
//        ReusableMethods.visibleWait(homePage.myAccount, 5);
//         homePage.myAccount.click();
       // homePage.myAccount.click();

        myAccountPage.StoreManagerButton.click();

        ReusableMethods.scroll(storeManagerPage.ProductsButton);
        ReusableMethods.visibleWait(storeManagerPage.ProductsButton, 5);
        storeManagerPage.ProductsButton.click();


        ActionsUtils.scrollRight();
        storeManagerPage.AddNew.click();
        ReusableMethods.waitForSecond(3);

        VendorAddProuctPage vendorAddProuct = new VendorAddProuctPage();
        vendorAddProuct.SimpleProduct.click();
        Assert.assertTrue(vendorAddProuct.SimpleProduct.isDisplayed(), "Simple Product is not displayed!");



    }
}
