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

    @FindBy(xpath = "//input[@type='email']")
    public WebElement MailAddressTextBox;

    @FindBy(partialLinkText = "Become a Vendor")
    public WebElement BecomeVendorButton;

    @FindBy(xpath = "//input[@id='reg_password']")
    public WebElement PasswordTextBox;

    @FindBy(xpath="//a/span[text()='Sign In']")
    public WebElement signIn2 ;

    @FindBy(partialLinkText="My Account")
    public WebElement myAccount;

    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement StoreManagerButton;

    @FindBy(id = "add_new_product_dashboard")
    public WebElement addNewButton;

    @FindBy(id = "product_type")
    public WebElement productTypeDropdown;

    @FindBy(id = "is_virtual")
    public WebElement virtualOption;

    @FindBy(id = "is_downloadable")
    public WebElement downloadableOption;
    @FindBy(id = "pro_title") public WebElement proTitle;

    @FindBy(id = "regular_price")
    public WebElement regPrice;

    @FindBy(id = "sale_price")
    public WebElement salePrice;

    @FindBy(id = "product_cats[]")
    public WebElement category;

    @FindBy (xpath = "(//span[@class='text'])[4]")
    public WebElement ProductsButton;

}
