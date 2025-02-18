package allover.tests.US_10_VendorRegistrationPassword;

import allover.pages.HomePage;
import allover.pages.RegisterPage;
import allover.pages.VendorRegistrationPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_03 {
    @Test
    public void testVendorGoodPassword() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //  Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportsListener.extentTestInfo("Web sitesine gidildi.");


        // Sag ustte bulunan Sign in/Register sekmesine tiklanir
        HomePage homePage = new HomePage();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.register)).click();
        ExtentReportsListener.extentTestInfo("register butonuna tiklandi");

        //  Açılan pop-up icindeki "become a vendor" yazisina tiklanir
        RegisterPage registerPage = new RegisterPage();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.BecomeVendorButton)).click();
        ExtentReportsListener.extentTestInfo("Become a Vendor butonuna tiklandi");

        //  Vendor kayyit sayfasina yonlendirildigini dogrula
        wait.until(ExpectedConditions.urlToBe("https://allovercommerce.com/vendor-register/"));
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://allovercommerce.com/vendor-register/", "Vendor kayit sayfasina yonlendirilemedi");
        ExtentReportsListener.extentTestInfo("Vendor kayit sayfasina basariyla yonlendirildi");

        //Gecerli mail adresi gir
        VendorRegistrationPage vendorRegistrationPage = new VendorRegistrationPage();
        String validEmail = "testdeneme123456@gmail.com";
        ConfigReader.getProperty(validEmail);
        vendorRegistrationPage.VendorEmailTextBox.sendKeys(validEmail);
        ExtentReportsListener.extentTestInfo("siteye daha once kayit olmamis bir mail girilir");

        //Password alanina kucuk harf buyuk harf ve rakam iceren sifre girilir
        String password = "abc123A";
        vendorRegistrationPage.VendorPasswordTextBox.sendKeys(password);
        ExtentReportsListener.extentTestInfo("Password alanina kucuk harf buyuk harf ve rakam iceren sifre girilir");

        // "Good" hata mesajinin goruntulendigini dogrula
        wait.until(ExpectedConditions.visibilityOf(vendorRegistrationPage.PasswordStrength));
        Assert.assertTrue(vendorRegistrationPage.PasswordStrength.isDisplayed(), "Good hatasi goruntulenmedi!");
        Assert.assertEquals(vendorRegistrationPage.PasswordStrength.getText(), "Good", "Hata mesaji beklenen gibi degil!");
        ExtentReportsListener.extentTestInfo("Good hatasi dogrulandi");

        Driver.closeDriver();
    }
}