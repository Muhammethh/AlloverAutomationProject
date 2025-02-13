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

public class TC_02 extends SignInVendor {

    @Test(description = "US-12 TC-2 First name gecersiz data girildiginde adres ekleme  basarili olmamalidir ")
    public void test() {

        //    Adresses sekmesine tıklanir
        MyAccountPage myAccountPage=new MyAccountPage();
        myAccountPage.AddressesButton.click();
        ReusableMethods.waitForSecond(2);

        // Edit Billing Adresses sekmesine tıklanır.

        VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();
        ReusableMethods.waitForSecond(2);
        ReusableMethods.scroll(vendorAdressesPage.editYourBilling);
        ReusableMethods.visibleWait(vendorAdressesPage.editYourBilling,3);
        ReusableMethods.click(  vendorAdressesPage.editYourBilling);


        //Adress bolumunde name kismina gecersiz data girildiginde ekleme yapilmamali
        vendorAdressesPage.firstName.clear();
        vendorAdressesPage.firstName.sendKeys("12");
        ExtentReportsListener.extentTestFail("First name alanı hatalı girildiğinde adres eklenmemeli ancak eklendi!");

        vendorAdressesPage.lastName.clear();
        vendorAdressesPage.lastName.sendKeys(ConfigReader.getProperty("lastname"));
        ExtentReportsListener.extentTestInfo("Lastname kismina gecerli veri girlir");

        vendorAdressesPage.companyName.clear();
        vendorAdressesPage.companyName.sendKeys(ConfigReader.getProperty("companyname"));
        ExtentReportsListener.extentTestInfo("Company name kismina gecerli data girilir");


        //Country/Region kısmına geçerli veri girilir
<<<<<<< HEAD:src/test/java/allover/tests/us_12_VendorBillingAddresses/FirstNameNegativeVerfy.java
        ReusableMethods.click();
=======
        ReusableMethods.scroll(vendorAdressesPage.country);
        ReusableMethods.visibleWait(vendorAdressesPage.country,3);
        ReusableMethods.click(vendorAdressesPage.country);
>>>>>>> f43d158 (testcaselerde degisiklik yapildi):src/test/java/allover/tests/us_12_VendorBillingAddresses/TC_02.java
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Country/Region kısmına geçerli veri girilir");

//        	Street address kısmına geçerli veri girilir
        vendorAdressesPage.streetAdress1.clear();
        vendorAdressesPage.streetAdress1.sendKeys(ConfigReader.getProperty("streetaddress1"));
        ReusableMethods.waitForSecond(2);
        vendorAdressesPage.streetAdress2.clear();
        vendorAdressesPage.streetAdress2.sendKeys(ConfigReader.getProperty("streetaddress2"));
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Street address kısmına geçerli veri girilir");

//        	Town/City kısmına geçerli veri girilir
        vendorAdressesPage.townCity.clear();
        vendorAdressesPage.townCity.sendKeys(ConfigReader.getProperty("city"));
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Town/City kısmına geçerli veri girilir");

        //        States kismina gecerli veri girlir
<<<<<<< HEAD:src/test/java/allover/tests/us_12_VendorBillingAddresses/FirstNameNegativeVerfy.java
        ReusableMethods.click();

=======
        ReusableMethods.click(vendorAdressesPage.state);
>>>>>>> f43d158 (testcaselerde degisiklik yapildi):src/test/java/allover/tests/us_12_VendorBillingAddresses/TC_02.java
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
        ReusableMethods.click();
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) eklenir");


//      "Address changed successfully." metni görülmedigi doğrulanır
        Assert.assertFalse(vendorAdressesPage.changedSuccessfully.isDisplayed());
        ExtentReportsListener.extentTestInfo("Address changed successfully. metni görülmedigi doğrulanır");
        Driver.closeDriver();
    }
}
