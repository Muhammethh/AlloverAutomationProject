package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import allover.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC20_OnlyLettersPasswordTest {
    @Test(description = "Yeni şifre sadece harflerden oluştuğunda değişiklik başarısız olmalı")
    public void testName() {

        // sayfaya kullanıcı olarak giriş yapılır
        //sing out butonuna tıklanır

        AccountDetailsPage accountDetailsPage = new AccountDetailsPage();


        SignInCustomer.SignIn();


        WaitUtils.waitFor(3);

        //Account details url sine gidilir
        ExtentReportsListener.extentTestInfo("Account details url sine gidilir");

        Driver.getDriver().get(ConfigReader.getProperty("accountDetailsUrl"));

        // Url nin "edit-account" içerdiği doğrulanır
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-account"));

        //Current password kısmına eski parola yazılır
        ExtentReportsListener.extentTestInfo("Current password kısmına eski parola yazılır");

        accountDetailsPage.CurrentPasswordTextBox.sendKeys(ConfigReader.getProperty("signInPassword"));

        //New password kısmına geçersiz(8 karekterden az) yeni parola yazılır
        ExtentReportsListener.extentTestInfo("New password kısmına geçersiz yeni parola yazılır");

        accountDetailsPage.NewPasswordTextBox.sendKeys("Alicannn");

        //Confirm password kısmına geçersiz yeni parola tekrar yazılır
        ExtentReportsListener.extentTestInfo("Confirm password kısmına geçersiz yeni parola tekrar yazılır");
        accountDetailsPage.ConfirmPasswordTextBox.sendKeys("Alicannn");

        //Save Changes butonuna tıklanır
        ExtentReportsListener.extentTestInfo("Save Changes butonuna tıklanır");
        accountDetailsPage.SaveButton.submit();
        //Değişiklik işleminin başarısız olduğu doğrulanır
        ExtentReportsListener.extentTestInfo("Değişiklik işleminin başarısız olduğu doğrulanır");
        ExtentReportsListener.extentTestFail("Kriterlere uymayan yeni password kabul edilip kaydedildi");
        ExtentReportsListener.addScreenShotToReport();
        Assert.assertNotEquals(accountDetailsPage.VerifyControl.getText(), "Account details changed successfully.");

        //sayfa kapatılır
        Driver.closeDriver();
    }}