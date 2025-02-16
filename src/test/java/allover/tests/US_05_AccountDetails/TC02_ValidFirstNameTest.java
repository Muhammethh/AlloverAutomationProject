package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_ValidFirstNameTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde first name i değiştirebilmeli")
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

        //kullanıcı hesap detaylarında FirstName box ına geçerli bir name girilir
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında FirstName box ına geçerli bir name girilir");
        accountDetailsPage.FirstName.clear();
        String firstName = faker.name().firstName();
        accountDetailsPage.FirstName.sendKeys(firstName);

        //Save changes butonuna tıklanır
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");
        accountDetailsPage.SaveButton.submit();

        //"Account details changed successfully." mesajı görünür
        ExtentReportsListener.extentTestInfo("'Account details changed successfully.' mesajı görünür");
        Assert.assertEquals(accountDetailsPage.SuccesfullyControl.getText(),"Account details changed successfully.");
        Driver.getDriver().navigate().refresh();

        //First Name in girilen yeni isimle aynı olduğu doğrulanır
        ExtentReportsListener.extentTestInfo("First Name in girilen yeni isimle aynı olduğu doğrulanır");

        System.out.println("a"+accountDetailsPage.FirstName.getAttribute("value"));
        Assert.assertEquals(accountDetailsPage.FirstName.getAttribute("value"),firstName);

    }
}
