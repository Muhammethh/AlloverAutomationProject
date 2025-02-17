package allover.tests.us_06_ShoppingTests;

import allover.tests.SignInCustomer;
import allover.utilities.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Notations {

    @BeforeMethod
    public void beforeClass() {
       //Herseyden önce BeforeSuite notasyonuna sahip method 1 kez calisir
        SignInCustomer.SignIn();

    }

    @AfterMethod
    public void afterClass(){

        Driver.closeDriver();

    }


}
