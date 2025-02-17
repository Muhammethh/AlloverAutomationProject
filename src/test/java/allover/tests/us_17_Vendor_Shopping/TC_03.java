package allover.tests.us_17_Vendor_Shopping;

import allover.pages.CartPage;
import allover.pages.HomePage;
import allover.pages.SampleItemsPage;
import allover.tests.SignInVendor;
import allover.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_03 extends SignInVendor {
    @Test
    public void test03() throws InterruptedException {
        // 📌 **Test Konusu:** Sepette toplam ödenecek rakamın görüntülenebilmesi
        ExtentReportsListener.extentTestInfo("Test başladı: Sepet toplam tutarı görüntülenmeli.");
        // 1️⃣ **Ürünleri arama ve sepete ekleme işlemi**
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
        // 2️⃣ **Sepete gitme işlemi**
        ActionsUtils.hoverOver(homePage.cartHead);

        homePage.cartHead.click();
        ReusableMethods.waitForSecond(2);
        cartPage.ViewCartButton.click();
        ReusableMethods.waitForSecond(2);
        // 3️⃣ **Sepette toplam fiyatın görüntülendiğini doğrula**

        JSUtils.JSscrollIntoView(cartPage.totalverify);

        //toplam ödenecek rakam göüntülenebilmeli
   Assert.assertTrue(cartPage.totalverify.isDisplayed());
   ExtentReportsListener.extentTestPass("Toplam ödenecek tutar başarıyla görüntülendi.");

        Driver.closeDriver();
        ExtentReportsListener.extentTestPass("Test başarıyla tamamlandı.");
    }
}
