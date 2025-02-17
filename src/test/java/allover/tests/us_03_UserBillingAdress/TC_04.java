package allover.tests.us_03_UserBillingAdress;

import allover.pages.HomePage;
import allover.pages.UserAddressesPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_04 {

    //Girilmesi zorunlu olan lastname kismi bos birakilarak uyari alinmali

    @Test
    public void test01() {
        Faker faker=new Faker();

        SignInCustomer.SignIn();

        HomePage homePage = new HomePage();
        ReusableMethods.click(homePage.myAccount);
        ReusableMethods.waitForSecond(2);

        UserAddressesPage userAddressesPage = new UserAddressesPage();
        userAddressesPage.adresses.click();
        ReusableMethods.click(userAddressesPage.addBillingAddress);

        //    First name alanı gecerli veri girilir
        userAddressesPage.billingFirstName.clear();
        userAddressesPage.billingFirstName.sendKeys(faker.name().firstName());
        ExtentReportsListener.extentTestInfo("First name kısmına geçerli veri girilir");

        //    Last name alanı bos birakilir.
        userAddressesPage.billingLastName.clear();
        ExtentReportsListener.extentTestInfo("First name kısmi bos birakilir");



        //    Company name alanina gecerli veri girilir
        userAddressesPage.billingCompanyName.clear();
        userAddressesPage.billingCompanyName.sendKeys(ConfigReader.getProperty("companyname"));
        ExtentReportsListener.extentTestInfo("Company name kismina gecerli data girilir");
        ActionsUtils.scrollDown();



        //    Country/Region seçilir.

        ReusableMethods.scroll(userAddressesPage.billingCountry);
        ReusableMethods.visibleWait(userAddressesPage.billingCountry,5);
        ReusableMethods.click(userAddressesPage.billingCountry);
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Country/Region kısmına geçerli veri girilir");

        //    Street address alanina gecerli veri girilir
        //userAddressesPage.billingAddress.clear();
        userAddressesPage.billingAddress.sendKeys(ConfigReader.getProperty("streetaddress1"));
        ReusableMethods.waitForSecond(2);
        //userAddressesPage.billingAddress.clear();
        userAddressesPage.billingAddress.sendKeys(ConfigReader.getProperty("streetaddress2"));
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Street address kısmına geçerli veri girilir");

        ActionsUtils.scrollDown();


        //    ZIP Code alanina gecerli veri girilir
        //userAddressesPage.billingZipCode.clear();
        userAddressesPage.billingZipCode.sendKeys(faker.address().zipCode());
        ExtentReportsListener.extentTestInfo("ZIP Code kısmına geçerli veri girilir");


        //Town/City kısmına geçerli veri girilir
        //userAddressesPage.billingCity.clear();
        userAddressesPage.billingCity.sendKeys(faker.address().city());
        ExtentReportsListener.extentTestInfo("Town/City kısmına geçerli veri girilir");

        //    State secilir
        JSUtils.JSscrollIntoView(userAddressesPage.billingState);
        ReusableMethods.click(userAddressesPage.billingState);
        ReusableMethods.ddmValue(userAddressesPage.billingState,"TR01");
        // ReusableMethods.scroll(userAddressesPage.shippingState);
        ReusableMethods.visibleWait(userAddressesPage.billingState,2);

        // ReusableMethods.click(userAddressesPage.shippingState);
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("state kısmına geçerli veri secilir");
        //"SAVE ADDRESS" kutusu tiklanir
        userAddressesPage.billingSaveAdressButton.click();



        // Succcessfullynin gorulmedigi dogrulanir.
        ReusableMethods.waitForSecond(2);
        Assert.assertTrue(userAddressesPage.lastNameRequiredField.isDisplayed());
        ExtentReportsListener.extentTestInfo("Save Address butonuna tıklayarak successfully yazisi gorulmemelidir");

        Driver.closeDriver();

        //yorum satiri
    }
}
