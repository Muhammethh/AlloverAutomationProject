package allover.tests.US_11;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class InvalidPasswordTest {

    @Test (description = "US-11 TC-03 Password yanlış girildiğinde sisteme giriş yapilamamali (Negative Case)")
    public void invalidPasswordTest() {

        //Vendor sign-in sayfasina gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportsListener.extentTestInfo("allovercommerce anasayfasnia gidilir");

        //Sign-in linkine tıklanır
        HomePage homePage = new HomePage();
        homePage.signIn.click();
        ExtentReportsListener.extentTestInfo("Sign-in butonuna tiklanir");

        //Email kısmına geçerli veri girilir
        SignInPage signInPage = new SignInPage();
        String vendorEmail ="akifrencber.techproed@gmail.com";
        ConfigReader.getProperty(vendorEmail);//bu kisim da eksiklik var best practice olmama ihtimali!
        signInPage.UsernameTextBox.sendKeys(vendorEmail);

        //Password kısmına geçersiz veri girilir
        String invalidVendorPassword = "Akif123456789";
        signInPage.PasswordTextBox.sendKeys(invalidVendorPassword);
        ExtentReportsListener.extentTestInfo("Gecersiz vendor password girilir");


        //Sign-in butonuna tıklanır
        signInPage.SignInButton.click();
        ExtentReportsListener.extentTestInfo("Sign-in butonuna tiklanir");

        //Gecersiz password ile sayfaya giris yapilamadigi dogrulanir.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        MyAccountPage myAccountPage = new MyAccountPage();
        Assert.assertTrue(myAccountPage.WrongUsernamePasswordWarning.isDisplayed());
        ExtentReportsListener.extentTestInfo("Gecersiz password ile giris yapilamadigi dogrulanir");

     Driver.closeDriver();


    }
}


