package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="(//input[@type='search'])[1]")
    public WebElement searchBox ;

    @FindBy(xpath="//a[@class='wishlist block-type']")
    public WebElement whishlistHead ;

    @FindBy(xpath="(//i[@class='w-icon-cart'])[1]")
    public WebElement cartHead;

    @FindBy(xpath="//a/span[text()='Sign In']")
    public WebElement signIn ;

    @FindBy (xpath ="//a/span[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(xpath="//a/span[text()='Register']")
    public WebElement register ;


    @FindBy(partialLinkText="Cart")
    public WebElement cartFoot ;

    @FindBy(partialLinkText="My Orders")
    public WebElement myOrders ;

    @FindBy(partialLinkText="Wishlist")
    public WebElement wishlistFoot ;

    @FindBy(partialLinkText="My Account")
    public WebElement myAccount;

    @FindBy(tagName = "body")
    public WebElement body;







}
