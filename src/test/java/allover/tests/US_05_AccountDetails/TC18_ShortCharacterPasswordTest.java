package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import allover.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC18_ShortCharacterPasswordTest {
    @Test(description = "Yeni şifre sadece harflerden oluştuğunda değişiklik başarısız olmalı")
    public void tc18() {

        // sayfaya kullanıcı olarak giriş yapılır
        //sing out butonuna tıklanır

        AccountDetailsPage accountDetailsPage = new AccountDetailsPage();


        SignInCustomer.SignIn();


        WaitUtils.waitFor(3);

        //Account details url sine gidilir

        Driver.getDriver().get(ConfigReader.getProperty("accountDetailsUrl"));
        ExtentReportsListener.extentTestInfo("Account details url sine gidilir");

        // Url nin "edit-account" içerdiği doğrulanır
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-account"));
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");

        //Current password kısmına eski parola yazılır

        accountDetailsPage.CurrentPasswordTextBox.sendKeys(ConfigReader.getProperty("signInPassword"));
        ExtentReportsListener.extentTestInfo("Current password kısmına eski parola yazılır");

        //New password kısmına geçersiz(8 karekterden az) yeni parola yazılır

        accountDetailsPage.NewPasswordTextBox.sendKeys("Ali1?");
        ExtentReportsListener.extentTestInfo("New password kısmına geçersiz(8 karekterden az) yeni parola yazılır");

        //Confirm password kısmına geçersiz(8 karekterden az) yeni parola tekrar yazılır
        accountDetailsPage.ConfirmPasswordTextBox.sendKeys("Ali1?");
        ExtentReportsListener.extentTestInfo("Confirm password kısmına geçersiz(8 karekterden az) yeni parola tekrar yazılır");

        //Save Changes butonuna tıklanır
        accountDetailsPage.SaveButton.submit();
        ExtentReportsListener.extentTestInfo("Save Changes butonuna tıklanır");

        //Değişiklik işleminin başarısız olduğu doğrulanır
        Assert.assertNotEquals(accountDetailsPage.VerifyControl.getText(), "Account details changed successfully.");
        ExtentReportsListener.extentTestInfo("Değişiklik işleminin başarısız olduğu doğrulanır");
        ExtentReportsListener.extentTestFail("Kriterlere uymayan yeni password kabul edilip kaydedildi");

        //sayfa kapatılır
        Driver.closeDriver();

    }}