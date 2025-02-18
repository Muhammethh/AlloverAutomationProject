package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.pages.HomePage;
import allover.pages.SignInPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC13_InvalidEmailTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde daha önce kayıtlı bir mail adresi ile Email i değiştirememeli")
    public void tc13() {
        //sayfaya kullanıcı olarak giriş yapılır
        //sing out butonuna tıklanır
        HomePage homePage=new HomePage();
        SignInPage signIn=new SignInPage();


        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        homePage.signIn.click();
        signIn.UsernameTextBox.sendKeys("mail3");
        signIn.PasswordTextBox.sendKeys("mailcontrol.3");
        signIn.SignInButton.click();
        AccountDetailsPage accountDetailsPage=new AccountDetailsPage();




        WaitUtils.waitFor(3);

        //Account details url sine gidilir

        Driver.getDriver().get(ConfigReader.getProperty("accountDetailsUrl"));
        ExtentReportsListener.extentTestInfo("Account details url sine gidilir");

        // Url nin "edit-account" içerdiği doğrulanır
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-account"));
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");

        //Email Text box ına geçerli bir Email adres girilir
        JSUtils.JSscrollIntoView(accountDetailsPage.EmailAddress);

        accountDetailsPage.EmailAddress.clear();

        accountDetailsPage.EmailAddress.sendKeys(ConfigReader.getProperty("invalidEmail"));
        ExtentReportsListener.extentTestInfo("kullanıcı hesap detaylarında Email box ına geçerli bir name girilir");

        //Save changes butonuna tıklanır
        accountDetailsPage.SaveButton.submit();
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");

        //"Please provide a valid email address." mesajı görünür
        Assert.assertEquals(accountDetailsPage.VerifyControl.getText(),"Please provide a valid email address.");
        Driver.getDriver().navigate().refresh();
        ExtentReportsListener.extentTestInfo("'Please provide a valid email address.' mesajı görünür");

        //First name in değişmediği görülmeli
        String testString = accountDetailsPage.LastName.getAttribute("value");
        // Harf içeriyor mu?
        boolean hasLetter = testString.contains("@");

        // Assert ile doğrula
        Assert.assertTrue(hasLetter, "String dışında karekterler var!");
        ExtentReportsListener.extentTestInfo("Email  in değişmediği görülmeli");

        //sayfa kapatılır
        Driver.closeDriver();
    }
}
