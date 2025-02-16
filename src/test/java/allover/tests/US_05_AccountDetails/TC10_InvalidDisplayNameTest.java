package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10_InvalidDisplayNameTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde geçersiz bir name ile  Last name değiştirilememeli")
    public void testName() {
        //sayfaya kullanıcı olarak giriş yapılır
        //sing out butonuna tıklanır

        AccountDetailsPage accountDetailsPage=new AccountDetailsPage();
        SignInCustomer.SignIn();



        WaitUtils.waitFor(3);

        //Account details url sine gidilir
        ExtentReportsListener.extentTestInfo("Account details url sine gidilir");
        Driver.getDriver().get(ConfigReader.getProperty("accountDetailsUrl"));

        // Url nin "edit-account" içerdiği doğrulanır
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-account"));
        String value1 = accountDetailsPage.DisplayName.getAttribute("value");

        //Display name geçersiz bir name girilir
        ExtentReportsListener.extentTestInfo("Display name geçersiz bir name girilir");
        accountDetailsPage.DisplayName.clear();
        accountDetailsPage.DisplayName.sendKeys(ConfigReader.getProperty("gecersizName"));

        //Save changes butonuna tıklanır
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");
        accountDetailsPage.SaveButton.submit();
        WaitUtils.waitFor(2);



        //First name in değişmediği görülmeli
        ExtentReportsListener.extentTestFail("Display name in değişmediği görülmeli");
        String value2 = accountDetailsPage.DisplayName.getAttribute("value");
        ActionsUtils.hoverOver(accountDetailsPage.DisplayName);
        ExtentReportsListener.extentTestFail("Geçersiz girilen Display Name box ı değişiklik olarak kabul ediliyor");
        ExtentReportsListener.addScreenShotToReport();
        Assert.assertEquals(value2,value1);


        //sayfa kapatılır
        Driver.closeDriver();

    }
}
