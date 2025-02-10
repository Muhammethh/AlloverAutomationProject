package allover.tests.us_06;

import allover.pages.HomePage;
import allover.pages.SampleItemsPage;
import allover.pages.SignInPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02_InvalidSearch {

    @Test
    public void TC_02_InvalidSearch1() {

        //Websiteye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        SampleItemsPage sampleItemsPage = new SampleItemsPage();

        //Sign In butonuna tıklanır
        homePage.signIn.click();

        //Username ve Password girilerek sign In butonuna basılır
        signInPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("email"));

        signInPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("password"));

        signInPage.SignInButton.click();

        //Sign Out butonu görünene kadar beklenir ve göründüğü doğrulanır
        WaitUtils.waitForVisibility(homePage.signOut, 10);

        Assert.assertTrue(homePage.signOut.isDisplayed());

        //Search Bara geçersiz bir ürün ismi girilir
        homePage.searchBox.sendKeys("nnnn", Keys.ENTER);

        //Ürün çıkmadığı doğrulanır
        Assert.assertTrue(sampleItemsPage.noProductWereFoundWriting.isDisplayed());

        Driver.closeDriver();


    }
}
