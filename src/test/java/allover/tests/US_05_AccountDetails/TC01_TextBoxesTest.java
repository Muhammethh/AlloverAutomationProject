package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_TextBoxesTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) görünür olmalı")
    public void testName() {
        //sayfaya kullanıcı olarak giriş yapılır
        //sing out butonuna tıklanır

        AccountDetailsPage accountDetailsPage=new AccountDetailsPage();
        Faker faker=new Faker();
        SignInCustomer.SignIn();

        WaitUtils.waitFor(3);

        //Account details url sine gidilir
        ExtentReportsListener.extentTestInfo("Account details url sine gidilir");

        Driver.getDriver().get(ConfigReader.getProperty("accountDetailsUrl"));
        // Url nin "edit-account" içerdiği doğrulanır
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-account"));

        //kullanıcı hesap detaylarında FirstName i görünür
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında FirstName i görünür");
        Assert.assertTrue(accountDetailsPage.FirstName.isDisplayed());

        //kullanıcı hesap detaylarında LastNamei görünür
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında LastNamei görünür");
        Assert.assertTrue(accountDetailsPage.LastName.isDisplayed());

        //kullanıcı hesap detaylarında DisplayName görünür
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında DisplayName görünür");
        Assert.assertTrue(accountDetailsPage.DisplayName.isDisplayed());

        //kullanıcı hesap detaylarında Email görünür
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında Email görünür");
        Assert.assertTrue(accountDetailsPage.EmailAddress.isDisplayed());


        //kullanıcı hesap detaylarında Biography görünür
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında Biography görünür");
        Driver.getDriver().switchTo().frame(0);

        ActionsUtils.scrollDown();


        Assert.assertTrue(accountDetailsPage.BiographyTextBox.isDisplayed());

        //sayfa kapatılır
        Driver.closeDriver();
    }
}
