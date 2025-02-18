package allover.tests.us_03_UserBillingAdress;

import allover.pages.*;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 extends SignInCustomer {

    @Test
    public void test01() {
        //Web sitesine gidilir.

<<<<<<< HEAD
<<<<<<< HEAD
        SignInCustomer.SignIn();
        HomePage homePage = new HomePage();
        ReusableMethods.click();
=======
=======
>>>>>>> master
        HomePage homePage=new HomePage();
        RegisterPage registerPage= new RegisterPage();
        SignInPage signIn=new SignInPage();
        UserAddressesPage userAddressesPage=new UserAddressesPage();
<<<<<<< HEAD
>>>>>>> master
=======
>>>>>>> master

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        WaitUtils.waitFor(2);
        homePage.register.click();
        WaitUtils.waitFor(2);
        registerPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("UserName"));
        registerPage.MailAddressTextBox.sendKeys(ConfigReader.getProperty("UserEmail"));
        registerPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("UserPassword"));
        registerPage.AgreeCheckBox.click();
        registerPage.SignUpButton.click();


        ActionsUtils.scrollDown();
        WaitUtils.waitFor(2);
        ActionsUtils.scrollEnd();
        WaitUtils.waitFor(2);
        ReusableMethods.click(homePage.myAccount);
        userAddressesPage.adresses.click();
        ReusableMethods.click(userAddressesPage.addBillingAddress);

        Assert.assertTrue(userAddressesPage.billingfirstnamefield.isDisplayed());



    }
}
