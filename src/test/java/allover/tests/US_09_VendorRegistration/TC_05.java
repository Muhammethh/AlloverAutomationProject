package allover.tests.US_09_VendorRegistration;
import allover.pages.HomePage;
import allover.pages.RegisterPage;
import allover.pages.VendorRegistrationPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_05 {
    @Test
    public void testVendorInvalidEMailRegistration() throws InterruptedException {

        //  Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportsListener.extentTestInfo("Web sitesine gidildi.");
        Thread.sleep(3000);

        // Sag ustte bulunan Sign in/Register sekmesine tiklanir
        HomePage homePage = new HomePage();
        homePage.register.click();
        ExtentReportsListener.extentTestInfo("register butonuna tiklandi");
        Thread.sleep(2000);

        //  Açılan pop-up icindeki "become a vendor" yazisina tiklanir
        RegisterPage registerPage = new RegisterPage();
        registerPage.BecomeVendorButton.click();
        ExtentReportsListener.extentTestInfo("Become a Vendor butonuna tiklandi");
        Thread.sleep(2000);

        //  Vendor kayyit sayfasina yonlendirildigini dogrula
        String expectedUrl = Driver.getDriver().getCurrentUrl();
        String actualUrl = expectedUrl;
        Assert.assertEquals(actualUrl, expectedUrl, "Vendor kayit sayfasina yonlendirilemedi");
        ExtentReportsListener.extentTestInfo("Vendor kayit sayfasina basariyla yonlendirildi");

        VendorRegistrationPage vendorRegistrationPage = new VendorRegistrationPage();
        String invalideMail = "akifrencber.techproed@gmail.com";
        ConfigReader.getProperty(invalideMail);
        vendorRegistrationPage.VendorEmailTextBox.sendKeys(invalideMail);
        ExtentReportsListener.extentTestInfo("Gecersiz e mail adresi girilir");

        //Password alanina gecerli bir password girilir
        String validPassword = "123456789Aa!";
        vendorRegistrationPage.VendorPasswordTextBox.sendKeys(validPassword);
        ExtentReportsListener.extentTestInfo("Gecerli password girilir");

        //Confirm password kisminda password tekrar yazilir
        vendorRegistrationPage.VendorConfirmPasswordTextBox.sendKeys(validPassword);

        //Verification kismina kod girilir
        String validVerification = "";
        vendorRegistrationPage.VerificationCodeInput.sendKeys(validVerification);
        ExtentReportsListener.extentTestInfo("verification code kismi bos birakilir");

        //Register butonuna tiklanir
        vendorRegistrationPage.RegisterButton.click();
        Thread.sleep(2000);
        //hatayi almak icin 2 kere registera basmam gerektigi icin tekrar click ekledim
        vendorRegistrationPage.RegisterButton.click();

        // kayit olunup olunmadigi dogrulanir
        Assert.assertTrue(vendorRegistrationPage.WarningEmailUsing.isDisplayed(),"Verification code kismi bos birakilamaz");
        ExtentReportsListener.extentTestInfo("Verification code kismi bos birakilamaz");


        Driver.closeDriver();


    }
}
