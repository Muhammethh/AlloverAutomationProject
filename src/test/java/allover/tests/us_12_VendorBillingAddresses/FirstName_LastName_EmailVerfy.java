package allover.tests.us_12_VendorBillingAddresses;

import allover.pages.VendorAdressesPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstName_LastName_EmailVerfy extends TestBase{

    @Test
    public void test1() {
        //    First name last name ve email kismini yazin ve goruntulendigini test edin manuelle olarak goruntulendigini test edin

        VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();
        vendorAdressesPage.firstName.sendKeys(ConfigReader.getProperty("firstname"));
        vendorAdressesPage.lastName.sendKeys(ConfigReader.getProperty("lastname"));
        vendorAdressesPage.email.sendKeys(ConfigReader.getProperty("email"));
        Assert.assertTrue(vendorAdressesPage.firstName.isDisplayed(),"ali");
        Assert.assertTrue(vendorAdressesPage.lastName.isDisplayed(),"can");
        Assert.assertTrue(vendorAdressesPage.email.isDisplayed(),"akifrencber.techproed@gmail.com");


        Driver.closeDriver();
    }
}
