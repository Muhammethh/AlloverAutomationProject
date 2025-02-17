package allover.tests.us_12_VendorBillingAddresses;

import allover.pages.MyAccountPage;
import allover.pages.VendorAdressesPage;
import allover.tests.SignInVendor;
import allover.utilities.ExtentReportsListener;
import allover.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_10  {

    @Test(description = "US-12 TC-10 My Accountta name   otomatik gelmelidir  ")
    public void test() {
        SignInVendor.SignIn();
        //    Adresses sekmesine tıklanir
        MyAccountPage myAccountPage=new MyAccountPage();
        myAccountPage.AddressesButton.click();
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Vendor address sekmesine tiklar");


        VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();
        Assert.assertTrue(vendorAdressesPage.verfyName.getText().contains("Name"));
        ExtentReportsListener.extentTestPass("Name otomatik olarak geldi");

    }


}
