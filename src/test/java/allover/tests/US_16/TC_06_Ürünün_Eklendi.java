package allover.tests.US_16;

import allover.pages.*;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_06_Ürünün_Eklendi {

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

        AddProduct.addNewButton.click();

        WebElement submitButton = driver.findElement(By.id("publish"));
        submitButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='updated notice']"));
        Assert.assertTrue(successMessage.getText().contains("Product published"));

        driver.findElement(By.linkText("Products")).click();
        WebElement addedProduct = driver.findElement(By.xpath("//a[contains(text(),'Test Ürünü')]"));
        Assert.assertTrue(addedProduct.isDisplayed());

    }

}
