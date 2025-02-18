package allover.tests.us_06_ShoppingTests;

import allover.pages.*;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_05{

    @Test
    public void TC_05_ChangingPaymentMethod() {

        HomePage homePage = new HomePage();
        SampleItemsPage sampleItemsPage = new SampleItemsPage();
        CartPage cartPage = new CartPage();
        CheckOutPage checkOutPage = new CheckOutPage();
        SoftAssert softAssert = new SoftAssert();


       SignInPage signIn=new SignInPage();
       Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
       homePage.signIn.click();
       signIn.UsernameTextBox.sendKeys(ConfigReader.getProperty("signInUserName"));
       signIn.PasswordTextBox.sendKeys(ConfigReader.getProperty("signInPassword"));
       signIn.SignInButton.click();

        //Sign Out butonu görünene kadar beklenir ve göründüğü doğrulanır
        WaitUtils.waitForVisibility(homePage.signOut, 10);

        //Search Bara geçerli bir ürün ismi girilir
        homePage.searchBox.sendKeys("Masa", Keys.ENTER);

        //Çıkan ilk ürünün üzerine gelerek sepete ekle butonuna basılır
        WaitUtils.waitForVisibility(sampleItemsPage.firstItemAfterSearch,10);
        ActionsUtils.hoverOver(sampleItemsPage.firstItemAfterSearch);

        WaitUtils.waitForVisibility(sampleItemsPage.addFirstItemInCart,10);
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
            ReusableMethods.click(checkOutPage.wireTransferEftSelect);
            softAssert.assertTrue(checkOutPage.wireTransferEftSelect.isSelected(),"Wire transfer hatalı");
        }

        softAssert.assertAll();
        Driver.closeDriver();

    }
}
