package allover.tests.US_02_Register_Negative;

import allover.pages.HomePage;
import allover.pages.RegisterPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 {

    @Test(description = "Siteye daha önce kayıtlı bilgiler ile(username ve email) kayıt yapılamamalı.(Register)")
    public void testName() {
        HomePage homePage= new HomePage();
        RegisterPage registerPage= new RegisterPage();
        ExtentReportsListener extentReportsListener=new ExtentReportsListener();

        ExtentReportsListener.extentTestInfo("sayfaya gidilir");
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        ExtentReportsListener.extentTestInfo("register butonuna tıklanır");
        homePage.register.click();


        ExtentReportsListener.extentTestInfo("Username bölümüne önceden kayıt olunan bir userName girilir");
        registerPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("registerUsedUsername"));

        ExtentReportsListener.extentTestInfo("Email bölümüne kayıtlı bir email girilir");
        registerPage.MailAddressTextBox.sendKeys(ConfigReader.getProperty("registerUsedEmail"));


        ExtentReportsListener.extentTestInfo("Password bölümüne geçerli bir şifre girilir");
        registerPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("registerUsedPassword"));


        ExtentReportsListener.extentTestInfo("I agree to the privacy policy' checkbox ı işaretlenir");
        registerPage.AgreeCheckBox.click();

        ExtentReportsListener.extentTestInfo("SingUP butonuna tıklanır");
        registerPage.SignUpButton.click();

        ExtentReportsListener.extentTestInfo("'An account is already' uyrasının göründüğünü doğrulanır");
        Assert.assertTrue(registerPage.RegistrationCheck.getText().contains("An account is already"));



    }
}
