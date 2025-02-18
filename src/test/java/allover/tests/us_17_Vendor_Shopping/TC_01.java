package allover.tests.us_17_Vendor_Shopping;

import allover.pages.*;
import allover.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 {

    @FindBy(xpath = "//a[contains(text(),'View cart')]")
    public WebElement viewCartButton;

    @Test
    public void test01() throws InterruptedException {

        //testin konusu
        //Ürün ve ürünler seçilip sepete eklenebilmeli
        //Chart - Chekout yapılarak alınacak ürün ve ürünler görülebilmeli

        SampleItemsPage sampleItemsPage = new SampleItemsPage();
        CartPage cartPage = new CartPage();


        //  Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportsListener.extentTestInfo("Web sitesine gidildi.");
        Thread.sleep(3000);

        HomePage homePage = new HomePage();
        homePage.signIn.click();
        ExtentReportsListener.extentTestInfo("Sign-in butonuna tiklanir");

        //Email kısmına geçerli veri girilir
        SignInPage signInPage = new SignInPage();
        String vendorEmail = "akifrencber.techproed@gmail.com";
        String vendorPassword = "Akif123456789@";
        ConfigReader.getProperty(vendorEmail);
        signInPage.UsernameTextBox.sendKeys(vendorEmail);

        //Password kısmına geçerli veri girilir
        signInPage.PasswordTextBox.sendKeys(vendorPassword);
        ExtentReportsListener.extentTestInfo("Gecerli vendor email ve password girilir");

        //Sign-in butonuna tıklanır
        signInPage.SignInButton.click();
        ExtentReportsListener.extentTestInfo("Sign-in butonuna tiklanir");


        //My Account bölümünun gorulur oldugu dogrulanir (Bu islem icin once tekrardan
        // signout butonuna tiklamak gerekmekte)

        homePage.signOut.click();
        MyAccountPage myAccountPage = new MyAccountPage();
        Assert.assertTrue(myAccountPage.MyAccountTitle.isDisplayed());
        ExtentReportsListener.extentTestInfo("My Account bilgisinin gorunur oldugu dogrulanir");


        homePage.searchBox.sendKeys("Book", Keys.ENTER);

        ActionsUtils.hoverOver(sampleItemsPage.firstItemAfterSearch);

        ReusableMethods.click(sampleItemsPage.addFirstItemInCart);

        ActionsUtils.hoverOver(homePage.cartHead);

        homePage.searchBox.sendKeys("Laptop", Keys.ENTER);
        ActionsUtils.hoverOver(sampleItemsPage.firstItemAfterSearch);
        ReusableMethods.click(sampleItemsPage.addFirstItemInCart);
        ExtentReportsListener.extentTestInfo("Laptop sepete eklendi.");

        //**Sepete gitme işlemi**
        ActionsUtils.hoverOver(homePage.cartHead);
        homePage.cartHead.click();
        Thread.sleep(3000);
        cartPage.ViewCartButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(cartPage.firstItemInCart.isDisplayed());
        ExtentReportsListener.extentTestPass("Ürünler sepete eklendi");
        Driver.closeDriver();

    }
}





