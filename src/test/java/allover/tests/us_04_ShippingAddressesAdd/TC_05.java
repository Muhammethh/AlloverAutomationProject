package allover.tests.us_04_ShippingAddressesAdd;

import allover.pages.HomePage;
import allover.pages.UserAddressesPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_05 extends SignInCustomer {

//postcode bos birakilir


    @Test
    public void test05() {
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
=======
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

        ExtentReportsListener.extentTestInfo("ZIP Code kısmı bos birakilir");


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

        Assert.assertTrue(userAddressesPage.zipCodeRequiredField.isDisplayed());

        ExtentReportsListener.extentTestInfo("Save Address butonuna tıklayarak successfully yazisi gorulmemelidir");
=======
        ExtentReportsListener.extentTestPass("Save Address butonuna tıklayarak successfully yazisi gorulmedi ve zorunlu alanla ilgili uyari mesaji vermistir.");


        Driver.closeDriver();











    }
}
