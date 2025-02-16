package allover.tests.us_06_ShoppingTests;

import allover.pages.*;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_04 {

    @Test
    public void TC_04_IsBillingDetailVisible() {

        HomePage homePage = new HomePage();
        SampleItemsPage sampleItemsPage = new SampleItemsPage();
        CartPage cartPage = new CartPage();
        CheckOutPage checkOutPage = new CheckOutPage();
        SoftAssert softAssert = new SoftAssert();

        //SignInCustomer.SignIn();
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


        ReusableMethods.visibleWait(checkOutPage.placeOrderButton, 5);

        softAssert.assertFalse(checkOutPage.firstNameTextBox.getDomAttribute("value").isEmpty(),"firstName kısmında hata alındı");

        softAssert.assertFalse(checkOutPage.lastNameTextBox.getDomAttribute("value").isEmpty(),"lastName kısmında hata alındı");

        softAssert.assertFalse(checkOutPage.countryRegionDropDown.getText().isEmpty(),"countryRegion kısmında hata alındı");

        ReusableMethods.scroll(checkOutPage.streetAddressTextBox);

        softAssert.assertFalse(checkOutPage.streetAddressTextBox.getDomAttribute("value").isEmpty(),"streetAddressTextBox kısmında hata alındı");

        ReusableMethods.scroll(checkOutPage.cityTextBox);

        softAssert.assertFalse(checkOutPage.cityTextBox.getDomAttribute("value").isEmpty(),"cityTextBox kısmında hata alındı");

        softAssert.assertFalse(checkOutPage.stateDropDown.getText().isEmpty(),"stateDropDown kısmında hata alındı");

        ReusableMethods.scroll(checkOutPage.zipCodeTextBox);

        softAssert.assertFalse(checkOutPage.zipCodeTextBox.getDomAttribute("value").isEmpty(),"zipCodeTextBox kısmında hata alındı");

        softAssert.assertFalse(checkOutPage.phoneTextBox.getDomAttribute("value").isEmpty(),"phoneTextBox kısmında hata alındı");

        ReusableMethods.scroll(checkOutPage.emailTextBox);

        softAssert.assertFalse(checkOutPage.emailTextBox.getDomAttribute("value").isEmpty(),"emailTextBox kısmında hata alındı");

        softAssert.assertAll();

        //Driver.closeDriver();

    }
}
