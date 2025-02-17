package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_TextBoxesTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) görünür olmalı")
    public void tc01() {
        //sayfaya kullanıcı olarak giriş yapılır
        //sing out butonuna tıklanır

        AccountDetailsPage accountDetailsPage=new AccountDetailsPage();
        Faker faker=new Faker();
        SignInCustomer.SignIn();

        WaitUtils.waitFor(3);

        //Account details url sine gidilir

        Driver.getDriver().get(ConfigReader.getProperty("accountDetailsUrl"));
        ExtentReportsListener.extentTestInfo("Account details url sine gidilir");

        // Url nin "edit-account" içerdiği doğrulanır
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-account"));
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");

        //kullanıcı hesap detaylarında FirstName i görünür
        Assert.assertTrue(accountDetailsPage.FirstName.isDisplayed());
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında FirstName i görünür");

        //kullanıcı hesap detaylarında LastNamei görünür
        Assert.assertTrue(accountDetailsPage.LastName.isDisplayed());
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında LastNamei görünür");

        //kullanıcı hesap detaylarında DisplayName görünür
        Assert.assertTrue(accountDetailsPage.DisplayName.isDisplayed());
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında DisplayName görünür");

        //kullanıcı hesap detaylarında Email görünür
        Assert.assertTrue(accountDetailsPage.EmailAddress.isDisplayed());
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında Email görünür");


        //kullanıcı hesap detaylarında Biography görünür
        Driver.getDriver().switchTo().frame(0);

        ActionsUtils.scrollDown();


        Assert.assertTrue(accountDetailsPage.BiographyTextBox.isDisplayed());
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında Biography görünür");

        //sayfa kapatılır
        Driver.closeDriver();
    }
}
