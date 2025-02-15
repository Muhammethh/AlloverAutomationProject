package allover.tests.us_12_VendorBillingAddresses;

import allover.pages.MyAccountPage;
import allover.pages.VendorAdressesPage;
import allover.tests.SignInVendor;
import allover.utilities.ExtentReportsListener;
import allover.utilities.JSUtils;
import allover.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_08 extends SignInVendor {

    @Test(description = "US-12 TC-8 Email kismi otomatik gelmelidir  ")
    public void test() {

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
        ReusableMethods.click();
        ExtentReportsListener.extentTestInfo("Edit Billing Adresses sekmesine tıklanır");

        JSUtils.JSscrollIntoView(vendorAdressesPage.email);
        Assert.assertEquals(vendorAdressesPage.email.getDomAttribute("value"),"akifrencber.techproed@gmail.com");
        ExtentReportsListener.extentTestPass("Email otomatik olarak geldigi dogrulanir");

    }
}
