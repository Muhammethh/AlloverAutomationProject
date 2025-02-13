package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorRegistrationPage {

    public VendorRegistrationPage(){PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement VendorEmailTextBox;

    @FindBy(xpath = "//input[@id='passoword']")
    public WebElement VendorPasswordTextBox;

    @FindBy(xpath = "//input[@id='confirm_pwd']")
    public WebElement VendorConfirmPasswordTextBox;

    @FindBy(xpath = "//input[@name='wcfm_email_verified_input']")
    public WebElement VerificationCodeInput;

    @FindBy(xpath = "//input[@value='Re-send Code']")
    public WebElement ResendCodeButton;

    @FindBy(xpath = "//input[@value='Register']")
    public WebElement RegisterButton;

    @FindBy(xpath = "//div[contains(text(), 'Please provide a valid email address.')]")
    public WebElement WarningEmptyEmailBox;


    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement WarningEmailUsing;

    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement WarningInvalidVerification;


    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-success']")
    public WebElement SuccessRegistration;

}
