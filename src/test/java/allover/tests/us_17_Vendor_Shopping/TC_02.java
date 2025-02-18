package allover.tests.us_17_Vendor_Shopping;

import allover.pages.*;
import allover.tests.SignInVendor;
import allover.utilities.*;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.bson.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TC_02 extends SignInVendor{
    @FindBy(xpath = "//a[contains(text(),'View cart')]")
    public WebElement viewCartButton;
    @Test
    public void test02() throws InterruptedException {
        //testin konusu
        //Fatura ayrıntıları (BILLING DETAILS) doldurulabilmeli
        HomePage homePage = new HomePage();
        SampleItemsPage sampleItemsPage = new SampleItemsPage();
        CartPage cartPage = new CartPage();
        homePage.searchBox.sendKeys("Book", Keys.ENTER);
        ActionsUtils.hoverOver(sampleItemsPage.firstItemAfterSearch);
        ReusableMethods.click(sampleItemsPage.addFirstItemInCart);
        ExtentReportsListener.extentTestInfo("Kitap sepete eklendi.");
        ActionsUtils.hoverOver(homePage.cartHead);

        homePage.searchBox.sendKeys("Laptop", Keys.ENTER);
        ActionsUtils.hoverOver(sampleItemsPage.firstItemAfterSearch);
        ReusableMethods.click(sampleItemsPage.addFirstItemInCart);
        ExtentReportsListener.extentTestInfo("Laptop sepete eklendi.");
        ActionsUtils.hoverOver(homePage.cartHead);
        //**Sepete gitme işlemi**
        homePage.cartHead.click();
        Thread.sleep(3000);
        cartPage.ViewCartButton.click();
        Thread.sleep(3000);
        ExtentReportsListener.extentTestInfo("Sepet sayfasına gidildi.");

        Assert.assertTrue(cartPage.firstItemInCart.isDisplayed());
        ExtentReportsListener.extentTestPass("Ürünler sepete başarıyla eklendi.");

        ActionsUtils.scrollDown();
        JSUtils.JSscrollIntoView(cartPage.proceedToCheckoutButton);
        ReusableMethods.waitForSecond(2);
        cartPage.proceedToCheckoutButton.click();
        ExtentReportsListener.extentTestInfo("Checkout (Ödeme) sayfasına geçildi.");


        VendorAdressesPage vendorAdressesPage = new VendorAdressesPage();
        vendorAdressesPage.firstName.clear();
        vendorAdressesPage.firstName.sendKeys("Kaan");
        vendorAdressesPage.lastName.clear();
        vendorAdressesPage.lastName.sendKeys("AKSU");
        vendorAdressesPage.companyName.clear();
        vendorAdressesPage.companyName.sendKeys("techpro");
        vendorAdressesPage.streetAdress1.clear();
        vendorAdressesPage.streetAdress1.sendKeys("sokak ve cadde ismi");
        vendorAdressesPage.streetAdress2.clear();
        vendorAdressesPage.streetAdress2.sendKeys("bina ve apartman no");
        vendorAdressesPage.townCity.clear();
        vendorAdressesPage.townCity.sendKeys("Anselmo");
        vendorAdressesPage.zipCode.clear();
        vendorAdressesPage.zipCode.sendKeys("221211");
        vendorAdressesPage.email.clear();
        vendorAdressesPage.email.sendKeys("akifrencber.techproed@gmail.com");
        vendorAdressesPage.phone.clear();
        vendorAdressesPage.phone.sendKeys("111111111111");

        ExtentReportsListener.extentTestInfo("Fatura bilgileri başarıyla girildi.");


        JSUtils.JSscrollIntoView(vendorAdressesPage.country);
        ReusableMethods.click(vendorAdressesPage.country);
        ActionsUtils.scrollDown();
        ReusableMethods.ddmValue(vendorAdressesPage.country,"US");
        ExtentReportsListener.extentTestInfo("Ülke seçimi yapıldı.");

        // **Test tamamlandı, driver kapatıldı**

        Driver.closeDriver();
        ExtentReportsListener.extentTestPass("Test başarıyla tamamlandı.");

    }}

