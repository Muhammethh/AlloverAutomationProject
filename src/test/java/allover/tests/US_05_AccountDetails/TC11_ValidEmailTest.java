package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.pages.HomePage;
import allover.pages.SignInPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC11_ValidEmailTest {


    @Test( description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde Display name i değiştirebilmeli\n")
    public void tc08(){
        //sayfaya kullanıcı olarak giriş yapılır
        //sing out butonuna tıklanır
        HomePage homePage=new HomePage();
        SignInPage signIn=new SignInPage();


        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        homePage.signIn.click();
        signIn.UsernameTextBox.sendKeys("mail");
        signIn.PasswordTextBox.sendKeys("mailcontrol.1");
        signIn.SignInButton.click();
        AccountDetailsPage accountDetailsPage=new AccountDetailsPage();
        Faker faker=new Faker();
        String mail = faker.internet().emailAddress();

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

        accountDetailsPage.EmailAddress.sendKeys(mail);
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında Email box ına geçerli bir name girilir");

        //Save changes butonuna tıklanır
        accountDetailsPage.SaveButton.submit();
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");

        //"Account details changed successfully." mesajı görünür
        Assert.assertEquals(accountDetailsPage.SuccesfullyControl.getText(),"Account details changed successfully.");
        Driver.getDriver().navigate().refresh();
        ExtentReportsListener.extentTestInfo("'Account details changed successfully.' mesajı görünür");

        //email in girilen yeni isimle aynı olduğu doğrulanır

        Assert.assertEquals(accountDetailsPage.EmailAddress.getAttribute("value"),mail);
        ExtentReportsListener.extentTestInfo("Email in girilen yeni mail aynı olduğu doğrulanır");

        //sayfa kapatılır
        Driver.closeDriver();
    }
}
