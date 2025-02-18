package allover.tests.us_13_Shipping;

import allover.pages.MyAccountPage;
import allover.pages.VendorAdressesPage;
import allover.tests.SignInVendor;
import allover.utilities.*;




import com.aventstack.extentreports.ExtentReports;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 extends SignInVendor {
    @Test
    public void test01() {

// Adres sekmesine tiklanilir

MyAccountPage myAccountPage= new MyAccountPage();

myAccountPage.AddressesButton.click();

ReusableMethods.waitForSecond(2);



VendorAdressesPage vendorAdressesPage= new VendorAdressesPage();
ReusableMethods.waitForSecond(4);

ActionsUtils.scrollRight();
BrowserUtils.clickWithTimeOut(vendorAdressesPage.getEditYourShipping,3);



        ReusableMethods.waitForSecond(2);
        vendorAdressesPage.shippingfirstName.clear();

        vendorAdressesPage.shippingfirstName.sendKeys(ConfigReader.getProperty("firstname"));




        ExtentReportsListener.extentTestInfo("Kullanici firstname kismina gecerli data girdi");


        vendorAdressesPage.shippinglastName.sendKeys(ConfigReader.getProperty("lastname"));
        vendorAdressesPage.shippingcompanyName.sendKeys(ConfigReader.getProperty("companyname"));

        JSUtils.JSscrollIntoView(vendorAdressesPage.shippingcountry);
        ReusableMethods.click(vendorAdressesPage.shippingcountry);
        ActionsUtils.scrollDown();
        ReusableMethods.ddmValue(vendorAdressesPage.shippingcountry,"US");

        vendorAdressesPage.shippingstreetAdress1.sendKeys(ConfigReader.getProperty("streetaddress1"));

        vendorAdressesPage.shippingstreetAdress2.sendKeys(ConfigReader.getProperty("streetaddress2"));
        vendorAdressesPage.shippingtownCity.sendKeys(ConfigReader.getProperty("city"));

       JSUtils.JSscrollIntoView(vendorAdressesPage.shippingstate);
        //ReusableMethods.click(vendorAdressesPage.shippingstate);
        ActionsUtils.scrollDown();

        ReusableMethods.ddmValue(vendorAdressesPage.shippingstate,"AK");
        vendorAdressesPage.shippingzipCode.clear();
        vendorAdressesPage.shippingzipCode.sendKeys(ConfigReader.getProperty("zipcode"));


        ReusableMethods.visibleWait(vendorAdressesPage.saveButton,2);
        ReusableMethods.click(vendorAdressesPage.saveButton);
        Assert.assertTrue(vendorAdressesPage.changedSuccessfully.isDisplayed());




        ExtentReportsListener.extentTestPass("Adres degisikligi basarili oldu");













    }
}
