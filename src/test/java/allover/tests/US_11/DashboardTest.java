package allover.tests.US_11;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DashboardTest {

    @Test (description = "US-11 TC-04 Dashboard menusu gorunur ve tiklanabilir olmali")
    public void DashboardMenuTest() {

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

        //My Account bölümünun gorulur oldugu dogrulanir (Bu islem icin once tekrardan
        // signout butonuna tiklamak gerekmekte)

        homePage.signOut.click();
        MyAccountPage myAccountPage = new MyAccountPage();
        WaitUtils.waitFor(3);
        Assert.assertTrue(myAccountPage.MyAccountTitle.isDisplayed());
        ExtentReportsListener.extentTestInfo("My Account bilgisinin gorunur oldugu dogrulanir");

        //Dashboard'da  Store manager, orders, downloads, addresses , account details,
        // wishlist, Support tickets, followings ve log out gorunur oldugu dogrulanir

        ActionsUtils.scrollDown();
        WaitUtils.waitFor(3);
        Assert.assertTrue(myAccountPage.DashboardButton.isDisplayed());
        Assert.assertTrue(myAccountPage.StoreManagerButton.isDisplayed());
        Assert.assertTrue(myAccountPage.OrdersButton.isDisplayed());
        Assert.assertTrue(myAccountPage.DownloadsButton.isDisplayed());
        Assert.assertTrue(myAccountPage.AddressesButton.isDisplayed());
        Assert.assertTrue(myAccountPage.AccountDetailsButton.isDisplayed());
        Assert.assertTrue(myAccountPage.WishlistButton.isDisplayed());
        Assert.assertTrue(myAccountPage.SupportTicketsButton.isDisplayed());
        Assert.assertTrue(myAccountPage.FollowingsButton.isDisplayed());
        Assert.assertTrue(myAccountPage.LogoutButton.isDisplayed());
        ExtentReportsListener.extentTestInfo("Dashboard altinda yer alan sekmelerin gorunur oldugu dogrulanir");



        //Dashboard altindaki Store manager, orders, downloads, addresses , account details,
        // wishlist, Support tickets, followings ve log out'a girilir
        ActionsUtils.scrollDown();
        WaitUtils.waitFor(3);
        myAccountPage.DashboardButton.click();
        myAccountPage.StoreManagerButton.click();
        myAccountPage.OrdersButton.click();
        myAccountPage.DownloadsButton.click();
        myAccountPage.AddressesButton.click();
        myAccountPage.AccountDetailsButton.click();
        myAccountPage.WishlistButton.click();
        myAccountPage.SupportTicketsButton.click();
        myAccountPage.FollowingsButton.click();
        myAccountPage.LogoutButton.click();

        ExtentReportsListener.extentTestInfo("Dashboard altinda yer alan sekmelerin erisilebilir oldugu dogrulanir");

        Driver.closeDriver();


    }
}


