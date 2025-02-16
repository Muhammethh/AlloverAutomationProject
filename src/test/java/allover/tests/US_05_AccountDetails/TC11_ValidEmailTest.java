package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11_ValidEmailTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde Last name i değiştirebilmeli")
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

        //Email Text box ına geçerli bir Last name girilir
        ActionsUtils.hoverOver(accountDetailsPage.EmailAddress);

        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında Email box ına geçerli bir name girilir");
        accountDetailsPage.EmailAddress.clear();
        String email = faker.internet().emailAddress();
        accountDetailsPage.EmailAddress.sendKeys(email);

        //Save changes butonuna tıklanır
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");
        accountDetailsPage.SaveButton.submit();

        //"Account details changed successfully." mesajı görünür
        ExtentReportsListener.extentTestInfo("'Account details changed successfully.' mesajı görünür");
        Assert.assertEquals(accountDetailsPage.SuccesfullyControl.getText(),"Account details changed successfully.");
        Driver.getDriver().navigate().refresh();

        //email in girilen yeni isimle aynı olduğu doğrulanır
        ExtentReportsListener.extentTestInfo("Email in girilen yeni isimle aynı olduğu doğrulanır");

        Assert.assertEquals(accountDetailsPage.EmailAddress.getAttribute("value"),email);

    }
}
