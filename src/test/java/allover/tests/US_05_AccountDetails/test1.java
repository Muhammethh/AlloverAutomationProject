package allover.tests.US_05_AccountDetails;

import allover.pages.AccountDetailsPage;
import allover.tests.SignInCustomer;
import allover.utilities.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {

    @Test
    public void testName() {

        AccountDetailsPage accountDetailsPage=new AccountDetailsPage();
        Faker faker=new Faker();
        SignInCustomer.SignIn();

        WaitUtils.waitFor(3);

        Driver.getDriver().get("https://www.allovercommerce.com/my-account-2/edit-account/");
        accountDetailsPage.FirstName.sendKeys(faker.name().firstName());
        accountDetailsPage.LastName.sendKeys(faker.name().lastName());
        accountDetailsPage.DisplayName.sendKeys(faker.name().username());

        ReusableMethods.waitForSecond(3);
        ActionsUtils.scrollEnd();

        accountDetailsPage.SaveButton.submit();
        WaitUtils.waitFor(3);
        Assert.assertTrue(accountDetailsPage.SuccesfullyControl.getText().contains("successfully"));




    }
}
