package allover.tests.us_17_Vendor_Shopping;

import allover.pages.CartPage;
import allover.pages.MyAccountPage;
import allover.tests.SignInVendor;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import allover.utilities.JSUtils;
import allover.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_06 extends SignInVendor {

    @Test
    public void testName() {
        CartPage cartPage = new CartPage();

        // 📌 **Test Konusu:** Sipariş detaylarının görüntülenebilmesi.
        // 1️⃣ **My Account sayfasında "Orders" butonuna tıklama**

        MyAccountPage myAccountPage = new MyAccountPage();
        JSUtils.JSscrollIntoView(myAccountPage.OrdersButton);
        ReusableMethods.waitForSecond(2);
        myAccountPage.OrdersButton.click();
        ExtentReportsListener.extentTestInfo("Orders (Siparişler) sayfasına gidildi.");
        // 2️⃣ **İlk siparişin "View" butonuna tıklama**

        JSUtils.JSscrollIntoView(myAccountPage.ViewButton);
        ReusableMethods.waitForSecond(2);
        myAccountPage.ViewButton.click();
        // 3️⃣ **Sipariş detaylarının görüntülendiğini doğrula**

        JSUtils.JSscrollIntoView(cartPage.orderdetails);
        ReusableMethods.waitForSecond(2);
        Assert.assertTrue(cartPage.orderdetails.isDisplayed());
        ExtentReportsListener.extentTestPass("Sipariş detayları başarıyla görüntülendi.");
        // 4️⃣ **Test tamamlandı**
        Driver.closeDriver();
        ExtentReportsListener.extentTestPass("Test başarıyla tamamlandı.");





    }
}
