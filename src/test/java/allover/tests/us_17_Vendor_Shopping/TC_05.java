package allover.tests.us_17_Vendor_Shopping;

import allover.pages.*;
import allover.tests.SignInVendor;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_05 extends SignInVendor {
    @Test
    public void testName() throws InterruptedException {

        //testin konusu
        //Place Order'a tıklanarak alışverişin tamamlandığı görülebilmeli
        HomePage homePage = new HomePage();
        SampleItemsPage sampleItemsPage = new SampleItemsPage();
        CartPage cartPage = new CartPage();
        homePage.searchBox.sendKeys("Book", Keys.ENTER);
        Faker faker = new Faker();
        ActionsUtils.hoverOver(sampleItemsPage.firstItemAfterSearch);
        ReusableMethods.click(sampleItemsPage.addFirstItemInCart);
        ExtentReportsListener.extentTestInfo("Kitap sepete eklendi.");

        ActionsUtils.hoverOver(homePage.cartHead);

        homePage.searchBox.sendKeys("Laptop", Keys.ENTER);
        ActionsUtils.hoverOver(sampleItemsPage.firstItemAfterSearch);
        ReusableMethods.click(sampleItemsPage.addFirstItemInCart);
        ExtentReportsListener.extentTestInfo("Laptop sepete eklendi.");
        // 2️⃣ **Sepete gitme işlemi**

        ActionsUtils.hoverOver(homePage.cartHead);

        homePage.cartHead.click();
        Thread.sleep(3000);
        cartPage.ViewCartButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(cartPage.firstItemInCart.isDisplayed());

        ActionsUtils.scrollDown();
        // 4️⃣ **Checkout (ödeme) sayfasına git**
        JSUtils.JSscrollIntoView(cartPage.proceedToCheckoutButton);
        ReusableMethods.waitForSecond(2);
        cartPage.proceedToCheckoutButton.click();

        // 5️⃣ **Fatura Bilgilerini Doldurma**

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
        checkOutPage.orderCompletedText.isDisplayed();
        ExtentReportsListener.extentTestPass("Sipariş başarıyla tamamlandı!");

        // 9️⃣ **Test tamamlandı, driver kapatıldı**
        Driver.closeDriver();
        ExtentReportsListener.extentTestPass("Test başarıyla tamamlandı.");

    }
}
