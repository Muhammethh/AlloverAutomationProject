package allover.tests.us_03_UserBillingAdress;

import allover.pages.HomePage;
import allover.pages.RegisterPage;
import allover.pages.SignInPage;
import allover.pages.UserAddressesPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02 extends SignInCustomer {


    @Test
    public void test02() {

        Faker faker=new Faker();

        SignInCustomer.SignIn();

        HomePage homePage = new HomePage();
        ReusableMethods.click(homePage.myAccount);
        ReusableMethods.waitForSecond(2);

        //"Addresses" sekmesi tiklanir
        UserAddressesPage userAddressesPage = new UserAddressesPage();
        userAddressesPage.adresses.click();

        //"ADD" sekmesi tiklanir
        ReusableMethods.click(userAddressesPage.addBillingAddress);

        //    First name alanına gecerli veri girilir
        userAddressesPage.billingfirstnamefield.clear();
        userAddressesPage.billingfirstnamefield.sendKeys(faker.name().firstName());
        ExtentReportsListener.extentTestInfo("First name kısmına geçerli veri girilir");

        //    Last name alanı gecerli veri girilir
        userAddressesPage.billingLastName.clear();
        userAddressesPage.billingLastName.sendKeys(faker.name().lastName());
        ExtentReportsListener.extentTestInfo("Last name kısmına geçerli veri girilir");



        //    Company name alanina gecerli veri girilir
        userAddressesPage.billingCompanyName.clear();
        userAddressesPage.billingCompanyName.sendKeys(ConfigReader.getProperty("companyname"));
        ExtentReportsListener.extentTestInfo("Company name kismina gecerli data girilir");
        ActionsUtils.scrollDown();



        //    Country/Region seçilir.

        //ReusableMethods.scroll(userAddressesPage.billingCountry);
        ReusableMethods.visibleWait(userAddressesPage.billingCountry,5);
        //ReusableMethods.ddmValue(userAddressesPage.billingState,"TR");


        ReusableMethods.click(userAddressesPage.billingCountry);
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Country/Region kısmına geçerli veri girilir");

        //    Street address alanina gecerli veri girilir

        userAddressesPage.billingAddress.clear();
        userAddressesPage.billingAddress.sendKeys(ConfigReader.getProperty("streetaddress1"));
        ReusableMethods.waitForSecond(2);
        userAddressesPage.billingAddress2.clear();
        userAddressesPage.billingAddress2.sendKeys(ConfigReader.getProperty("streetaddress2"));
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("Street address kısmına geçerli veri girilir");

        ActionsUtils.scrollDown();


        //    ZIP Code alanina gecerli veri girilir
        userAddressesPage.billingZipCode.clear();
        userAddressesPage.billingZipCode.sendKeys(faker.address().zipCode());
        ExtentReportsListener.extentTestInfo("ZIP Code kısmına geçerli veri girilir");


        //Town/City kısmına geçerli veri girilir
        userAddressesPage.billingCity.clear();

        userAddressesPage.billingCity.sendKeys(faker.address().city());
        ExtentReportsListener.extentTestInfo("Town/City kısmına geçerli veri girilir");

        //    State secilir
        JSUtils.JSscrollIntoView(userAddressesPage.billingState);
        ReusableMethods.click(userAddressesPage.billingState);
        ReusableMethods.ddmValue(userAddressesPage.billingState,"TR34");
        ReusableMethods.scroll(userAddressesPage.billingState);
        ReusableMethods.visibleWait(userAddressesPage.billingState,2);

        // ReusableMethods.click(userAddressesPage.billingState);
        ReusableMethods.waitForSecond(2);
        ExtentReportsListener.extentTestInfo("state kısmına geçerli veri secilir");
        ActionsUtils.scrollDown();
        //"SAVE ADDRESS" kutusu tiklanir
        userAddressesPage.billingSaveAdressButton.click();

        //    Addresses changed successfully yazisi gorulur

        Assert.assertTrue(userAddressesPage.firstNameAutomatically.isDisplayed(),"First name is a required field.");
        Assert.assertTrue(userAddressesPage.lastNameAutomatically.isDisplayed(),"Last name is a required field.");
        ExtentReportsListener.extentTestInfo("First name and last name do not come automatically in the first sign in process");








        // gecerli datalar girilir


        //userAddressesPage.billingCountry.sendKeys(ConfigReader.getProperty("country"));
        //userAddressesPage.billingAddress.sendKeys(ConfigReader.getProperty("streetaddress1"));
        //userAddressesPage.billingAddress2.sendKeys(ConfigReader.getProperty("streetaddress2"));
        //userAddressesPage.billingCity.sendKeys(ConfigReader.getProperty("city"));
        //userAddressesPage.billingState.sendKeys(ConfigReader.getProperty("state"));
        //userAddressesPage.billingZipCode.sendKeys(ConfigReader.getProperty("zipcode"));
        //userAddressesPage.billingPhone.sendKeys(ConfigReader.getProperty("phone"));



    }
}

   //   ActionsUtils.scrollDown();
     //   WaitUtils.waitFor(2);
     //   ActionsUtils.scrollEnd();
     //   WaitUtils.waitFor(2);
     //   WaitUtils.waitFor(2);
     //   ReusableMethods.click(homePage.myAccount);
     //   WaitUtils.waitFor(2);
     //   userAddressesPage.adresses.click();
     //   ReusableMethods.click(userAddressesPage.addBillingAddress);