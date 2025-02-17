package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TC14_BiographyBoxTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümünde Biography bölümüne metin yazabilmeli")
    public void tc14() {

        // sayfaya kullanıcı olarak giriş yapılır
        //sing out butonuna tıklanır

        AccountDetailsPage accountDetailsPage=new AccountDetailsPage();

        SoftAssert softAssert=new SoftAssert();

        SignInCustomer.SignIn();


        WaitUtils.waitFor(3);

        //Account details url sine gidilir

        Driver.getDriver().get(ConfigReader.getProperty("accountDetailsUrl"));
        ExtentReportsListener.extentTestInfo("Account details url sine gidilir");

        // Url nin "edit-account" içerdiği doğrulanır
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-account"));
        ExtentReportsListener.extentTestInfo("Url nin 'edit-account' içerdiği doğrulanır");

        ActionsUtils.scrollDown();
        WebElement frame = Driver.getDriver().findElement(By.xpath("//iframe"));
         Driver.getDriver().switchTo().frame(frame);
        accountDetailsPage.BiographyTextBox.clear();
        ExtentReportsListener.extentTestInfo("Biography bölümü temizlenir");


         //box a bir metin yazılır

        accountDetailsPage.BiographyTextBox.sendKeys(ConfigReader.getProperty("BiographyText"));
        ExtentReportsListener.extentTestInfo("box a bir metin yazılır");
        Driver.getDriver().switchTo().defaultContent();
        //kaydet butonuna tıklanır

        JSUtils.JSclickWithTimeout(accountDetailsPage.SaveButton);
        ExtentReportsListener.extentTestInfo("kaydet butonuna tıklanır");

      WaitUtils.waitFor(2);
        //yazının kaydedildiği doğrulanır

        ActionsUtils.scrollDown();
       Driver.getDriver().switchTo().frame(0);
        Assert.assertNotNull(accountDetailsPage.BiographyTextBoxIn);
        ExtentReportsListener.extentTestInfo("yazının kaydedildiği doğrulanır");

        //sayfa kapatılır
        Driver.closeDriver();
    }

}
