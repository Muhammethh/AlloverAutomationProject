package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreManagerPage {

    public StoreManagerPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//span[@class='text'])[4]")
    public WebElement ProductsButton;

    @FindBy (xpath = "//input[@aria-controls='wcfm-products']")
    public WebElement SearchBox;

    @FindBy (xpath = "//a[text()='Tea Maker']")
    public WebElement TeaMaker;

    @FindBy (xpath = "//label[@class='wcfmfa fa-database']")
    public WebElement InventoryButton;

    @FindBy (xpath = "(//div[@class='page_collapsible_content_holder'])[4]")
    public WebElement ShippingButton;

    @FindBy (xpath = "//label[@class='wcfmfa fa-server']")
    public WebElement AttributesButton;

    @FindBy (xpath = "//label[@class='wcfmfa fa-link']")
    public WebElement LinkedButton;

    @FindBy (xpath = "//label[@class='wcfma fa-globe']")
    public WebElement SeoButton;

    @FindBy (xpath = "//label[@class='wcfmfa fa-th-large']")
    public WebElement AdvancedButton;

    @FindBy (xpath = "//input[@id='sku']")
    public WebElement SkuTextBox;

    @FindBy (xpath = "//input[@id='manage_stock']")
    public WebElement ManageStockCheckBox;

    @FindBy (id = "stock_qty")
    public WebElement StockQtyTextBox;


    @FindBy (id = "backorders")
    public WebElement AllowBackorders;

    @FindBy (xpath = "//input[@id='sold_individually']")
    public WebElement SoldIndividually;

    @FindBy (xpath = "//input[@id='wcfm_products_simple_submit_button']")
    public WebElement SubmitButton;

    @FindBy (css = "[name='weight']")
    public WebElement WeightTextBox;

    @FindBy (css = "[name='length']")
    public WebElement LengthTextBox;

    @FindBy (css = "[name='width']")
    public WebElement WidthTextBox;

    @FindBy (css = "[name='height']")
    public WebElement HeightTextBox;

    @FindBy (xpath = "//option[@value='_no_shipping_class']")
    public WebElement ShippingClass;

    @FindBy (xpath = "//select[@id='_wcfmmp_processing_time']")
    public WebElement ProcessingTime;

    @FindBy (xpath = "//input[@id='attributes_is_active_1']")
    public WebElement ColorButton;

    @FindBy (xpath = "(//input[@class='select2-search__field' and @placeholder='Search for an attribute ...'])[1]")
    public WebElement ColorSearchBox;

    @FindBy (xpath = "(//button[contains(text(),'Select all')])[1]")
    public WebElement SelectAllButton1;

    @FindBy (id = "attributes_is_active_2")
    public WebElement SizeButton;

    @FindBy (xpath = "//input[@type='checkbox' and @id='attributes_is_active_2']")
    public WebElement SizeSearchBox;

    @FindBy (xpath = "(//button[contains(text(),'Select all')])[2]")
    public WebElement SelectAllButton2;

    @FindBy (xpath = "//input[@type='checkbox' and @id='attributes_is_visible_1']")
    public WebElement ColorVisibleOnSearchBoxButton;

    @FindBy (xpath = "//a[@class='wcfm_menu_item active']")
    public WebElement CouponButton;


























}
