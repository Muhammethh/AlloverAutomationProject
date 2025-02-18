package allover.tests.US_08_WishListPage;

import allover.pages.HomePage;
import allover.pages.WishlistPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckWishlist {


    @Test
    public void testQuickViewWishlist() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


        //  Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportsListener.extentTestInfo("Web sitesine gidildi.");

        Thread.sleep(5000);

        // Bir urunu Wishliste ekleme
        WishlistPage wishlistPage = new WishlistPage();
        wishlistPage.AddToWishlist.click();
        ExtentReportsListener.extentTestInfo("Urun wishliste eklendi");

        Thread.sleep(3000);


        //Wishlist page e gidilir ve eklenen urunler goruntulenir
        HomePage homePage = new HomePage();
        homePage.whishlistHead.click();
        ExtentReportsListener.extentTestInfo("Wishlist butonuna tiklandi");

        Thread.sleep(3000);


//      Wishliste eklenen urunleri dogruluyoruz
        Assert.assertTrue(wishlistPage.RemoveFromWishlistButton.isDisplayed(), "Ürün Wishlist'e eklenmedi!");
        ExtentReportsListener.extentTestInfo("Wishlist'teki ürün başarıyla doğrulandı.");



        Driver.closeDriver();
    }
}