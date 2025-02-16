package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC12_UsedEmailTest {
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
        String email = accountDetailsPage.EmailAddress.getAttribute("value");

        //Email Text box ına geçerli bir Last name girilir
        ActionsUtils.hoverOver(accountDetailsPage.EmailAddress);

        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında Email box ına daha önce hesap oluşturulmuş geçerli bir mail adresi girilir");
        accountDetailsPage.EmailAddress.clear();
        accountDetailsPage.EmailAddress.sendKeys(ConfigReader.getProperty("usedEmail"));

        //Save changes butonuna tıklanır
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");
        accountDetailsPage.SaveButton.submit();

        //"This email address is already registered." mesajı görünür
        ExtentReportsListener.extentTestInfo("'This email address is already registered.' mesajı görünür");
        Assert.assertEquals(accountDetailsPage.VerifyControl.getText(),"This email address is already registered.");
        Driver.getDriver().navigate().refresh();

        //Emailin değişmediği görülmeli
        ExtentReportsListener.extentTestInfo("Emailin değişmediği görünür");

        Assert.assertEquals(accountDetailsPage.EmailAddress.getAttribute("value"),email);

        //sayfa kapatılır
        Driver.closeDriver();
    }
}
