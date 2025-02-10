package allover.tests.US_05;

import allover.pages.AccountDetailsPage;
import allover.pages.HomePage;
import allover.pages.RegisterPage;
import allover.utilities.ActionsUtils;
import allover.utilities.Driver;
import allover.utilities.ReusableMethods;
import allover.utilities.WaitUtils;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {
    @Test
    public void testName() {
        RegisterPage registerPage=new RegisterPage();
        AccountDetailsPage accountDetailsPage=new AccountDetailsPage();
        Faker faker=new Faker();
        HomePage homePage=new HomePage();




        Driver.getDriver().get("https://allovercommerce.com/");
        homePage.register.click();
        registerPage.UsernameTextBox.sendKeys(faker.name().username());
        registerPage.MailAddressTextBox.sendKeys(faker.internet().emailAddress());
        registerPage.PasswordTextBox.sendKeys("Muhammet.4651");
        registerPage.AgreeCheckBox.click();
        registerPage.SignUpButton.click();
        ReusableMethods.waitForSecond(3);
      Driver.getDriver().get("https://allovercommerce.com/my-account-2/edit-account/");
        accountDetailsPage.FirstName.sendKeys(faker.name().firstName());
        accountDetailsPage.LastName.sendKeys(faker.name().lastName());
        accountDetailsPage.DisplayName.sendKeys(faker.name().username());
        ReusableMethods.waitForSecond(3);
ActionsUtils.scrollEnd();
        accountDetailsPage.SaveButton.submit();
WaitUtils.waitFor(3);
Assert.assertTrue(accountDetailsPage.SuccesfullyControl.isDisplayed());




    }
}
