package allover.tests.us_06_ShoppingTests;

import allover.pages.HomePage;
import allover.pages.SampleItemsPage;
import allover.tests.SignInCustomer;
import allover.utilities.Driver;
import allover.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02 {

    @Test
    public void TC_02_InvalidSearch1() {

        HomePage homePage = new HomePage();
        SampleItemsPage sampleItemsPage = new SampleItemsPage();

        SignInCustomer.SignIn();

        //Sign Out butonu görünene kadar beklenir ve göründüğü doğrulanır
        WaitUtils.waitForVisibility(homePage.signOut, 10);

        Assert.assertTrue(homePage.signOut.isDisplayed());

        //Search Bara geçersiz bir ürün ismi girilir
        homePage.searchBox.sendKeys("nnnn", Keys.ENTER);

        //Ürün çıkmadığı doğrulanır
        Assert.assertTrue(sampleItemsPage.noProductWereFoundWriting.isDisplayed());

        Driver.closeDriver();


    }
}
