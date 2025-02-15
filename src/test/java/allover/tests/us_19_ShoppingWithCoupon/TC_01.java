package allover.tests.us_19_ShoppingWithCoupon;

import allover.pages.CartPage;
import allover.pages.CheckOutPage;
import allover.pages.HomePage;
import allover.pages.SampleItemsPage;
import allover.tests.SignInCustomer;
import allover.utilities.ActionsUtils;
import allover.utilities.ReusableMethods;
import allover.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_01 {

    @Test
    public void shoppingWithCoupon() {

        HomePage homePage = new HomePage();
        SampleItemsPage sampleItemsPage = new SampleItemsPage();
        CartPage cartPage = new CartPage();
        CheckOutPage checkOutPage = new CheckOutPage();
        SoftAssert softAssert = new SoftAssert();

        SignInCustomer.SignIn();

        //Sign Out butonu görünene kadar beklenir ve göründüğü doğrulanır
        WaitUtils.waitForVisibility(homePage.signOut, 10);

        //Search Bara geçerli bir ürün ismi girilir
        homePage.searchBox.sendKeys("Masa", Keys.ENTER);

        //Çıkan ilk ürünün üzerine gelerek sepete ekle butonuna basılır
        ActionsUtils.hoverOver(sampleItemsPage.firstItemAfterSearch);

        ReusableMethods.click();

        ActionsUtils.hoverOver(homePage.cartHead);
        //Sepet simgesine basılarak küçük sepet penceresi açılır
        homePage.cartHead.click();

        //Sepet sayfasına gidilir
        cartPage.ViewCartButton.click();

        ActionsUtils.scrollDown();

        cartPage.couponTextBox.sendKeys("ALLITEMS");
        cartPage.applyCouponButton.click();

        String couponMessage = cartPage.couponAlertMessage.getText();

        softAssert.assertTrue(couponMessage.contains("applied"),"Kupon uygulanamadı");

        //Proceed to Checkout butonuna basılır
        ReusableMethods.click();


        ReusableMethods.click();


        softAssert.assertAll();



    }
}
