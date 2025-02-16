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

public class TC08_ValidDisplayNameTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde Display name i değiştirebilmeli\n")
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

        //Last Name Text box ına geçerli bir Last name girilir
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında Display Name box ına geçerli bir name girilir");
        accountDetailsPage.DisplayName.clear();
        String displayName = faker.name().username();
        accountDetailsPage.DisplayName.sendKeys(displayName);

        //Save changes butonuna tıklanır
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");
        accountDetailsPage.SaveButton.submit();

        //"Account details changed successfully." mesajı görünür
        ExtentReportsListener.extentTestInfo("'Account details changed successfully.' mesajı görünür");
        Assert.assertEquals(accountDetailsPage.SuccesfullyControl.getText(),"Account details changed successfully.");
        Driver.getDriver().navigate().refresh();

        //Last Name in girilen yeni isimle aynı olduğu doğrulanır
        ExtentReportsListener.extentTestInfo("Display Name in girilen yeni isimle aynı olduğu doğrulanır");

        Assert.assertEquals(accountDetailsPage.DisplayName.getAttribute("value"),displayName);

        //sayfa kapatılır
        Driver.closeDriver();
    }
}
