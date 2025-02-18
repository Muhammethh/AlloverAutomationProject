package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.pages.HomePage;
import allover.pages.SignInPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC12_UsedEmailTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde Last name i değiştirebilmeli")
    public void tc12() {
        //sayfaya kullanıcı olarak giriş yapılır
        //sing out butonuna tıklanır
        HomePage homePage=new HomePage();
        SignInPage signIn=new SignInPage();


        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        homePage.signIn.click();
        signIn.UsernameTextBox.sendKeys("mail2");
        signIn.PasswordTextBox.sendKeys("mailcontrol.2");
        signIn.SignInButton.click();
        AccountDetailsPage accountDetailsPage=new AccountDetailsPage();



        WaitUtils.waitFor(3);

        //Account details url sine gidilir

        Driver.getDriver().get(ConfigReader.getProperty("accountDetailsUrl"));
        ExtentReportsListener.extentTestInfo("Account details url sine gidilir");

        // Url nin "edit-account" içerdiği doğrulanır
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-account"));
        String email = accountDetailsPage.EmailAddress.getAttribute("value");
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");

        //Email Text box ına geçerli bir Last name girilir



        JSUtils.JSscrollIntoView(accountDetailsPage.EmailAddress);

        accountDetailsPage.EmailAddress.clear();
        accountDetailsPage.EmailAddress.sendKeys(ConfigReader.getProperty("usedMail"));
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında Email box ına daha önce hesap oluşturulmuş geçerli bir mail adresi girilir");

        //Save changes butonuna tıklanır
        accountDetailsPage.SaveButton.submit();
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");

        //"This email address is already registered." mesajı görünür
        Assert.assertEquals(accountDetailsPage.VerifyControl.getText(),"This email address is already registered.");
        Driver.getDriver().navigate().refresh();
        ExtentReportsListener.extentTestInfo("'This email address is already registered.' mesajı görünür");

        //Emailin değişmediği görülmeli

        Assert.assertEquals(accountDetailsPage.EmailAddress.getAttribute("value"),email);
        ExtentReportsListener.extentTestInfo("Emailin değişmediği görünür");

        //sayfa kapatılır
        Driver.closeDriver();
    }
}
