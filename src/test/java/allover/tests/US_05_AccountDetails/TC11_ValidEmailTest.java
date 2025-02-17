package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC11_ValidEmailTest {
    @DataProvider
    public Object[][] email() {

        Faker faker = new Faker();

        return new Object[][]{

                {faker.internet().emailAddress()},
                {ConfigReader.getProperty("signInEmail")}


        };
    }

    @Test(dataProvider = "email", description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde Display name i değiştirebilmeli\n")
    public void tc08(String email){
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
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");

        //Email Text box ına geçerli bir Last name girilir
        ActionsUtils.hoverOver(accountDetailsPage.EmailAddress);

        accountDetailsPage.EmailAddress.clear();

        accountDetailsPage.EmailAddress.sendKeys(email);
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında Email box ına geçerli bir name girilir");

        //Save changes butonuna tıklanır
        accountDetailsPage.SaveButton.submit();
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");

        //"Account details changed successfully." mesajı görünür
        Assert.assertEquals(accountDetailsPage.SuccesfullyControl.getText(),"Account details changed successfully.");
        Driver.getDriver().navigate().refresh();
        ExtentReportsListener.extentTestInfo("'Account details changed successfully.' mesajı görünür");

        //email in girilen yeni isimle aynı olduğu doğrulanır

        Assert.assertEquals(accountDetailsPage.EmailAddress.getAttribute("value"),email);
        ExtentReportsListener.extentTestInfo("Email in girilen yeni isimle aynı olduğu doğrulanır");

        //sayfa kapatılır
        Driver.closeDriver();
    }
}
