package allover.tests.US_08;

import allover.pages.HomePage;
import allover.pages.WishlistPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishlistQuickViewTest {


    @Test
    public void testQuickViewWishlist() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


        //  Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportsListener.extentTestInfo("Web sitesine gidildi.");


        // Bir urunu Wishliste ekleme
        WishlistPage wishlistPage = new WishlistPage();
        wait.until(ExpectedConditions.elementToBeClickable(wishlistPage.AddToWishlist)).click();
        ExtentReportsListener.extentTestInfo("Urun wishliste eklendi");


        //Wishlist page e gidilir ve eklenen urunler goruntulenir
        HomePage homePage = new HomePage();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.whishlistHead)).click();
        ExtentReportsListener.extentTestInfo("Wishlist butonuna tıklandı.");

        //  Quick View butonuna tıklanır
        wishlistPage.QuickView.click();
        ExtentReportsListener.extentTestInfo("Quick View butonuna tiklandi.");

        //  Quick View penceresinin acildigi dogrulanir
        Assert.assertTrue(wishlistPage.QuickView.isDisplayed(), "Quick View acilamadi");
        ExtentReportsListener.extentTestInfo("Quick Viewin basariyla acildigi dogrulandi");

        Driver.closeDriver();
    }
}
