package allover.tests.us_12_VendorBillingAddresses;

import allover.pages.MyAccountPage;
import allover.pages.VendorAdressesPage;
import allover.tests.SignInVendor;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import allover.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_04  {

    @Test(description = "US-12 TC-4 Street address kismina gecersiz data girildiginde adres ekleme  basarili olmamalidir ")
    public void test() {
        SignInVendor.SignIn();
        //    Adresses sekmesine tıklanir
        MyAccountPage myAccountPage=new MyAccountPage();
        myAccountPage.AddressesButton.click();
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Vendor address sekmesine tiklar");
        // Edit Billing Adresses sekmesine tıklanır.

        VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();
        ReusableMethods.waitForSecond(2);
        ReusableMethods.scroll(vendorAdressesPage.editYourBilling);
        ReusableMethods.visibleWait(vendorAdressesPage.editYourBilling,3);
        ReusableMethods.click(  vendorAdressesPage.editYourBilling);
        ExtentReportsListener.extentTestInfo("Vendor edit your billing adsress sekmesine tiklar");


        //First name kismina gecerli data girilir
        vendorAdressesPage.firstName.clear();
        vendorAdressesPage.firstName.sendKeys(ConfigReader.getProperty("firstname"));
        ExtentReportsListener.extentTestInfo("First name kismina gecerli data girilir");

        vendorAdressesPage.lastName.clear();
        vendorAdressesPage.lastName.sendKeys(ConfigReader.getProperty("lastname"));
        ExtentReportsListener.extentTestFail("Last name alanı hatalı girildiğinde adres eklenmemeli ancak eklendi!");

        vendorAdressesPage.companyName.clear();
        vendorAdressesPage.companyName.sendKeys(ConfigReader.getProperty("companyname"));
        ExtentReportsListener.extentTestInfo("Company name kismina gecerli data girilir");

        //Country/Region kısmına geçerli veri girilir
        ReusableMethods.scroll(vendorAdressesPage.country);
        ReusableMethods.visibleWait(vendorAdressesPage.country,3);
        ReusableMethods.click(vendorAdressesPage.country);
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Country/Region kısmına geçerli veri girilir");

//        	Street address kısmına geçerersiz veri girilir
        vendorAdressesPage.streetAdress1.clear();
        vendorAdressesPage.streetAdress1.sendKeys("#1");
        ReusableMethods.waitForSecond(2);
        vendorAdressesPage.streetAdress2.clear();
        vendorAdressesPage.streetAdress2.sendKeys("?");
        ExtentReportsListener.addScreenShotToReport();
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Street address kısmına geçerersiz veri girilir");

//        	Town/City kısmına geçerli veri girilir
        vendorAdressesPage.townCity.clear();
        vendorAdressesPage.townCity.sendKeys(ConfigReader.getProperty("city"));
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Town/City kısmına geçerli veri girilir");

        //        States kismina gecerli veri girlir
        ReusableMethods.click(vendorAdressesPage.state);
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("States kismina gecerli veri girlir");

//          ZIP Code kısmına geçerli veri girilir
        vendorAdressesPage.zipCode.clear();
        vendorAdressesPage.zipCode.sendKeys(ConfigReader.getProperty("zipcode"));
        ExtentReportsListener.extentTestInfo("ZIP Code kısmına geçerli veri girilir");

        ReusableMethods.waitForSecond(2);

//        	Phone kısmına geçerli veri girilir
        vendorAdressesPage.phone.clear();
        vendorAdressesPage.phone.sendKeys(ConfigReader.getProperty("phone"));
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Phone kısmına geçerli veri girilir");


//       Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) eklenir
        ReusableMethods.visibleWait(vendorAdressesPage.saveButton,5);
        ReusableMethods.click(vendorAdressesPage.saveButton);
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) eklenir");


//      "Address changed successfully." metni görülmedigi doğrulanır
        Assert.assertFalse(vendorAdressesPage.changedSuccessfully.isDisplayed());
        ExtentReportsListener.extentTestFail("StreetAdress alanı hatalı girildiğinde adres eklenmemeli ancak eklendi!");

        Driver.closeDriver();
    }
}
