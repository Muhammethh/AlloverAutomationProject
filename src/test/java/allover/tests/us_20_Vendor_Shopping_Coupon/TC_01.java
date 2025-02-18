package allover.tests.us_20_Vendor_Shopping_Coupon;

import allover.pages.*;
import allover.tests.SignInVendor;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 extends SignInVendor {
    @Test
    public void test01() throws InterruptedException {
        //Oluşturulan Coupon ile Vendor olarak alışveriş yapılabilmeli
        // 📌 **Test Konusu:** Oluşturulan kupon ile alışveriş yapılabilmeli.
        ExtentReportsListener.extentTestInfo("Test başladı: Kupon ile alışveriş yapılabilmeli.");

        // 1️⃣ **Ürünleri arama ve sepete ekleme işlemi**

        HomePage homePage = new HomePage();
        SampleItemsPage sampleItemsPage = new SampleItemsPage();
        Faker faker = new Faker();
        CartPage cartPage = new CartPage();
        homePage.searchBox.sendKeys("Book", Keys.ENTER);
        ActionsUtils.hoverOver(sampleItemsPage.firstItemAfterSearch);
        ReusableMethods.click(sampleItemsPage.addFirstItemInCart);
        ExtentReportsListener.extentTestInfo("Kitap sepete eklendi.");


        ActionsUtils.hoverOver(homePage.cartHead);
        homePage.cartHead.click();
        JSUtils.JSscrollIntoView(cartPage.ViewCartButton);
        ReusableMethods.waitForSecond(2);
        cartPage.ViewCartButton.click();
        ActionsUtils.scrollDown();
      JSUtils.JSscrollIntoView(cartPage.applyCouponButton);
      ReusableMethods.waitForSecond(5);
      cartPage.applyCouponButton.click();
      cartPage.couponTextBox.sendKeys("kupondeneme5");
//        // 4️⃣ **Checkout (ödeme) sayfasına git**
        JSUtils.JSscrollIntoView(cartPage.proceedToCheckoutButton);
        ReusableMethods.waitForSecond(2);
        cartPage.proceedToCheckoutButton.click();

        // 5️⃣ **Fatura Bilgilerini Doldurma**

        VendorAdressesPage vendorAdressesPage = new VendorAdressesPage();
        JSUtils.JSscrollIntoView(vendorAdressesPage.firstName);
        ReusableMethods.waitForSecond(2);
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
        vendorAdressesPage.townCity.sendKeys("Fairbanks");
        vendorAdressesPage.zipCode.clear();
        vendorAdressesPage.zipCode.clear();
        vendorAdressesPage.zipCode.sendKeys(faker.address().zipCode());
        ExtentReportsListener.extentTestInfo("ZIP Code kısmına geçerli veri girilir");

        //Phone kısmına geçerli veri girilir
        vendorAdressesPage.phone.clear();
        vendorAdressesPage.phone.sendKeys("05551234567");
        Thread.sleep(2000);
        vendorAdressesPage.email.clear();
        vendorAdressesPage.email.sendKeys("akifrencber.techproed@gmail.com");
        JSUtils.JSscrollIntoView(vendorAdressesPage.country);
        ReusableMethods.click(vendorAdressesPage.country);
        ActionsUtils.scrollDown();
        ReusableMethods.ddmValue(vendorAdressesPage.country,"US");
        CheckOutPage checkOutPage = new CheckOutPage();
        JSUtils.JSscrollIntoView(checkOutPage.placeOrderButton);
        ReusableMethods.waitForSecond(2);
        checkOutPage.placeOrderButton.click();
        JSUtils.JSscrollIntoView(checkOutPage.orderCompletedText);
        ReusableMethods.waitForSecond(2);
        Assert.assertTrue(checkOutPage.orderCompletedText.isDisplayed());
        ExtentReportsListener.extentTestPass("Kuponlu Sipariş başarıyla tamamlandı!");
        Driver.closeDriver();
    }
}
