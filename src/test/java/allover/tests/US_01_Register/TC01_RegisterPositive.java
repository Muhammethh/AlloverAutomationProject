package allover.tests.US_01_Register;

import allover.pages.HomePage;
import allover.pages.RegisterPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import allover.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TC01_RegisterPositive {


    @DataProvider
    public Object[][] emails() {

        Faker faker = new Faker();

        return new Object[][]{

                {faker.name().username(),faker.internet().emailAddress(),"malaky.charith123"},    // (True) Geçerli Gmail adresi girildiginde...

        };
    }

    @Test(dataProvider = "emails")
    public void test01(String username, String email, String password) {

        // allover Sayfasına Gidelim
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        // Register butonuna tıklayalım
        HomePage homePage = new HomePage();
        homePage.register.click();

        // Username alanina bir data girelim
        RegisterPage registerPage = new RegisterPage();
        registerPage.UsernameTextBox.sendKeys(username);

        // Your email address alanina bir data girelim
        registerPage.MailAddressTextBox.sendKeys(email);

        // Password alanina bir data girelim
        registerPage.PasswordTextBox.sendKeys(password);

        // Agree check box ini tiklayalim.
        registerPage.AgreeCheckBox.click();

        // SignUp butonuna tiklayalim.

        registerPage.SignUpButton.click();

        ReusableMethods.visibleWait(registerPage.SignUpButton, 10);
        Assert.assertTrue(registerPage.SignUpButton.isDisplayed());

         //

        // Gerekli datalar girildikten sonra siteye kayit olundugu dogrulanir ve "Sign Out" butonu görünür

        Assert.assertTrue(homePage.signOut.isDisplayed(), "Sign Out");

    }

}