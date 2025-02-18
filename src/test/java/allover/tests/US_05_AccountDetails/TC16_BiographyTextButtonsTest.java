package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import allover.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC16_BiographyTextButtonsTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümü Text butonları seçilebilir olmalı")
    public void tc16() {

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

        //Biography bölümğnde Text butonuna tıklanır

        accountDetailsPage.BiographyVisualButton.submit();
        ExtentReportsListener.extentTestInfo("Biography bölümğnde Text butonuna tıklanır");

      //Biography bölümü Text butonları seçilir

        softAssert.assertTrue(accountDetailsPage.TextBoldButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.TextItalicButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.TextLinkButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.TextBQuoteButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.TextDelButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.TextInsButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.TextIMGButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.TextULButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.TextLIButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.TextCodeButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.TextMoreButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.TextCloseTagButton.isSelected());

        ExtentReportsListener.extentTestInfo("Biography bölümü Text butonları seçilir");

        //sayfa kapatılır
        Driver.closeDriver();
       

    }
}
