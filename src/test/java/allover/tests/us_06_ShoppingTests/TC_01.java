package allover.tests.us_06_ShoppingTests;

import allover.pages.*;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 {




    @Test(description = "US_06 TC-01 Geçerli datalar ile kullanıcı alışveriş yapabilmelidir")
    public void TC_01_ShoppingTest1() {

        HomePage homePage = new HomePage();
        SampleItemsPage sampleItemsPage = new SampleItemsPage();
        CartPage cartPage = new CartPage();
        CheckOutPage checkOutPage = new CheckOutPage();

        //SignIn Classından signIn metodu çağrılarak giriş yapılır
        SignInCustomer.SignIn();

        //Sign Out butonu görünene kadar beklenir ve göründüğü doğrulanır
        WaitUtils.waitForVisibility(homePage.signOut, 10);

        Assert.assertTrue(homePage.signOut.isDisplayed());

        //Search Bara geçerli bir ürün ismi girilir
        homePage.searchBox.sendKeys("Kazak", Keys.ENTER);

        //Çıkan ilk ürünün üzerine gelerek sepete ekle butonuna basılır
        ActionsUtils.hoverOver(sampleItemsPage.firstItemAfterSearch);


        sampleItemsPage.addFirstItemInCart.click();

        ActionsUtils.hoverOver(homePage.cartHead);
        //Sepet simgesine basılarak küçük sepet penceresi açılır
        homePage.cartHead.click();

        //Sepet sayfasına gidilir
        cartPage.ViewCartButton.click();

        //Proceed to Checkout butonuna basılır
        cartPage.proceedToCheckoutButton.click();

        ReusableMethods.visibleWait(checkOutPage.placeOrderButton,5);
        //Place Order butonuna basılır
        ReusableMethods.scroll(checkOutPage.placeOrderButton);

        ReusableMethods.click(checkOutPage.placeOrderButton);


        //Siparişin başarılı olduğu doğrulanır
        Assert.assertTrue(checkOutPage.orderCompletedText.isDisplayed());

        Driver.closeDriver();

    }
}
