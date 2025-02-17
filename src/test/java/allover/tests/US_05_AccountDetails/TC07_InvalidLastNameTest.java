package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_InvalidLastNameTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde geçersiz bir name ile  Last name değiştirilememeli")
    public void tc07() {
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

        //First name geçersiz bir name girilir
        accountDetailsPage.LastName.clear();
        accountDetailsPage.LastName.sendKeys(ConfigReader.getProperty("gecersizName"));
        ExtentReportsListener.extentTestInfo("Last name geçersiz bir name girilir");

        //Save changes butonuna tıklanır
        accountDetailsPage.SaveButton.submit();
        WaitUtils.waitFor(2);
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");



        //First name in değişmediği görülmeli
        String testString = accountDetailsPage.LastName.getAttribute("value");
        // Harf içeriyor mu?
        boolean hasLetter = testString.matches(".*[a-zA-Z]+.*");

        // Assert ile doğrula
        Assert.assertTrue(hasLetter, "String dışında karekterler var!");
        ExtentReportsListener.extentTestFail("Last name in değişmediği görülmeli");


        //sayfa kapatılır
        Driver.closeDriver();
    }
}
