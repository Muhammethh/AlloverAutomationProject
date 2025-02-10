package allover.tests.us_10_VendorBillingAdress;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.pages.VendorAdressesPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ReusableMethods;
import org.testng.annotations.BeforeClass;

public  class TestBase {

    @BeforeClass
    public void beforeClass() {

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        HomePage homePage=new HomePage();
        homePage.signIn.click();
        SignInPage signInPage=new SignInPage();
        signInPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("email"));
        signInPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("password"));
        signInPage.RemembeMeCheckBox.click();
        signInPage.SignInButton.click();
        //    My account a tiklanir
        ReusableMethods.scrollEnd();
        ReusableMethods.waitForSecond(2);
        homePage.myAccount.click();

        //    Adresses sekmesine tıklanir
        MyAccountPage myAccountPage=new MyAccountPage();
        myAccountPage.AddressesButton.click();
        ReusableMethods.waitForSecond(2);

        //    Edit Billing Adresses sekmesine tıklanır.
        VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();
        ReusableMethods.waitForSecond(2);
        ReusableMethods.scroll(vendorAdressesPage.editYourBilling);
        ReusableMethods.visibleWait(vendorAdressesPage.editYourBilling,3);
        ReusableMethods.click(  vendorAdressesPage.editYourBilling);

    }

}
