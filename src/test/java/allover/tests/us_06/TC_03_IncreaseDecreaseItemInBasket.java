package allover.tests.us_06;

import allover.pages.*;
import allover.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_03_IncreaseDecreaseItemInBasket {



    @Test
    public void TC_03_IncreaseDecreaseItemInBasket() {
        //Websiteye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        SampleItemsPage sampleItemsPage = new SampleItemsPage();
        CartPage cartPage = new CartPage();
        CheckOutPage checkOutPage = new CheckOutPage();

        //Sign In butonuna tıklanır
        homePage.signIn.click();

        //Username ve Password girilerek sign In butonuna basılır
        signInPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("email"));

        signInPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("password"));

        signInPage.SignInButton.click();

        //Sign Out butonu görünene kadar beklenir ve göründüğü doğrulanır
        WaitUtils.waitForVisibility(homePage.signOut, 10);

        Assert.assertTrue(homePage.signOut.isDisplayed());

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

        cartPage.increaseQuantityInCart.click();

        String increasedItem = cartPage.quantityofItem.getDomAttribute("value");

        Assert.assertEquals(increasedItem,"2");

        cartPage.decreaseQuantityInCart.click();

        String decreasedItem = cartPage.quantityofItem.getDomAttribute("value");

        Assert.assertEquals(decreasedItem,"1");
        System.out.println(decreasedItem);

    }


}
