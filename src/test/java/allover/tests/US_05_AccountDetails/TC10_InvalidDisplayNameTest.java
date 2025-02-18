package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC10_InvalidDisplayNameTest {
    @DataProvider
    public Object[][] displayName() {



        return new Object[][]{

                {ConfigReader.getProperty("gecersizName")},
                {ConfigReader.getProperty("signInUserName")}


        };
    }

    @Test(dataProvider = "displayName", description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde Display name i değiştirebilmeli\n")
    public void tc08(String displayName){
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

        //Display name geçersiz bir name girilir
        accountDetailsPage.DisplayName.clear();
        accountDetailsPage.DisplayName.sendKeys(displayName);
        ExtentReportsListener.extentTestInfo("Display name geçersiz bir name girilir");

        //Save changes butonuna tıklanır
        accountDetailsPage.SaveButton.submit();
        WaitUtils.waitFor(2);
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");




        ActionsUtils.hoverOver(accountDetailsPage.DisplayName);
        ExtentReportsListener.extentTestFail("Display name in değişmediği görülmeli");

        //First name in değişmediği görülmeli
        String testString = accountDetailsPage.DisplayName.getAttribute("value");
        // Harf içeriyor mu?
        boolean hasLetter = testString.matches(".*[a-zA-Z]+.*");

        // Assert ile doğrula
        Assert.assertTrue(hasLetter, "String dışında karekterler var!");
        ExtentReportsListener.extentTestFail("Display name in değişmediği görülmeli");

        ExtentReportsListener.extentTestFail("Geçersiz girilen Display Name box ı değişiklik olarak kabul ediliyor");


        //sayfa kapatılır
        Driver.closeDriver();

    }
}
