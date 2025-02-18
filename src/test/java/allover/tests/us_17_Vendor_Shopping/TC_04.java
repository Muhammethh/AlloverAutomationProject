package allover.tests.us_17_Vendor_Shopping;

import allover.pages.CartPage;
import allover.pages.HomePage;
import allover.pages.SampleItemsPage;
import allover.tests.SignInVendor;
import allover.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_04 extends SignInVendor {
    @Test
    public void test04() throws InterruptedException {
        //testin konusu
        //Wire transfer/EFT veya Pay at the door seçenekleri seçilebilmeli
        // 📌 **Test Konusu:** Wire transfer/EFT veya Pay at the door seçenekleri seçilebilmeli.
        ExtentReportsListener.extentTestInfo("Test başladı: Ödeme yöntemleri seçimi.");
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
        Thread.sleep(3000);
        cartPage.ViewCartButton.click();
        Thread.sleep(3000);
        ExtentReportsListener.extentTestInfo("Sepet sayfasına gidildi.");

        ActionsUtils.scrollDown();
        JSUtils.JSscrollIntoView(cartPage.proceedToCheckoutButton);
        ReusableMethods.waitForSecond(2);
        cartPage.proceedToCheckoutButton.click();
        ExtentReportsListener.extentTestInfo("Checkout (Ödeme) sayfasına geçildi.");
        // 4️⃣ **Wire Transfer / EFT Seçeneğini Kontrol Et**

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement radioButton = Driver.getDriver().findElement(By.cssSelector("input.input-radio[value='bacs']"));

// Radyo butonunun seçili olup olmadığını JavaScript ile kontrol et
        boolean isChecked = (Boolean) js.executeScript("return arguments[0].checked;", radioButton);

        // Seçili olduğunu doğrula
        Assert.assertTrue(isChecked, "Radyo butonu seçili değil!");

        ExtentReportsListener.extentTestPass("Wire transfer/EFT seçeneği başarıyla doğrulandı.");


        // 5️⃣ **Kapıda Ödeme (Pay at the door) Seçeneğini Seçme**

        JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
        WebElement paymentOption = Driver.getDriver().findElement(By.id("payment_method_cod"));
        js2.executeScript("arguments[0].click();", paymentOption);

        // 6️⃣ **Test tamamlandı, driver kapatıldı**
        Driver.closeDriver();
        ExtentReportsListener.extentTestPass("Test başarıyla tamamlandı.");
    }
}
