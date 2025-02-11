package allover.tests;

import allover.pages.HomePage;
import allover.pages.SignInPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import org.testng.annotations.Test;

public class SignInCustomer {



    @Test
    public static void testName() {
        HomePage homePage=new HomePage();
        SignInPage signIn=new SignInPage();


        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl")); // Login sayfasına git
        homePage.signIn.click();
        signIn.UsernameTextBox.sendKeys(ConfigReader.getProperty("signInUserName"));
        signIn.PasswordTextBox.sendKeys(ConfigReader.getProperty("signInPassword"));
        signIn.SignInButton.click();
        Driver.closeDriver();
    }
}
