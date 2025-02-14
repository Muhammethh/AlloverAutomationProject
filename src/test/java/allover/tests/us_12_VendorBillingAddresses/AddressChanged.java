package allover.tests.us_12_VendorBillingAddresses;

import allover.pages.VendorAdressesPage;
import allover.utilities.ExtentReportsListener;
import allover.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;








//Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) eklenir
public class AddressChanged extends TestBase{

    @Test(description = "US-12 TC-1 Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) guncellenebilmelidir")
    public void test2negative() {

        Faker faker=new Faker();
        VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();

        //First name kısmına geçerli veri girilir
        vendorAdressesPage.firstName.clear();
        vendorAdressesPage.firstName.sendKeys(faker.name().firstName());
        ExtentReportsListener.extentTestInfo("First name kısmına geçerli veri girilir");

        //Last name kısmına geçerli veri girilir
        vendorAdressesPage.lastName.clear();
        vendorAdressesPage.lastName.sendKeys(faker.name().lastName());
        ExtentReportsListener.extentTestInfo("Last name kısmına geçerli veri girilir");

        //Country/Region kısmına geçerli veri girilir


        //Street address1 kısmına geçerli veri girilir
        vendorAdressesPage.streetAdress1.clear();
        vendorAdressesPage.streetAdress1.sendKeys(faker.address().fullAddress());
        ExtentReportsListener.extentTestInfo("Street address1 kısmına geçerli veri girilir");

        //Street address2 kısmına geçerli veri girilir
        vendorAdressesPage.streetAdress2.clear();
        vendorAdressesPage.streetAdress2.sendKeys(faker.address().buildingNumber());
        ExtentReportsListener.extentTestInfo("Street address2 kısmına geçerli veri girilir");

        //Town/City kısmına geçerli veri girilir
        vendorAdressesPage.townCity.clear();
        vendorAdressesPage.townCity.sendKeys(faker.address().city());
        ExtentReportsListener.extentTestInfo("Town/City kısmına geçerli veri girilir");

        //ZIP Code kısmına geçerli veri girilir
        vendorAdressesPage.zipCode.clear();
        vendorAdressesPage.zipCode.sendKeys(faker.address().zipCode());
        ExtentReportsListener.extentTestInfo("ZIP Code kısmına geçerli veri girilir");

        //Phone kısmına geçerli veri girilir
        vendorAdressesPage.phone.clear();
        vendorAdressesPage.phone.sendKeys(faker.phoneNumber().cellPhone());
        ExtentReportsListener.extentTestInfo("Phone kısmına geçerli veri girilir");

        //Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) guncellenir.
        ReusableMethods.visibleWait(vendorAdressesPage.saveButton,5);
        ReusableMethods.click();
        ReusableMethods.waitForSecond(2);
        Assert.assertTrue(vendorAdressesPage.changedSuccessfully.isDisplayed());
        ExtentReportsListener.extentTestInfo("Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) guncellendigi dogrulanir");

    }
}
