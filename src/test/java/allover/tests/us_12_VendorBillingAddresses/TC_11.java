package allover.tests.us_12_VendorBillingAddresses;

import allover.pages.MyAccountPage;
import allover.pages.VendorAdressesPage;
import allover.tests.SignInVendor;
import allover.utilities.ExtentReportsListener;
import allover.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_11  {


    @Test(description = "US-12 TC-11 My Accountta  last name   otomatik gelmelidir  ")
    public void test() {
        SignInVendor.SignIn();
        //    Adresses sekmesine tıklanir
        MyAccountPage myAccountPage=new MyAccountPage();
        myAccountPage.AddressesButton.click();
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.addScreenShotToReport();
        ExtentReportsListener.extentTestInfo("Vendor address sekmesine tiklar");


        VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();
        Assert.assertTrue(vendorAdressesPage.verfyName.getText().contains("Last name"));
        ExtentReportsListener.extentTestFail("Last name otomatik olarak gelmeliydi  fakat last name ile ilgili bilgi yok");

    }
}
