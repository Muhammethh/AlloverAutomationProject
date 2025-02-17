package allover.tests.us_11_VendorSignIn;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_05 {

    @Test (description = "US-11 TC-05 Dashboard menusunde yer alan sekmeler tiklanabilir olmali")
    public void DashboardMenuClickableTest() {

        //Vendor sign-in sayfasina gilidir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportsListener.extentTestInfo("allovercommerce anasayfasina gidilir");

        //Sign-in linkine tıklanır
        HomePage homePage = new HomePage();
        homePage.signIn.click();
        ExtentReportsListener.extentTestInfo("Sign-in butonuna tiklanir");

        //Email kısmına geçerli veri girilir
        SignInPage signInPage = new SignInPage();
        signInPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        ExtentReportsListener.extentTestInfo("Gecerli vendor email girilir");

        //Password kısmına geçerli veri girilir
        signInPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("vendorPassword"));
        ExtentReportsListener.extentTestInfo("Gecerli vendor password girilir");

        //Sign-in butonuna tıklanır
        signInPage.SignInButton.click();
        ExtentReportsListener.extentTestInfo("Sign-in butonuna tiklanir");

        //My Account bölümün gorulur oldugu dogrulanir (Bu islem icin once tekrardan
        // signout butonuna tiklamak gerekmekte)

        homePage.signOut.click();
        MyAccountPage myAccountPage = new MyAccountPage();
        WaitUtils.waitFor(3);
        Assert.assertTrue(myAccountPage.MyAccountTitle.isDisplayed());
        ExtentReportsListener.extentTestInfo("My Account bilgisinin gorunur oldugu dogrulanir");


        //Dashboard altindaki Store manager, orders, downloads, addresses , account details,
        // wishlist, Support tickets, followings ve log out'a girilir

        WaitUtils.waitFor(3);
        Assert.assertTrue(myAccountPage.DashboardButton.isEnabled());
        Assert.assertTrue(myAccountPage.StoreManagerButton.isEnabled());
        Driver.getDriver().navigate().back();
        WaitUtils.waitFor(3);
        Assert.assertTrue(myAccountPage.OrdersButton.isEnabled());
        Assert.assertTrue(myAccountPage.DownloadsButton.isEnabled());
        //WaitUtils.waitFor(3);
        ReusableMethods.click(myAccountPage.AddressesButton);
        Assert.assertTrue(myAccountPage.AccountDetailsButton.isEnabled());
        WaitUtils.waitFor(3);

        ActionsUtils.scrollDown();
        Assert.assertTrue(myAccountPage.WishlistButton.isEnabled());
        //WaitUtils.waitFor(3);
        Driver.getDriver().navigate().back();
        Assert.assertTrue(myAccountPage.SupportTicketsButton.isEnabled());
        // WaitUtils.waitFor(3);
        //ReusableMethods.click(myAccountPage.FollowingsButton);
        //WaitUtils.waitFor(3);

        Assert.assertTrue(myAccountPage.FollowingsButton.isEnabled());
        Assert.assertTrue(myAccountPage.LogoutButton.isEnabled());
        ExtentReportsListener.extentTestPass("Dashboard altinda yer alan sekmelerin erisilebilir oldugu dogrulanir");
        Driver.closeDriver();


    }
}


