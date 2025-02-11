package allover.tests.US_11;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DashboardTest {

    @Test (description = "US-11 TC-1 Vendor sign in,Vendor olarak Sign in yapılabilmeli")
    public void vendorSignInTest() {

        //Vendor sign-in sayfasina gilidir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        ExtentReportsListener.extentTestInfo("allovercommerce anasayfasnia gidilir");

        //Sign-in linkine tıklanır

        HomePage homePage = new HomePage();
        homePage.signIn.click();
        ExtentReportsListener.extentTestInfo("Sign-in butonuna tiklanir");

        //Email kısmına geçerli veri girilir
        SignInPage signInPage = new SignInPage();
        String vendorEmail ="akifrencber.techproed@gmail.com";
        String vendorPassword = "Akif123456789@";
        ConfigReader.getProperty(vendorEmail);
        signInPage.UsernameTextBox.sendKeys(vendorEmail);

        //Password kısmına geçerli veri girilir
        signInPage.PasswordTextBox.sendKeys(vendorPassword);
        ExtentReportsListener.extentTestInfo("Gecerli vendor email ve password girilir");

        //Sign-in butonuna tıklanır
        signInPage.SignInButton.click();
        ExtentReportsListener.extentTestInfo("Sign-in butonuna tiklanir");


        //My Account bölümünun gorulur oldugu dogrulanir (Bu islem icin once tekrardan
        // signout butonuna tiklamak gerekmekte)

        homePage.signOut.click();
        MyAccountPage myAccountPage = new MyAccountPage();
        Assert.assertTrue(myAccountPage.MyAccountTitle.isDisplayed());
        ExtentReportsListener.extentTestInfo("My Account bilgisinin gorunur oldugu dogrulanir");

     Driver.closeDriver();


    }
}


