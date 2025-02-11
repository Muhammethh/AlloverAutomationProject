package allover.tests.US_09;

import allover.pages.HomePage;
import allover.pages.RegisterPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 {

    @Test
    public void testVendorRegistrationAccess() throws InterruptedException {

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
        Thread.sleep(3000);

        //  Vendor kayyit sayfasina yonlendirildigini dogrula
        String expectedUrl = Driver.getDriver().getCurrentUrl();
        String actualUrl = expectedUrl;
        Assert.assertEquals(actualUrl, expectedUrl, "Vendor kayit sayfasina yonlendirilemedi");
        ExtentReportsListener.extentTestInfo("Vendor kayit sayfasina basariyla yonlendirildi");


        Driver.closeDriver();
    }
}