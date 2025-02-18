package allover.tests.US_08_WishListPage;

import allover.pages.CheckOutPage;
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

public class AddToCartFromWishlist {

    @Test
    public void testAddToCartFromWishlist() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //  Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportsListener.extentTestInfo("Web sitesine gidildi.");
        Thread.sleep(3000);



        // Bir urunu Wishliste ekleme
        WishlistPage wishlistPage = new WishlistPage();
        wishlistPage.AddToWishlist.click();
        ExtentReportsListener.extentTestInfo("Urun wishliste eklendi");

        Thread.sleep(3000);


        //Wishlist page e gidilir ve eklenen urunler goruntulenir
        HomePage homePage = new HomePage();
        homePage.whishlistHead.click();
//        wait.until(ExpectedConditions.elementToBeClickable(homePage.whishlistHead)).click();
        ExtentReportsListener.extentTestInfo("Wishlist butonuna tıklandı.");


        //Wishlistte goruntulenen urunleri sepete ekliyoruz
        wait.until(ExpectedConditions.elementToBeClickable(wishlistPage.AddToCartButton)).click();
        ExtentReportsListener.extentTestInfo("Wishlistte goruntulenen urunleri sepete ekliyoruz");

        //Wishlistten sepete eklenmis olan urunlerle checkout page e gidilir
        homePage.cartHead.click();
        wait.until(ExpectedConditions.elementToBeClickable(wishlistPage.WishlistCheckout)).click();
        ExtentReportsListener.extentTestInfo("Wishlistten sepete eklenmis olan urunlerle checkout page e gidilir");


        //Checkout pagede oldugu dogrulanir
        CheckOutPage checkOutPage = new CheckOutPage();
        Assert.assertTrue(checkOutPage.placeOrderButton.isDisplayed(),"Urunun checkout pagede oldugu dogrulandi");
        ExtentReportsListener.extentTestInfo("Wishliste eklenen urun basariyla checkout page e yonlendirildi");



        Driver.closeDriver();


    }


}
