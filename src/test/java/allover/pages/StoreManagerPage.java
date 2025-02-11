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





}
