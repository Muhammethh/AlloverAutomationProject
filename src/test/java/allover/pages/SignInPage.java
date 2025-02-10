package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[id='username']")
    public WebElement UsernameTextBox;

    @FindBy(css = "input[id='password']")
    public WebElement PasswordTextBox;

    @FindBy(css = "input[id='rememberme']")
    public WebElement RemembeMeCheckBox;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement SignInButton;

    @FindBy(xpath = "//button[@title='Close (Esc)']")
    public WebElement CloseButton;










}
