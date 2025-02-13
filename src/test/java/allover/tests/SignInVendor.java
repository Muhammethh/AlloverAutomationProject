package allover.tests;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.utilities.*;
import org.testng.annotations.BeforeClass;

public class SignInVendor {
    @BeforeClass
    public void beforeClass() {

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
