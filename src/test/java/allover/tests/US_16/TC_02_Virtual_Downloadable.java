package allover.tests.US_16;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.pages.StoreManagerPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_02_Virtual_Downloadable {

    WebElement driver;

    @Test
    public void productDefalt() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        StoreManagerPage storeManagerPage = new StoreManagerPage();

        homePage.signIn.click();

        signInPage.UsernameTextBox.sendKeys(ConfigReader.getProperty("vendorEmail"));

        signInPage.PasswordTextBox.sendKeys(ConfigReader.getProperty("vendorPassword"));

        signInPage.SignInButton.click();
        ReusableMethods.scroll(homePage.myAccount);
        ReusableMethods.scroll(homePage.myAccount);
        ReusableMethods.visibleWait(homePage.myAccount, 5);

        homePage.myAccount.click();

        myAccountPage.StoreManagerButton.click();

        ReusableMethods.scroll(storeManagerPage.ProductsButton);
        ReusableMethods.visibleWait(storeManagerPage.ProductsButton, 5);
        storeManagerPage.ProductsButton.click();

        WebElement virtualCheckbox = driver.findElement(By.id("is_virtual"));
        if (!virtualCheckbox.isSelected()) {
            virtualCheckbox.click();
        }

        WebElement downloadableCheckbox = driver.findElement(By.id("is_downloadable"));
        if (!downloadableCheckbox.isSelected()) {
            downloadableCheckbox.click();
        }

    }
}
