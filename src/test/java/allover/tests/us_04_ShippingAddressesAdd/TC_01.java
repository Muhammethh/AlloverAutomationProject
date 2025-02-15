package allover.tests.us_04_ShippingAddressesAdd;

import allover.pages.HomePage;
import allover.pages.UserAddressesPage;
import allover.tests.SignInCustomer;
import allover.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class TC_01 extends SignInCustomer {



//"Addresses" sekmesi tiklanir
//"ADD" sekmesi tiklanir
//    First name alanına gecerli veri girilir
//    Last name alanı gecerli veri girilir
//    Company name alanina gecerli veri girilir
//    Country/Region seçilir.
//    Street address alanina gecerli veri girilir
//    Town/city alanina gecerli veri girilir
//    State secilir
//    ZIP Code alanina gecerli veri girilir
//"SAVE ADDRESS" kutusu tiklanir
//    Addresses changed successfully yazisi gorulur

    @Test
    public void test01() {

SignInCustomer.SignIn();

        HomePage homePage = new HomePage();
        ReusableMethods.click();
        UserAddressesPage userAddressesPage=new UserAddressesPage();
        userAddressesPage.adresses.click();
        ReusableMethods.click();
    }
}
