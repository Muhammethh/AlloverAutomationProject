package allover.tests.us_06_ShoppingTests;

import allover.pages.*;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_03 {



    @Test
    public void TC_03_IncreaseDecreaseItemInBasket() {


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

        Assert.assertTrue(homePage.signOut.isDisplayed());

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

        cartPage.increaseQuantityInCart.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement quantityInput = (WebElement) js.executeScript("return document.querySelector('input.input-text.qty.text');");

        String increasedItem = quantityInput.getDomAttribute("value");

        softAssert.assertEquals(increasedItem,"2");

        cartPage.decreaseQuantityInCart.click();

        String decreasedItem = quantityInput.getDomAttribute("value");

        softAssert.assertEquals(decreasedItem,"1");

        //Driver.closeDriver();

        softAssert.assertAll();

    }


}
