import allover.pages.*;
import allover.utilities.*;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.bson.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TC_02{
    @Test
    public void test02() throws InterruptedException {
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


        HomePage homePage1 = new HomePage();
        homePage.searchBox.sendKeys("Book", Keys.ENTER);

        ActionsUtils.hoverOver(sampleItemsPage.firstItemAfterSearch);

        ReusableMethods.click(sampleItemsPage.addFirstItemInCart);

        ActionsUtils.hoverOver(homePage.cartHead);

        homePage.searchBox.sendKeys("Laptop", Keys.ENTER);
        ActionsUtils.hoverOver(sampleItemsPage.firstItemAfterSearch);

        ReusableMethods.click(sampleItemsPage.addFirstItemInCart);

        ActionsUtils.hoverOver(homePage.cartHead);

        WebElement cartIcon = Driver.getDriver().findElement(By.cssSelector(".w-icon-cart"));
        cartIcon.click();

        Thread.sleep(5000);
        WebElement checkoutButton = Driver.getDriver().findElement(By.xpath("//a[contains(@class, 'button checkout wc-forward')]"));
        checkoutButton.click();

        // Subtotal değerini al
        WebElement subtotalElement = Driver.getDriver().findElement(By.xpath("//th[text()='Subtotal']/following-sibling::td"));
        String subtotalText = subtotalElement.getText().replace("$", "").trim();
        double subtotal = Double.parseDouble(subtotalText);

        // Total değerini al
        WebElement totalElement = Driver.getDriver().findElement(By.xpath("//th[text()='Total']/following-sibling::td"));
        String totalText = totalElement.getText().replace("$", "").trim();
        double total = Double.parseDouble(totalText);

        // Subtotal ve Total eşit mi kontrol et
        Assert.assertEquals(total, subtotal, "Total ve Subtotal eşit değil!");






    }}

