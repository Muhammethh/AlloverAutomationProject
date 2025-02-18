package allover.tests.US_02_Register_Negative;

import allover.pages.HomePage;
import allover.pages.RegisterPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 {

    @Test(description = "Siteye daha önce kayıtlı bilgiler ile(email) kayıt yapılamamalı.(Register)")
    public void testName() {
        HomePage homePage= new HomePage();
        RegisterPage registerPage= new RegisterPage();
        Faker faker=new Faker();
        ExtentReportsListener extentReportsListener=new ExtentReportsListener();


        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportsListener.extentTestInfo("sayfaya gidilir");

        homePage.register.click();
        ExtentReportsListener.extentTestInfo("register butonuna tıklanır");

        registerPage.UsernameTextBox.sendKeys(faker.name().username());
        ExtentReportsListener.extentTestInfo("Username bölümüne önceden kayıtlı olmayan bir username girilir");

        registerPage.MailAddressTextBox.sendKeys(ConfigReader.getProperty("registerUsedEmail"));
        ExtentReportsListener.extentTestInfo("Email bölümüne kayıtlı bir email girilir");


        registerPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("registerUsedPassword"));
        ExtentReportsListener.extentTestInfo("Password bölümüne geçerli bir şifre girilir");


        registerPage.AgreeCheckBox.click();
        ExtentReportsListener.extentTestInfo("I agree to the privacy policy' checkbox ı işaretlenir");

        registerPage.SignUpButton.click();
        ExtentReportsListener.extentTestInfo("SingUP butonuna tıklanır");

        Assert.assertTrue(registerPage.RegistrationCheck.getText().contains("An account is already registered with your email address."));
        ExtentReportsListener.extentTestInfo("'An account is already registered with your email address.' uyrasının göründüğünü doğrulanır");

        //sayfa kapatılır
        Driver.closeDriver();


    }
}
