package allover.tests.US_16;

import allover.pages.*;
import allover.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_05_Kategori {

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

        ReusableMethods.scrollEnd();
        ReusableMethods.waitForSecond(2);
        homePage.myAccount.click();

        myAccountPage.StoreManagerButton.click();

        ReusableMethods.scroll(storeManagerPage.ProductsButton);
        ReusableMethods.visibleWait(storeManagerPage.ProductsButton, 5);
        storeManagerPage.ProductsButton.click();


        ActionsUtils.scrollRight();
        storeManagerPage.AddNew.click();
        ReusableMethods.waitForSecond(3);

        AddProduct vendorAddProuct = new AddProduct();
        vendorAddProuct.Categories123.click();
        vendorAddProuct.Productbrands001.click();

    }
}
