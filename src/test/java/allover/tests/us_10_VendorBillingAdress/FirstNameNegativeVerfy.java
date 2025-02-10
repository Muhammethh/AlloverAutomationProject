package allover.tests.us_10_VendorBillingAdress;

import allover.pages.VendorAdressesPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstNameNegativeVerfy extends TestBase {

    @Test
    public void test1Negatif() {

        //Adress bolumunde name kismina gecersiz data girildiginde ekleme yapilmamali
        VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();
        vendorAdressesPage.firstName.sendKeys("12");
        ReusableMethods.scroll(vendorAdressesPage.country);
        ReusableMethods.visibleWait(vendorAdressesPage.country,3);

        //Country/Region kısmına geçerli veri girilir
        ReusableMethods.click(vendorAdressesPage.country);
        ReusableMethods.waitForSecond(2);


//        	Street address kısmına geçerli veri girilir
        vendorAdressesPage.streetAdress1.sendKeys(ConfigReader.getProperty("streetaddress1"));
        ReusableMethods.waitForSecond(2);
        vendorAdressesPage.streetAdress2.sendKeys(ConfigReader.getProperty("streetaddress2"));
        ReusableMethods.waitForSecond(2);

//        	Town/City kısmına geçerli veri girilir
        vendorAdressesPage.townCity.sendKeys(ConfigReader.getProperty("city"));
        ReusableMethods.waitForSecond(2);

        //        States kismina gecerli veri girlir
        ReusableMethods.click(vendorAdressesPage.state);

        ReusableMethods.waitForSecond(2);

//          ZIP Code kısmına geçerli veri girilir
        vendorAdressesPage.zipCode.sendKeys(ConfigReader.getProperty("zipcode"));
        ReusableMethods.waitForSecond(2);
//        	Phone kısmına geçerli veri girilir
        vendorAdressesPage.phone.sendKeys(ConfigReader.getProperty("phone"));
        ReusableMethods.waitForSecond(2);

//       Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) eklenir
        ReusableMethods.visibleWait(vendorAdressesPage.saveButton,5);
        ReusableMethods.click(vendorAdressesPage.saveButton);
        ReusableMethods.waitForSecond(2);

//      "Address changed successfully." metni görülmedigi doğrulanır
        Assert.assertFalse(vendorAdressesPage.changedSuccessfully.isDisplayed());

        Driver.closeDriver();
    }
}
