package allover.tests.us_11_VendorSignIn;

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


public class TC_02 {

    @Test (description = "US-11 TC-02 Email alanı eksik bırakıldığında sayfaya giris yapilamamali (Negative Case)")

    public void invalidEmailTest() {

        //Vendor sign-in sayfasina gilidir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportsListener.extentTestInfo("allovercommerce anasayfasnia gidilir");

        //Sign-in linkine tıklanır
        HomePage homePage = new HomePage();
        homePage.signIn.click();
        ExtentReportsListener.extentTestInfo("Sign-in butonuna tiklanir");

        //Email kısmına geçersiz veri girilir
        SignInPage signInPage = new SignInPage();
        signInPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("invalidVendorEmail"));


        ExtentReportsListener.extentTestInfo("Gecersiz vendor email girilir");

        //Password kısmına geçerli veri girilir
        signInPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("vendorPassword"));
        ExtentReportsListener.extentTestInfo("Gecerli password girilir");

        //Sign-in butonuna tıklanır
        signInPage.SignInButton.click();

        ExtentReportsListener.extentTestInfo("Sign-in butonuna tiklanir");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        //Sign-in olunamadığı doğrulanır
        MyAccountPage myAccountPage = new MyAccountPage();
        Assert.assertTrue(myAccountPage.WrongUsernamePasswordWarning.isDisplayed());
        ExtentReportsListener.extentTestInfo("Gecersiz email ile giris yapilamadigi dogrulanir");

     Driver.closeDriver();


    }
}


