package allover.tests.us_12_VendorBillingAddresses;

import allover.pages.VendorAdressesPage;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditYourBillingAdress extends TestBase {

    @Test(description = "US-12 TC-1 Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) eklenebilmelidir")
    public void test2negative() {

        Faker faker=new Faker();
        VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();

        //First name kısmına geçerli veri girilir

        vendorAdressesPage.firstName.sendKeys(faker.name().firstName());
        ExtentReportsListener.extentTestInfo("First name kısmına geçerli veri girilir");

        //Last name kısmına geçerli veri girilir

        vendorAdressesPage.lastName.sendKeys(faker.name().lastName());
        ExtentReportsListener.extentTestInfo("Last name kısmına geçerli veri girilir");

        //company kismina gecerli bir data girilir
        vendorAdressesPage.companyName.sendKeys(ConfigReader.getProperty("companyname"));

        //Country/Region kısmına geçerli veri girilir
        JSUtils.JSscrollIntoView(vendorAdressesPage.country);
        ReusableMethods.click();
        ActionsUtils.scrollDown();
        ReusableMethods.ddmValue(vendorAdressesPage.country,"US");

        //Street address1 kısmına geçerli veri girilir

        vendorAdressesPage.streetAdress1.sendKeys(ConfigReader.getProperty("streetaddress1"));
        ExtentReportsListener.extentTestInfo("Street address1 kısmına geçerli veri girilir");

        //Street address2 kısmına geçerli veri girilir

        vendorAdressesPage.streetAdress2.sendKeys(ConfigReader.getProperty("streetaddress2"));
        ExtentReportsListener.extentTestInfo("Street address2 kısmına geçerli veri girilir");

        //Town/City kısmına geçerli veri girilir

        vendorAdressesPage.townCity.sendKeys(ConfigReader.getProperty("city"));
        ExtentReportsListener.extentTestInfo("Town/City kısmına geçerli veri girilir");

        JSUtils.JSscrollIntoView(vendorAdressesPage.state);
        ReusableMethods.click();

        ReusableMethods.ddmValue(vendorAdressesPage.state,"AK");



        //ZIP Code kısmına geçerli veri girilir

        vendorAdressesPage.zipCode.sendKeys(ConfigReader.getProperty("zipcode"));
        ExtentReportsListener.extentTestInfo("ZIP Code kısmına geçerli veri girilir");


        //Phone kısmına geçerli veri girilir

        vendorAdressesPage.phone.sendKeys(ConfigReader.getProperty("phone"));
        ExtentReportsListener.extentTestInfo("Phone kısmına geçerli veri girilir");

        //Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) guncellenir.
        ReusableMethods.visibleWait(vendorAdressesPage.saveButton,5);
        ReusableMethods.click();
        ReusableMethods.waitForSecond(2);
        Assert.assertTrue(vendorAdressesPage.changedSuccessfully.isDisplayed());
        ExtentReportsListener.extentTestInfo("Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) guncellendigi dogrulanir");

    }
}
