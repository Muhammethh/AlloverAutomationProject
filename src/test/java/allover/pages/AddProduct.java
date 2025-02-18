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

    @FindBy(xpath = "//input[@id='reg_password']")
    public WebElement PasswordTextBox;

    @FindBy(partialLinkText="My Account")
    public WebElement myAccount;

    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement StoreManagerButton;

    @FindBy(xpath = "//*[@id=\"product_type\"]")
    public WebElement SimpleProduct;

    @FindBy(xpath = "//input[@id='pro_title']")
    public WebElement ProductTitle;

    @FindBy(xpath = "//*[@id=\"regular_price\"]")
    public WebElement PriceVendor;

    @FindBy(xpath = "//input[@id='sale_price']")
    public WebElement SalePriceVendor;

    @FindBy(xpath = "//img[@id='featured_img_display']")
    public WebElement ChooseImage;

    @FindBy(xpath = "//*[@id=\"menu-item-browse\"]")
    public WebElement MediaLibrary;

    @FindBy(xpath = "//img[contains(@src, 'redshirt-9-150x150.png')]")
    public WebElement TshirtFoto;

    @FindBy(xpath = "//*[@id=\"__wp-uploader-id-0\"]/div[4]/div/div[2]/button")
    public WebElement SelecVendorFoto;

    @FindBy(xpath = "//*[@id=\"gallery_img_gimage_0_display\"]")
    public WebElement AddtoGalaleryVendor;

    @FindBy(xpath = "//*[@id=\"__attachments-view-436\"]/li[25]/div")
    public WebElement TshirtFoto2;

    @FindBy(xpath = "//*[@id=\"__wp-uploader-id-3\"]/div[4]/div/div[2]/button")
    public WebElement AddtoGallery;

    @FindBy(xpath = "//input[@value='1086']")
    public WebElement Categories123;

    @FindBy(xpath = "//input[@value='1509']")
    public WebElement Productbrands001;

    @FindBy(xpath = "//input[@id='wcfm_products_simple_submit_button']")
    public WebElement SubmitAddProduct;

    @FindBy(xpath = "//*[@id=\"description_ifr\"]")
    public WebElement ShortDescription;

    @FindBy(css = ".your-success-message-class")
    public WebElement message;


}
