package allover.tests.us_04_ShippingAddressesAdd;

import allover.pages.HomePage;
import allover.pages.UserAddressesPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_07 extends SignInCustomer {

//gecersiz first name
    @Test
    public void test07() {
        Faker faker=new Faker();

        SignInCustomer.SignIn();

        HomePage homePage = new HomePage();
        ReusableMethods.click(homePage.myAccount);
        ReusableMethods.waitForSecond(2);

        //"Addresses" sekmesi tiklanir
        UserAddressesPage userAddressesPage = new UserAddressesPage();
        userAddressesPage.adresses.click();

        //"ADD" sekmesi tiklanir
        ReusableMethods.click(userAddressesPage.addShippingAddress2);

        //    First name alanına gecersiz veri girilir
        userAddressesPage.shippingFirstName.clear();
        userAddressesPage.shippingFirstName.sendKeys("123?");


        ExtentReportsListener.extentTestInfo("First name kısmına geçersiz veri girilir");


        ExtentReportsListener.extentTestInfo("First name kısmına geçersiz veri girilir");

        ReusableMethods.addScreenShotToReport();

        ExtentReportsListener.extentTestInfo("First name kısmına geçersiz veri girildiginde adres eklenmemelidir fakat eklendi");



        //    Last name alanı gecerli veri girilir
        userAddressesPage.shippingLastName.clear();
        userAddressesPage.shippingLastName.sendKeys(faker.name().lastName());
        ExtentReportsListener.extentTestInfo("Last name kısmına geçerli veri girilir");



        //    Company name alanina gecerli veri girilir
        userAddressesPage.shippingCompanyName.clear();
        userAddressesPage.shippingCompanyName.sendKeys(ConfigReader.getProperty("companyname"));
        ExtentReportsListener.extentTestInfo("Company name kismina gecerli data girilir");
        ActionsUtils.scrollDown();



        //    Country/Region seçilir.


        ReusableMethods.scroll(userAddressesPage.shippingCountry);
        ReusableMethods.visibleWait(userAddressesPage.shippingCountry,5);
        ReusableMethods.click(userAddressesPage.shippingCountry);
        ReusableMethods.waitForSecond(2);

        JSUtils.JSscrollIntoView(userAddressesPage.shippingCountry);
        ReusableMethods.click(userAddressesPage.shippingCountry);
        ActionsUtils.scrollDown();
        ReusableMethods.ddmValue(userAddressesPage.shippingCountry,"TR");

        ExtentReportsListener.extentTestInfo("Country/Region kısmına geçerli veri girilir");

        //    Street address alanina gecerli veri girilir
        userAddressesPage.shippingAddress.clear();
        userAddressesPage.shippingAddress.sendKeys(ConfigReader.getProperty("streetaddress1"));
        ReusableMethods.waitForSecond(2);
        userAddressesPage.shippingAddress.clear();
        userAddressesPage.shippingAddress.sendKeys(ConfigReader.getProperty("streetaddress2"));
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Street address kısmına geçerli veri girilir");

        ActionsUtils.scrollDown();


        //    ZIP Code alanina gecerli veri girilir
        userAddressesPage.shippingZipCode.clear();
        userAddressesPage.shippingZipCode.sendKeys(faker.address().zipCode());
        ExtentReportsListener.extentTestInfo("ZIP Code kısmına geçerli veri girilir");


        //Town/City kısmına geçerli veri girilir
        userAddressesPage.shippingCity.clear();

        userAddressesPage.shippingCity.sendKeys(faker.address().city());
        ExtentReportsListener.extentTestInfo("Town/City kısmına geçerli veri girilir");

        //    State secilir
        JSUtils.JSscrollIntoView(userAddressesPage.shippingState);
        ReusableMethods.click(userAddressesPage.shippingState);
        ReusableMethods.ddmValue(userAddressesPage.shippingState,"TR01");
        // ReusableMethods.scroll(userAddressesPage.shippingState);
        ReusableMethods.visibleWait(userAddressesPage.shippingState,2);

        // ReusableMethods.click(userAddressesPage.shippingState);
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("state kısmına geçerli veri secilir");
        ActionsUtils.scrollDown();
        //"SAVE ADDRESS" kutusu tiklanir
        userAddressesPage.shippingSaveAdress.click();

        Assert.assertFalse(userAddressesPage.changedSuccessfullyText.isDisplayed());

        ExtentReportsListener.extentTestInfo("Save Address butonuna tıklayarak successfully yazisi gorulmemelidir");

        ExtentReportsListener.extentTestFail("Save Address butonuna tıklayarak successfully yazisi gorulmemelidir fakat Gecersiz veri ile giris yapilmistir");

        Driver.closeDriver();

    }
}
