package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_InvalidLastNameTest {
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
        String value1 = accountDetailsPage.LastName.getAttribute("value");

        //First name geçersiz bir name girilir
        ExtentReportsListener.extentTestInfo("Last name geçersiz bir name girilir");
        accountDetailsPage.LastName.clear();
        accountDetailsPage.LastName.sendKeys(ConfigReader.getProperty("gecersizName"));

        //Save changes butonuna tıklanır
        ExtentReportsListener.extentTestInfo("Save changes butonuna tıklanır");
        accountDetailsPage.SaveButton.submit();
        WaitUtils.waitFor(2);



        //First name in değişmediği görülmeli
        ExtentReportsListener.extentTestFail("Last name in değişmediği görülmeli");
        String value2 = accountDetailsPage.LastName.getAttribute("value");
        ActionsUtils.hoverOver(accountDetailsPage.LastName);
        ExtentReportsListener.extentTestFail("Geçersiz girilen Last Name box ı değişiklik olarak kabul ediliyor");
        ExtentReportsListener.addScreenShotToReport();
        Assert.assertEquals(value2,value1);



    }
}
