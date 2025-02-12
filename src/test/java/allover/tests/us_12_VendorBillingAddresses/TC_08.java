package allover.tests.us_12_VendorBillingAddresses;

import allover.pages.VendorAdressesPage;
import allover.utilities.ExtentReportsListener;
import allover.utilities.JSUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_08 extends TestBase{

    @Test(description = "US-12 TC-8 Email kismi otomatik gelmelidir  ")
    public void test() {

        VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();
        JSUtils.JSscrollIntoView(vendorAdressesPage.email);
        Assert.assertEquals(vendorAdressesPage.email.getDomAttribute("value"),"akifrencber.techproed@gmail.com");
        ExtentReportsListener.extentTestInfo("Email otomatik olarak geldigi dogrulanir");

    }
}
