package allover.tests.us_06_ShoppingTests;

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

public class TC_05 {

    @Test
    public void TC_05_ChangingPaymentMethod() {

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

        ReusableMethods.click(sampleItemsPage.addFirstItemInCart);

        ActionsUtils.hoverOver(homePage.cartHead);
        //Sepet simgesine basılarak küçük sepet penceresi açılır
        homePage.cartHead.click();

        //Sepet sayfasına gidilir
        cartPage.ViewCartButton.click();

        //Proceed to Checkout butonuna basılır
        ReusableMethods.click(cartPage.proceedToCheckoutButton);


        ActionsUtils.scrollDown();

        WaitUtils.waitForClickablility(checkOutPage.payAtDoorSelect,10);

        if (!checkOutPage.wireTransferEftSelect.isSelected()) {
            checkOutPage.wireTransferEftSelect.click();
            softAssert.assertTrue(checkOutPage.wireTransferEftSelect.isSelected(), "Wire transfer hatalı");
        }

        if (!checkOutPage.payAtDoorSelect.isSelected()) {
            WaitUtils.waitForClickablility(checkOutPage.payAtDoorSelect,10);
            ReusableMethods.click(checkOutPage.payAtDoorSelect);
            softAssert.assertTrue(checkOutPage.payAtDoorSelect.isSelected(),"Pay at the door hatalı");
        }

        if (!checkOutPage.wireTransferEftSelect.isSelected()) {
            checkOutPage.wireTransferEftSelect.click();
            softAssert.assertTrue(checkOutPage.wireTransferEftSelect.isSelected(),"Wire transfer hatalı");
        }

        softAssert.assertAll();

    }
}
