package allover.tests.US_01_Register;

import allover.pages.HomePage;
import allover.pages.RegisterPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TC02_RegisterNegative {


    @DataProvider
    public Object[][] emails() {

        Faker faker = new Faker();

        return new Object[][]{

                {"",faker.internet().emailAddress(),"malaky.charith123"},   // (False) Username alani bos birakildiginda...
                {faker.name().username(),"", "malaky.charith123"},    // (False) Your email address alani bos birakildiginda...
                {faker.name().username(),faker.internet().emailAddress(), ""},    // (False) Password alani bos birakildiginda...



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



    }
}





