package allover.tests.US_01_Register;

import allover.pages.HomePage;
import allover.pages.RegisterPage;
import allover.utilities.ConfigReader;
import allover.utilities.Driver;
import allover.utilities.ExtentReportsListener;
import allover.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TC01_Register {


    @DataProvider
    public Object[][] emails() {
        return new Object[][]{
                {"Hakan1","Hakan1.techproed@gmail.com","malaky.charith123"},    // True Geçerli Gmail adresi
                {"","Hakan2.techproed@gmail.com","malaky.charith123"},   // False Username alani bos birakildiginda
                {"Hakan2","", "malaky.charith123"},    // False Your email address alani bos birakildiginda
                {"Hakan3","Hakan3.techproed@gmail.com", ""},    // False Password alani bos birakildiginda
                {"Hakan4","Hakan4.techproedgmail.com", "malaky.charith123"},   // False @ uzantisi yazilmadiginda
                {"Hakan5","Hakan5.techproed", "malaky.charith123"},   // False @gmail.com uzantisi yazilmadiginda

                // Password alanina 8 karakterden az bir data girilmesine ragmen kayit islemi gerceklesmistir.

                {"Hakan6","Hakan6.techproed@gmail.com","mal.123"}    // False Password alanina 8 karakterden az data yazildiginda
        };
    }

    @Test(dataProvider = "emails")
    public void test01(String username, String email, String password) {

        // allover Sayfasına Gidelim
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        // Register butonuna tıklayalım
        HomePage homePage = new HomePage();
        homePage.register.click();

        RegisterPage registerPage = new RegisterPage();
        registerPage.UsernameTextBox.sendKeys(username);

        // Dataprovider Kullanarak verilen email ve password bilgileri ile login olalım
        registerPage.MailAddressTextBox.sendKeys(email);

        registerPage.PasswordTextBox.sendKeys(password);

        registerPage.AgreeCheckBox.click();

        registerPage.SignUpButton.click();

        ReusableMethods.visibleWait(registerPage.SignUpButton, 10);
        Assert.assertTrue(registerPage.SignUpButton.isDisplayed());



    }}





