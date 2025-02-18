package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_InvalidFirstNameTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde geçersiz bir name ile  first name değiştirilememeli")
    public void tc04() {
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
        String value1 = accountDetailsPage.FirstName.getAttribute("value");
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");

        //First name geçersiz bir name girilir
        accountDetailsPage.FirstName.clear();
        accountDetailsPage.FirstName.sendKeys(ConfigReader.getProperty("gecersizName"));
        ExtentReportsListener.extentTestInfo("First name geçersiz bir name girilir");

        //Save changes butonuna tıklanır
        accountDetailsPage.SaveButton.submit();
        WaitUtils.waitFor(2);
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");



        //First name in değişmediği görülmeli
        String testString = accountDetailsPage.FirstName.getAttribute("value");
        // Harf içeriyor mu?
        boolean hasLetter = testString.matches(".*[a-zA-Z]+.*");

        // Assert ile doğrula
        Assert.assertTrue(hasLetter, "String dışında karekterler var!");
        ExtentReportsListener.extentTestFail("First name in değişmediği görülmeli");
        ExtentReportsListener.extentTestFail("Geçersiz girilen First Name box ı değişiklik olarak kabul ediliyor");

        //sayfa kapatılır
        Driver.closeDriver();


    }
}
