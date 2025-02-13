package allover.tests.us_12_VendorBillingAddresses;

import allover.pages.MyAccountPage;
import allover.pages.VendorAdressesPage;
import allover.tests.SignInVendor;
import allover.utilities.ExtentReportsListener;
import allover.utilities.JSUtils;
import allover.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_09 extends SignInVendor {

    @Test(description = "US-12 TC-9 Email kismi ilk Address kisminda otomatik gelmelidir  ")
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



        Assert.assertTrue(vendorAdressesPage.verfyEmail.getText().contains("email"));
        ExtentReportsListener.extentTestFail("Email otomatik olarak gelmeliydi email ile ilgili bir bilgi yok");

    }
}
