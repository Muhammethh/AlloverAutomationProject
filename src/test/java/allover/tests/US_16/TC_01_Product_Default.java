package allover.tests.US_16;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.pages.StoreManagerPage;
import allover.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TC_01_Product_Default {

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
        WaitUtils.waitFor(2);
        ActionsUtils.scrollDown();
        //    My account a tiklanir
        ReusableMethods.scrollEnd();
        ReusableMethods.waitForSecond(2);
        homePage.myAccount.click();

//        ReusableMethods.scroll(homePage.myAccount);
//        ReusableMethods.scroll(homePage.myAccount);
//        ReusableMethods.scrollEnd();
//        ReusableMethods.visibleWait(homePage.myAccount, 5);
//         homePage.myAccount.click();
       // homePage.myAccount.click();

        myAccountPage.StoreManagerButton.click();

        ReusableMethods.scroll(storeManagerPage.ProductsButton);
        JSUtils.JSscrollIntoView(storeManagerPage.ProductsButton);
       // ReusableMethods.visibleWait(storeManagerPage.ProductsButton, 5);
        storeManagerPage.ProductsButton.click();

        WebElement productTypeDropdown = driver.findElement(By.id("product_type"));
        String selectedOption = productTypeDropdown.getText();
        assertEquals("Simple Product", selectedOption);

    }
}
