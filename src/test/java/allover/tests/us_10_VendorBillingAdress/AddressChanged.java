package allover.tests.us_10_VendorBillingAdress;

import allover.pages.VendorAdressesPage;
import allover.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressChanged extends TestBase{

    @Test
    public void test2negative() {
        Faker faker=new Faker();
        //billing adress kisminda girilen bilgiler guncellenebilmelidir
        VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();
        vendorAdressesPage.firstName.clear();
        vendorAdressesPage.firstName.sendKeys(faker.name().firstName());
        vendorAdressesPage.lastName.clear();
        vendorAdressesPage.lastName.sendKeys(faker.name().lastName());
        vendorAdressesPage.streetAdress1.clear();
        vendorAdressesPage.streetAdress1.sendKeys(faker.address().fullAddress());
        vendorAdressesPage.streetAdress2.clear();
        vendorAdressesPage.streetAdress2.sendKeys(faker.address().buildingNumber());
        vendorAdressesPage.townCity.clear();
        vendorAdressesPage.townCity.sendKeys(faker.address().city());
        vendorAdressesPage.zipCode.clear();
        vendorAdressesPage.zipCode.sendKeys(faker.address().zipCode());
        vendorAdressesPage.phone.clear();
        vendorAdressesPage.phone.sendKeys(faker.phoneNumber().cellPhone());
        ReusableMethods.visibleWait(vendorAdressesPage.saveButton,5);
        ReusableMethods.click(vendorAdressesPage.saveButton);
        ReusableMethods.waitForSecond(2);
        Assert.assertTrue(vendorAdressesPage.changedSuccessfully.isDisplayed());

    }
}
