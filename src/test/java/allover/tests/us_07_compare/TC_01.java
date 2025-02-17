package allover.tests.us_07_compare;

import allover.pages.HomePage;
import allover.pages.SampleItemsPage;
import allover.pages.SignInPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.security.spec.ECPrivateKeySpec;

public class TC_01 {


    //Kullanici en fazla 4 urunu karsilastirmak icin secebilmeli

    @Test
    public void test01() {
        SignInCustomer.SignIn();
        HomePage homePage = new HomePage();
        WaitUtils.waitForVisibility(homePage.signOut,5);

        homePage.searchBox.sendKeys("pencil", Keys.ENTER);

        SampleItemsPage sampleItemsPage = new SampleItemsPage();
        ActionsUtils.hoverOver(sampleItemsPage.firstItemAfterSearch);
        sampleItemsPage.compareButton1.click();
        Driver.getDriver().navigate().refresh();
        WaitUtils.waitFor(3);
        //Actions actions = new Actions(Driver.getDriver());
        //actions.moveByOffset(10, 10).click().perform();
        //homePage.body.click();

        ActionsUtils.hoverOver(sampleItemsPage.secondItemAfterSearch);
       ReusableMethods.click(sampleItemsPage.compareButton2);
        Driver.getDriver().navigate().refresh();
        WaitUtils.waitFor(3);


        ActionsUtils.hoverOver(sampleItemsPage.thirdItemAfterSearch);
        ReusableMethods.click(sampleItemsPage.compareButton3);
        Driver.getDriver().navigate().refresh();
        WaitUtils.waitFor(3);
        ActionsUtils.pressTab();


        ActionsUtils.hoverOver(sampleItemsPage.fourthItemAfterSearch);
        WaitUtils.waitForVisibility(sampleItemsPage.compareButton4,3);
        ReusableMethods.click(sampleItemsPage.compareButton4);


        JSUtils.JSscrollIntoView(sampleItemsPage.startCompareButton);
        //ReusableMethods.click(sampleItemsPage.startCompareButton);

        ReusableMethods.click(sampleItemsPage.cleanAllCompareButton);
        //sampleItemsPage.cleanAllCompareButton.click();


        //deneme


    }
}
