package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC13_InvalidEmailTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde daha önce kayıtlı bir mail adresi ile Email i değiştirememeli")
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

       String email= accountDetailsPage.EmailAddress.getAttribute("value");
        //Email Text box ına geçerli bir Email adres girilir
        ActionsUtils.hoverOver(accountDetailsPage.EmailAddress);

        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında Email box ına geçerli bir name girilir");
        accountDetailsPage.EmailAddress.clear();

        accountDetailsPage.EmailAddress.sendKeys(ConfigReader.getProperty("invalidEmail"));

        //Save changes butonuna tıklanır
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");
        accountDetailsPage.SaveButton.submit();

        //"Please provide a valid email address." mesajı görünür
        ExtentReportsListener.extentTestInfo("'Please provide a valid email address.' mesajı görünür");
        Assert.assertEquals(accountDetailsPage.VerifyControl.getText(),"Please provide a valid email address.");
        Driver.getDriver().navigate().refresh();

        //Email  in değişmediği görülmeli
        ExtentReportsListener.extentTestInfo("Email  in değişmediği görülmeli");

        Assert.assertEquals(accountDetailsPage.EmailAddress.getAttribute("value"),email);

    }
}
