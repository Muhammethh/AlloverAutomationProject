package allover.tests.US_16;

import allover.pages.*;
import allover.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_06_Ürünün_Eklendi {

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

        VendorAddProuctPage vendorAddProuct = new VendorAddProuctPage();
        vendorAddProuct.SimpleProduct.click();
        Assert.assertTrue(vendorAddProuct.SimpleProduct.isDisplayed(), "Simple Product is not displayed!");

        vendorAddProuct.ProductTitle.sendKeys(ConfigReader.getProperty("productTittle"));

        vendorAddProuct.PriceVendor.sendKeys(ConfigReader.getProperty("PriceVendor"));
        //ReusableMethods.waitForSecond(2);

        vendorAddProuct.SalePriceVendor.sendKeys(ConfigReader.getProperty("SalePriceVendor"));
        vendorAddProuct.ChooseImage.click();
        ReusableMethods.waitForSecond(2);

        vendorAddProuct.MediaLibrary.click();
        ReusableMethods.waitForSecond(4);

        JSUtils.JSclickWithTimeout(vendorAddProuct.TshirtFoto);

        vendorAddProuct.SelecVendorFoto.click();
        ReusableMethods.waitForSecond(4);
        ActionsUtils.scrollDown();
        ReusableMethods.waitForSecond(2);
        vendorAddProuct.AddtoGalaleryVendor.click();
        ReusableMethods.waitForSecond(4);
        JSUtils.JSclickWithTimeout(vendorAddProuct.TshirtFoto2);
        vendorAddProuct.AddtoGallery.click();

        vendorAddProuct.Categories123.click();
        vendorAddProuct.Productbrands001.click();


        ReusableMethods.waitForSecond(2);
        vendorAddProuct.ShortDescription.click();


        ReusableMethods.scrollEnd();

        ReusableMethods.waitForSecond(2);

        vendorAddProuct.SubmitAddProduct.click();

        ReusableMethods.waitForSecond(2);


    }

    }


