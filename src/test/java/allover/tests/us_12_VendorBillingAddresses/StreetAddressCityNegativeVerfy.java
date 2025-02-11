package allover.tests.us_12_VendorBillingAddresses;

import allover.pages.VendorAdressesPage;
import allover.utilities.ConfigReader;
import allover.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StreetAddressCityNegativeVerfy extends TestBase{

    @Test
    public void test3negative() {

       //adres ve sehir kismina gecersiz data girildiginde ekleme olmamalidir
        Faker faker=new Faker();
        VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();
        vendorAdressesPage.firstName.clear();
        vendorAdressesPage.firstName.sendKeys(faker.name().firstName());
        vendorAdressesPage.lastName.clear();
        vendorAdressesPage.lastName.sendKeys(faker.name().lastName());
        vendorAdressesPage.streetAdress1.clear();
        vendorAdressesPage.streetAdress1.sendKeys("??");
        vendorAdressesPage.streetAdress2.sendKeys("....22?????@");
        vendorAdressesPage.townCity.clear();
        vendorAdressesPage.townCity.sendKeys("@");
        vendorAdressesPage.zipCode.clear();
        vendorAdressesPage.zipCode.sendKeys(faker.address().zipCode());
        vendorAdressesPage.phone.clear();
        vendorAdressesPage.phone.sendKeys(faker.phoneNumber().cellPhone());
        vendorAdressesPage.email.clear();
        vendorAdressesPage.email.sendKeys(ConfigReader.getProperty("email"));
        ReusableMethods.visibleWait(vendorAdressesPage.saveButton,5);
        ReusableMethods.click(vendorAdressesPage.saveButton);
        ReusableMethods.waitForSecond(2);
        Assert.assertFalse(vendorAdressesPage.changedSuccessfully.isDisplayed());
    }
}
