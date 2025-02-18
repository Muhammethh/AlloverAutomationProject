package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.pages.HomePage;
import allover.pages.SignInPage;
import allover.tests.SignInCustomer;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import allover.utilities.WaitUtils;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC08_ValidDisplayNameTest {

    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde Display name i değiştirebilmeli\n")
    public void tc08() {
        //sayfaya kullanıcı olarak giriş yapılır
        //sing out butonuna tıklanır
        HomePage homePage=new HomePage();
        SignInPage signIn=new SignInPage();


        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        homePage.signIn.click();
        signIn.UsernameTextBox.sendKeys("display1");
        signIn.PasswordTextBox.sendKeys("displaycontrol.1");
        signIn.SignInButton.click();

        AccountDetailsPage accountDetailsPage=new AccountDetailsPage();
        Faker faker=new Faker();

        String displayName = faker.name().username();


        WaitUtils.waitFor(3);

        //Account details url sine gidilir

        Driver.getDriver().get(ConfigReader.getProperty("accountDetailsUrl"));
        ExtentReportsListener.extentTestInfo("Account details url sine gidilir");
        // Url nin "edit-account" içerdiği doğrulanır
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-account"));
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");

        //Last Name Text box ına geçerli bir Last name girilir
        accountDetailsPage.DisplayName.clear();

        accountDetailsPage.DisplayName.sendKeys(displayName);
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında Display Name box ına geçerli bir name girilir");

        //Save changes butonuna tıklanır
        accountDetailsPage.SaveButton.submit();
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");

        //"Account details changed successfully." mesajı görünür
        Assert.assertEquals(accountDetailsPage.SuccesfullyControl.getText(),"Account details changed successfully.");
        Driver.getDriver().navigate().refresh();
        ExtentReportsListener.extentTestInfo("'Account details changed successfully.' mesajı görünür");

        //Last Name in girilen yeni isimle aynı olduğu doğrulanır

        Assert.assertEquals(accountDetailsPage.DisplayName.getAttribute("value"),displayName);
        ExtentReportsListener.extentTestInfo("Display Name in girilen yeni isimle aynı olduğu doğrulanır");

        //sayfa kapatılır
        Driver.closeDriver();
    }
}
