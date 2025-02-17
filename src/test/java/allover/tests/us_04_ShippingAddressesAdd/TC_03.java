package allover.tests.us_04_ShippingAddressesAdd;

import allover.pages.HomePage;
import allover.pages.UserAddressesPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_03 extends SignInCustomer {


//    last name alanina bos girilir.kayit isleminin gecersiz olmalidir ve bununla ilgili bir mesaj alinmalidir.




    @Test
    public void test03() {

        Faker faker=new Faker();

        SignInCustomer.SignIn();

        HomePage homePage = new HomePage();
        ReusableMethods.click(homePage.myAccount);
        ReusableMethods.waitForSecond(2);

        UserAddressesPage userAddressesPage = new UserAddressesPage();
        userAddressesPage.adresses.click();

        ReusableMethods.click(userAddressesPage.addShippingAddress2);

        //    First name alanına gecerli veri girilir
        userAddressesPage.shippingFirstName.clear();
        userAddressesPage.shippingFirstName.sendKeys(faker.name().firstName());
        ExtentReportsListener.extentTestInfo("First name kısmına geçerli veri girilir");

        //    Last name alanı gecerli veri girilir
        userAddressesPage.shippingLastName.clear();

        ExtentReportsListener.extentTestInfo("Last name kısmı bos birakilir");



        //    Company name alanina gecerli veri girilir
        userAddressesPage.shippingCompanyName.clear();
        userAddressesPage.shippingCompanyName.sendKeys(ConfigReader.getProperty("companyname"));
        ExtentReportsListener.extentTestInfo("Company name kismina gecerli data girilir");
        ActionsUtils.scrollDown();



        //    Country/Region seçilir.

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

        //    Addresses changed successfully yazisi gorulurmez
        ReusableMethods.waitForSecond(2);

        Assert.assertTrue(userAddressesPage.lastNameRequiredField.isDisplayed());
        ExtentReportsListener.extentTestPass("Save Address butonuna tıklayarak successfully yazisi gorulmedi ve zorunlu alanla ilgili uyari mesaji vermistir.");

        Driver.closeDriver();


















    }
}
