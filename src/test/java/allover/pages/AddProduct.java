package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProduct {

    public AddProduct() { PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath="//a/span[text()='Sign In']")
    public WebElement signIn ;

    //@FindBy(xpath = "//input[@id='reg_username']")
    //public WebElement UsernameTextBox;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement MailAddressTextBox;

    @FindBy(xpath = "//input[@id='reg_password']")
    public WebElement PasswordTextBox;

    @FindBy(xpath="//a/span[text()='Sign In']")
    public WebElement signIn2 ;

    @FindBy(partialLinkText="My Account")
    public WebElement myAccount;

    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement StoreManagerButton;

    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement NewAddButton;

    @FindBy(css = "input[id='register-policy']")
    public WebElement AgreeCheckBox;

    @FindBy(partialLinkText = "Become a Vendor")
    public WebElement BecomeVendorButton;






    @FindBy(xpath="//a/span[text()='Register']")
    public WebElement register ;



    @FindBy (xpath = "(//span[@class='text'])[4]")
    public WebElement ProductsButton;

}
