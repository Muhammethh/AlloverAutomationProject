package allover.tests.US_14_AddNewPoduct;

import allover.pages.MyAccountPage;
import allover.pages.StoreManagerPage;
import allover.pages.VendorAddProuctPage;
import allover.tests.SignInVendor;
import allover.utilities.ActionsUtils;
import allover.utilities.ConfigReader;
import allover.utilities.JSUtils;
import allover.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.Utilities;

public class TC_01AddNewProduct extends SignInVendor {
    @Test
    public void test01() {

        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.StoreManagerButton.click();

        StoreManagerPage storeManagerPage = new StoreManagerPage();
        ActionsUtils.hoverOver(storeManagerPage.ProductsButton);

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
