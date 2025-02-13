package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='reg_username']")
    public WebElement UsernameTextBox;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement MailAddressTextBox;

    @FindBy(xpath = "//input[@id='reg_password']")
    public WebElement PasswordTextBox;

    @FindBy(css = "input[id='register-policy']")
    public WebElement AgreeCheckBox;

    @FindBy(xpath = "(//button[@value='Sign Up'])[1]")
    public WebElement SignUpButton;

    @FindBy(partialLinkText = "Signup as a vendor?")
    public WebElement VendorSignUpButton;

    @FindBy(partialLinkText = "Become a Vendor")
    public WebElement BecomeVendorButton;

    @FindBy(xpath = "(//p[@class='submit-status'])[2]")
    public WebElement RegistrationCheck;













}
