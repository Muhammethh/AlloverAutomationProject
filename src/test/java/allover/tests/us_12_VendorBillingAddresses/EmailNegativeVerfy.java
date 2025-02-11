package allover.tests.us_12_VendorBillingAddresses;

import allover.pages.VendorAdressesPage;
import allover.utilities.ActionsUtils;
import allover.utilities.BrowserUtils;
import allover.utilities.WaitUtils;
import org.testng.annotations.Test;

public class EmailNegativeVerfy extends TestBase{

    @Test
    public void emailTest() {

        //Email address kisminda otomatik gelmelidir.
        VendorAdressesPage vendorAdressesPage=new VendorAdressesPage();
        ActionsUtils.scrollDown();
       // BrowserUtils.verifyElementDisplayed(vendorAdressesPage.email);
       // Assert.assertTrue(vendorAdressesPage.email.isDisplayed());
        WaitUtils.waitFor(3);
        ActionsUtils.scrollUp();
        BrowserUtils.verifyElementDisplayed(vendorAdressesPage.firstName);

    }
}
