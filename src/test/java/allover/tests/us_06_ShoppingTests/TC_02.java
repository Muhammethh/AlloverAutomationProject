package allover.tests.us_06_ShoppingTests;

import allover.pages.HomePage;
import allover.pages.SampleItemsPage;
import allover.pages.SignInPage;
import allover.tests.SignInCustomer;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import allover.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02 {

    @Test
    public void TC_02_InvalidSearch1() {

        HomePage homePage = new HomePage();
        SampleItemsPage sampleItemsPage = new SampleItemsPage();

        ExtentReportsListener.extentTestInfo("SignIn Classından signIn metodu çağrılarak giriş yapılır");


        SignInPage signIn = new SignInPage();
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        homePage.signIn.click();
        signIn.UsernameTextBox.sendKeys(ConfigReader.getProperty("signInUserName"));
        signIn.PasswordTextBox.sendKeys(ConfigReader.getProperty("signInPassword"));
        signIn.SignInButton.click();

        ExtentReportsListener.extentTestInfo("Sign Out butonu görünene kadar beklenir ve göründüğü doğrulanır");
        //Sign Out butonu görünene kadar beklenir ve göründüğü doğrulanır
        WaitUtils.waitForVisibility(homePage.signOut, 10);

        Assert.assertTrue(homePage.signOut.isDisplayed());

        //Search Bara geçersiz bir ürün ismi girilir
        ExtentReportsListener.extentTestInfo("Search Bara geçersiz bir ürün ismi girilir");
        homePage.searchBox.sendKeys("nnnn", Keys.ENTER);

        //Ürün çıkmadığı doğrulanır
        ExtentReportsListener.extentTestInfo("Ürün çıkmadığı doğrulanır");
        Assert.assertTrue(sampleItemsPage.noProductWereFoundWriting.isDisplayed());

        Driver.closeDriver();


    }
}
