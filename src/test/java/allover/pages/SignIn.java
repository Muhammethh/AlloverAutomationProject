package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {

    public SignIn() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[id='username']")
    public WebElement UsernameTextBox;










}
