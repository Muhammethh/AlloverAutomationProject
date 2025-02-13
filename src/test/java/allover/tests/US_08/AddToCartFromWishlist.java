package allover.tests.US_08;

import allover.pages.CartPage;
import allover.pages.CheckOutPage;
import allover.pages.HomePage;
import allover.pages.WishlistPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartFromWishlist {

    @Test
    public void testAddToCartFromWishlist() throws InterruptedException{
        //Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportsListener.extentTestInfo("web sitesine gidildi");

        Thread.sleep(5000);

        //Bir urunu wishliste ekleme
        WishlistPage wishlistPage = new WishlistPage();
        wishlistPage.AddToWishlist.click();
        ExtentReportsListener.extentTestInfo("Urun wishliste eklendi");

        Thread.sleep(3000);

        //Wishlist page e gidilir ve eklenmis olan urunler goruntulenir
        HomePage homePage = new HomePage();
        homePage.whishlistHead.click();
        ExtentReportsListener.extentTestInfo("Wishlist butonuna tiklandi");

        Thread.sleep(3000);

        //Wishlistte goruntulenen urunleri sepete ekliyoruz
        wishlistPage.AddToCartButton.click();
        ExtentReportsListener.extentTestInfo("Wishlistte goruntulenen urunleri sepete ekliyoruz");

        //Wishlistten sepete eklenmis olan urunlerle checkout page e gidilir
        homePage.cartHead.click();
        Thread.sleep(2000);
        wishlistPage.WishlistCheckout.click();

        Thread.sleep(3000);

        //Checkout pagede oldugu dogrulanir
        CheckOutPage checkOutPage = new CheckOutPage();
        Assert.assertTrue(checkOutPage.placeOrderButton.isDisplayed(),"Urunun checkout pagede oldugu dogrulandi");
        ExtentReportsListener.extentTestInfo("Wishliste eklenen urun basariyla checkout page e yonlendirildi");



        Driver.closeDriver();


    }


}
