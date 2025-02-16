package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import allover.utilities.WaitUtils;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_NullLastNameTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde Last name i değiştirebilmeli")
    public void testName() {
        //sayfaya kullanıcı olarak giriş yapılır
        //sing out butonuna tıklanır

        AccountDetailsPage accountDetailsPage=new AccountDetailsPage();
        SignInCustomer.SignIn();


        WaitUtils.waitFor(3);

        //Account details url sine gidilir
        ExtentReportsListener.extentTestInfo("Account details url sine gidilir");

        Driver.getDriver().get(ConfigReader.getProperty("accountDetailsUrl"));
        
        // Url nin "edit-account" içerdiği doğrulanır
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-account"));
        String lastName = accountDetailsPage.LastName.getAttribute("value");

        //Last name box ı boş bırakılır
        ExtentReportsListener.extentTestInfo("Last name box ı boş bırakılır");
        accountDetailsPage.LastName.clear();


        //Save changes butonuna tıklanır
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");
        accountDetailsPage.SaveButton.submit();

        //"Last name is a required field." mesajı görünmeli
        ExtentReportsListener.extentTestInfo("'LAST NAME is a required field.' mesajı görünmeli");
        Assert.assertEquals(accountDetailsPage.VerifyControl.getText(),"LAST NAME is a required field.");

        //Last name in değişmediği görülür
        ExtentReportsListener.extentTestInfo("Last name in değişmediği görülür");
        Assert.assertEquals(accountDetailsPage.LastName.getAttribute("value"),lastName);

    }
}
