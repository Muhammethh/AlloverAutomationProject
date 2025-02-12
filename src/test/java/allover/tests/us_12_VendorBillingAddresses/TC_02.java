package allover.tests.us_12_VendorBillingAddresses;

import allover.pages.VendorAdressesPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import allover.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02 extends TestBase {

    @Test(description = "US-12 TC-2 First name gecersiz data girildiginde adres ekleme  basarili olmamalidir ")
    public void test() {

        //Adress bolumunde name kismina gecersiz data girildiginde ekleme yapilmamali
        VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();
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
        ReusableMethods.scroll(vendorAdressesPage.country);
        ReusableMethods.visibleWait(vendorAdressesPage.country,3);
        ReusableMethods.click(vendorAdressesPage.country);
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
        ExtentReportsListener.extentTestInfo("Address changed successfully. metni görülmedigi doğrulanır");
        Driver.closeDriver();
    }
}
