package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC15_BiographyVisualButtonsTest {
    @Test(description = "Kullanıcı Account Details (Hesap Detaylarını) bölümü Visual butonları seçilebilir olmalı")
    public void tc15() {

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

        accountDetailsPage.BiographyVisualButton.submit();

      //Biography bölümü visual butonları seçilir

         ExtentReportsListener.extentTestInfo("Biography bölümü visual butonları seçilir");
        softAssert.assertTrue(accountDetailsPage.VisualDropDownButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.VisualBoldButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.VisualItalicButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.VisualAllignLeftButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.VisualAllignCentertButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.VisualAllignRightButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.VisualBulletedListButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.VisualNumberedListButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.VisualInsertButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.VisualInsertReadButton.isSelected());
        softAssert.assertTrue(accountDetailsPage.VisualToolbarTagleButton.isSelected());

        ExtentReportsListener.extentTestInfo("Biography bölümü visual butonları seçilir");

        //sayfa kapatılır
        Driver.closeDriver();


    }
}
