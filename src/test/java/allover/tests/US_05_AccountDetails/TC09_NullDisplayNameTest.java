package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import allover.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09_NullDisplayNameTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde Display name i değiştirebilmeli")
    public void tc09() {
        //sayfaya kullanıcı olarak giriş yapılır
        //sing out butonuna tıklanır

        AccountDetailsPage accountDetailsPage=new AccountDetailsPage();
        SignInCustomer.SignIn();


        WaitUtils.waitFor(3);

        //Account details url sine gidilir

        Driver.getDriver().get(ConfigReader.getProperty("accountDetailsUrl"));
        ExtentReportsListener.extentTestInfo("Account details url sine gidilir");

        // Url nin "edit-account" içerdiği doğrulanır
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-account"));
        String displayName = accountDetailsPage.DisplayName.getAttribute("value");
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");

        //Last name box ı boş bırakılır
        accountDetailsPage.DisplayName.clear();
        ExtentReportsListener.extentTestInfo("Last name box ı boş bırakılır");


        //Save changes butonuna tıklanır
        accountDetailsPage.SaveButton.submit();
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");

        //"Last name is a required field." mesajı görünmeli
        Assert.assertEquals(accountDetailsPage.VerifyControl.getText(),"DISPLAY NAME is a required field.");
        ExtentReportsListener.extentTestInfo("'DISPLAY NAME is a required field.' mesajı görünmeli");

        //Last name in değişmediği görülür
        Assert.assertEquals(accountDetailsPage.DisplayName.getAttribute("value"),displayName);
        ExtentReportsListener.extentTestInfo("Display name in değişmediği görülür");

        //sayfa kapatılır
        Driver.closeDriver();
    }
}
