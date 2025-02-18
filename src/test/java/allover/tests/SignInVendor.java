package allover.tests;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.utilities.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInVendor {
    @Test
    public static void SignIn() {
        //Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        HomePage homePage = new HomePage();
        homePage.signIn.click();
        SignInPage signInPage = new SignInPage();
        signInPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        signInPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("vendorPassword"));
        signInPage.RemembeMeCheckBox.click();
        signInPage.SignInButton.click();
        WaitUtils.waitFor(2);
        ActionsUtils.scrollDown();
        //    My account a tiklanir
        ReusableMethods.scrollEnd();
        ReusableMethods.waitForSecond(2);
        homePage.myAccount.click();


    }


}
