package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import allover.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_NullFirstNameTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde first name i değiştirebilmeli")
    public void tc03() {
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
        String value1 = accountDetailsPage.FirstName.getAttribute("value");
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");

        //First name box ı boş bırakılır
        accountDetailsPage.FirstName.clear();
        ExtentReportsListener.extentTestInfo("First name box ı boş bırakılır");

        //Save changes butonuna tıklanır
        accountDetailsPage.SaveButton.submit();
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");

        WaitUtils.waitFor(2);
        //"First name is a required field." mesajı görünmeli
        Assert.assertEquals(accountDetailsPage.VerifyControl.getText(),"FIRST NAME is a required field.");
        ExtentReportsListener.extentTestInfo("'First name is a required field.' mesajı görünmeli");


        //First name in değişmediği görülmeli
        String value2 = accountDetailsPage.FirstName.getAttribute("value");
        Assert.assertEquals(value2,value1);
        ExtentReportsListener.extentTestInfo("First name in değişmediği görülmeli");

        //sayfa kapatılır
        Driver.closeDriver();

    }
}
