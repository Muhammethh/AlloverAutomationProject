package allover.tests.US_16;

import allover.pages.HomePage;
import allover.pages.MyAccountPage;
import allover.pages.SignInPage;
import allover.pages.StoreManagerPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TC_08_Fail_2 {

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

        ReusableMethods.scroll((WebElement) storeManagerPage.addNewButton);
        ReusableMethods.visibleWait((WebElement) storeManagerPage.addNewButton, 5);
        ReusableMethods.click();
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_DOWN).perform();

        WebElement productTypeDropdown = driver.findElement(By.id("product_type"));
        String selectedOption = productTypeDropdown.getText();
        assertEquals("Simple Product", selectedOption);



        //  Kategori Seçme (Geçerli Kategori Seçildiğini Varsayalım)
        WebElement categoryCheckbox = driver.findElement(By.xpath("//input[@type='checkbox' and @value='123']"));
        categoryCheckbox.click();

        // Fiyat Alanlarını Doldurma
        WebElement priceField = driver.findElement(By.id("regular_price"));
        priceField.clear();
        priceField.sendKeys("100");

        WebElement salePriceField = driver.findElement(By.id("sale_price"));
        salePriceField.clear();
        salePriceField.sendKeys("80");

        //  **Product Title Boş Bırakılıyor**
        // Title alanına veri girilmediğinden boş bırakılmış oluyor.

        //  Ürünü Kaydetmeye Çalışma (Submit)
        WebElement submitButton = driver.findElement(By.id("publish"));
        submitButton.click();

        // Ürünün Eklenmediğini Doğrulama
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class,'error')]"));
        Assert.assertTrue(errorMessage.getText().contains("Product title is required"));
    }
}




