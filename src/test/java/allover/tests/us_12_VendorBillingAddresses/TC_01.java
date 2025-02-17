package allover.tests.us_12_VendorBillingAddresses;

import allover.pages.MyAccountPage;
import allover.pages.VendorAdressesPage;
import allover.tests.SignInVendor;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;








public class TC_01 extends SignInVendor {


    @Test(description = "US-12 TC-1 Vendor Billing Addrese (Fatura Adresi) gecerli datalar ekleyebilmelidir")
    public void test() {


        //    Adresses sekmesine tıklanir
        MyAccountPage myAccountPage=new MyAccountPage();
        myAccountPage.AddressesButton.click();
        ExtentReportsListener.extentTestInfo("Vendor address sekmesine tiklar");
        ReusableMethods.waitForSecond(2);

        // Edit Billing Adresses sekmesine tıklanır.

       VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();
       ReusableMethods.waitForSecond(2);
       ReusableMethods.scroll(vendorAdressesPage.editYourBilling);
       ReusableMethods.visibleWait(vendorAdressesPage.editYourBilling,3);
       ReusableMethods.click(  vendorAdressesPage.editYourBilling);
        ExtentReportsListener.extentTestInfo("Vendor edit your billing adsress sekmesine tiklar");


        Faker faker=new Faker();
        //First name kısmına geçerli veri girilir
        vendorAdressesPage.firstName.clear();
        vendorAdressesPage.firstName.sendKeys(faker.name().firstName());
        ExtentReportsListener.extentTestInfo("First name kısmına geçerli veri girilir");

        //Last name kısmına geçerli veri girilir
        vendorAdressesPage.lastName.clear();
        vendorAdressesPage.lastName.sendKeys(faker.name().lastName());
        ExtentReportsListener.extentTestInfo("Last name kısmına geçerli veri girilir");

        vendorAdressesPage.companyName.clear();
        vendorAdressesPage.companyName.sendKeys(ConfigReader.getProperty("companyname"));
        ExtentReportsListener.extentTestInfo("Company name kismina gecerli data girilir");

        //Country/Region kısmına geçerli veri girilir
        JSUtils.JSscrollIntoView(vendorAdressesPage.country);
        ReusableMethods.click(vendorAdressesPage.country);
        ActionsUtils.scrollDown();
        ReusableMethods.ddmValue(vendorAdressesPage.country,"US");


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

        //State kismina gecerli veri secilir
        JSUtils.JSscrollIntoView(vendorAdressesPage.state);
        ReusableMethods.click(vendorAdressesPage.state);
        ReusableMethods.ddmValue(vendorAdressesPage.state,"AK");



        //Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) guncellenir.
        ReusableMethods.visibleWait(vendorAdressesPage.saveButton,5);
        ReusableMethods.click(vendorAdressesPage.saveButton);
        ExtentReportsListener.extentTestInfo("Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) eklenir");
        ReusableMethods.waitForSecond(2);

        Assert.assertTrue(vendorAdressesPage.changedSuccessfully.isDisplayed());
        ExtentReportsListener.extentTestPass("Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) eklenme dogrulanir");

    }
}
