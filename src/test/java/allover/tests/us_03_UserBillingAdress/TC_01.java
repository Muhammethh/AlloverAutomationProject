package allover.tests.us_03_UserBillingAdress;

import allover.pages.HomePage;
import allover.tests.SignInCustomer;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import allover.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class TC_01 extends SignInCustomer {

    @Test
    public void test01() {
        //Web sitesine gidilir.

        SignInCustomer.SignIn();
        HomePage homePage = new HomePage();
        ReusableMethods.click(homePage.myAccount);

        //  Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportsListener.extentTestInfo("Web sitesine gidildi.");



    }
}
