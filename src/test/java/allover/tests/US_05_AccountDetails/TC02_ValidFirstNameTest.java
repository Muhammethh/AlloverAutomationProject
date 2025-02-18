package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_ValidFirstNameTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde first name i değiştirebilmeli")
    public void tc02() {
        //sayfaya kullanıcı olarak giriş yapılır
        //sing out butonuna tıklanır

        AccountDetailsPage accountDetailsPage=new AccountDetailsPage();
        Faker faker=new Faker();
        SignInCustomer.SignIn();


        WaitUtils.waitFor(3);

        //Account details url sine gidilir

        Driver.getDriver().get(ConfigReader.getProperty("accountDetailsUrl"));
        ExtentReportsListener.extentTestInfo("Account details url sine gidilir");

        // Url nin "edit-account" içerdiği doğrulanır
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-account"));
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");

        //kullanıcı hesap detaylarında FirstName box ına geçerli bir name girilir
        accountDetailsPage.FirstName.clear();
        String firstName = faker.name().firstName();
        accountDetailsPage.FirstName.sendKeys(firstName);
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında FirstName box ına geçerli bir name girilir");

        //Save changes butonuna tıklanır
        accountDetailsPage.SaveButton.submit();
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");

        //"Account details changed successfully." mesajı görünür
        Assert.assertEquals(accountDetailsPage.SuccesfullyControl.getText(),"Account details changed successfully.");
        Driver.getDriver().navigate().refresh();
        ExtentReportsListener.extentTestInfo("'Account details changed successfully.' mesajı görünür");

        //First Name in girilen yeni isimle aynı olduğu doğrulanır

        System.out.println("a"+accountDetailsPage.FirstName.getAttribute("value"));
        Assert.assertEquals(accountDetailsPage.FirstName.getAttribute("value"),firstName);
        ExtentReportsListener.extentTestInfo("First Name in girilen yeni isimle aynı olduğu doğrulanır");

        //sayfa kapatılır
        Driver.closeDriver();
    }
}
