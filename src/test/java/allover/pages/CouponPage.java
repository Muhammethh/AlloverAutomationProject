package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CouponPage {
    public CouponPage () {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[normalize-space()='Coupons']")
    public WebElement CouponButton;

    @FindBy(xpath = "//span[@class='text' and text()='Add New']")
   public WebElement AddNewButton;

    //@FindBy (xpath = "//span[text()='Add New']")
   //public WebElement AddNewButton;

    @FindBy (xpath = "//input[@id='title']")
    public WebElement CodeTextBox;

    @FindBy (xpath = "//input[@id='description']")
    public WebElement DescriptionTextArea;

    @FindBy(xpath = "//input[@id='discount_type']")
    public WebElement DropdownInput;

    @FindBy(xpath = "//ul[@class='wcfm-select wcfm_ele']//li[contains(text(),'Seçenek 1')]")
    public WebElement DropdownOption;

    @FindBy(xpath = "//input[@id='coupon_amount']")
    public WebElement AmountTextBox;

    @FindBy(xpath = "//input[@id='expiry_date']")
    public WebElement ExpirydateTextBox;

    @FindBy(xpath = "//input[@id='free_shipping']")
    public WebElement AllowfreeshippingCheckBox;

    @FindBy(xpath = "//input[@id='show_on_store']")
    public WebElement ShowonstoreCheckBox;


}
