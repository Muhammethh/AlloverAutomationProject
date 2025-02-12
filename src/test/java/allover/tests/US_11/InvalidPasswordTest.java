package allover.tests.US_11;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InvalidPasswordTest {

    @Test (description = "US-11 TC-03 Gecersiz password ile Sign in yapılamamali (Negative case)")
    public void invalidPasswordTest() {

        //Vendor sign-in sayfasina gilidir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportsListener.extentTestInfo("allovercommerce anasayfasnia gidilir");

        //Sign-in linkine tıklanır

        HomePage homePage = new HomePage();
        homePage.signIn.click();
        ExtentReportsListener.extentTestInfo("Sign-in butonuna tiklanir");

        //Email kısmına geçerli veri girilir
        SignInPage signInPage = new SignInPage();
        signInPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        ExtentReportsListener.extentTestInfo("Gecerli email adresi girilir");


        //Password kısmına geçersiz veri girilir
        signInPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("invalidPassword"));
        ExtentReportsListener.extentTestInfo("Gecersiz vendor password girilir");

        //Sign-in butonuna tıklanır
        signInPage.SignInButton.click();
        ExtentReportsListener.extentTestInfo("Sign-in butonuna tiklanir");


        //Sign-in olunamadığı doğrulanır

        MyAccountPage myAccountPage = new MyAccountPage();
        Assert.assertTrue(myAccountPage.WrongUsernamePasswordWarning.isDisplayed());
        ExtentReportsListener.extentTestInfo("Gecersiz password ile giris yapilamadigi dogrulanir");

        Driver.closeDriver();


    }
}


