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

public class TC17_NullCurrentPasswordTest {
    @Test(description = "Current password alanı boş bırakıldığında değişiklik başarısız olmalı")
    public void testName() {

        // sayfaya kullanıcı olarak giriş yapılır
        //sing out butonuna tıklanır

        AccountDetailsPage accountDetailsPage = new AccountDetailsPage();

        SoftAssert softAssert = new SoftAssert();

        SignInCustomer.SignIn();


        WaitUtils.waitFor(3);

        //Account details url sine gidilir
        ExtentReportsListener.extentTestInfo("Account details url sine gidilir");

        Driver.getDriver().get(ConfigReader.getProperty("accountDetailsUrl"));

        // Url nin "edit-account" içerdiği doğrulanır
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-account"));

        //Current password kısmı boş bırakılır

        //New password kısmına geçerli yeni parola yazılır
        accountDetailsPage.NewPasswordTextBox.sendKeys("Alican123.456");
        //Confirm password kısmına geçerli yeni parola tekrar yazılır
        accountDetailsPage.ConfirmPasswordTextBox.sendKeys("Alican123.456");

        //Save Changes butonuna tıklanır
        accountDetailsPage.SaveButton.submit();
        //Değişiklik işleminin başarısız olduğu doğrulanır
        Assert.assertEquals(accountDetailsPage.VerifyControl.getText(), "Please enter your current password.");


        //sayfa kapatılır
        Driver.closeDriver();
    }}