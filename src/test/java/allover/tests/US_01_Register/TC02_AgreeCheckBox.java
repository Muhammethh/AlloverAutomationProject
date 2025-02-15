package allover.tests.US_01_Register;

import allover.pages.HomePage;
import allover.pages.RegisterPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_AgreeCheckBox {

    @Test(description = "Geçerli datalar ile Kullanıcı sayfaya kayıt olabilmelidir (Positive Scenario)")
    public void testName() {

        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        ExtentReportsListener extentReportsListener = new ExtentReportsListener();

        ExtentReportsListener.extentTestInfo("sayfaya gidilir");
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        ExtentReportsListener.extentTestInfo("register butonuna tıklanır");
        homePage.register.click();

        ExtentReportsListener.extentTestInfo("Username bölümüne gecerli bir data girilir");
        registerPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("registerPositiveUsername"));

        ExtentReportsListener.extentTestInfo("Email bölümüne gecerli bir data girilir");
        registerPage.MailAddressTextBox.sendKeys(ConfigReader.getProperty("registerPositiveEmail"));


        ExtentReportsListener.extentTestInfo("Password bölümüne gecerli bir data girilir");
        registerPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("registerPositivePassword"));


//        ExtentReportsListener.extentTestInfo("I agree to the privacy policy' checkbox ı işaretlenir");
//        registerPage.AgreeCheckBox.click();

        ExtentReportsListener.extentTestInfo("SingUP butonuna tıklanır");
        registerPage.SignUpButton.click();

        ExtentReportsListener.extentTestInfo("'An account is already' uyrasının göründüğünü doğrulanır");
        Assert.assertTrue(registerPage.RegistrationCheck.getText().contains("An account is already"));
    }
}

