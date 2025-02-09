package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    public MyAccountPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//h2[text()='My Account']")
    public WebElement MyAccountTitle;

    @FindBy(xpath = "//a[text()='Dashboard']")
    public WebElement DashboardButton;

    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement StoreManagerButton;

    @FindBy(xpath = "//a[text()='Orders']")
    public WebElement OrdersButton;

    @FindBy(xpath = "//a[text()='Downloads']")
    public WebElement DownloadsButton;

    @FindBy(xpath = "//a[text()='Addresses']")
    public WebElement AddressesButton;

    @FindBy(xpath = "//a[text()='Account details']")
    public WebElement AccountDetailsButton;

    @FindBy(xpath = "(//a[text()='Wishlist'])[1]")
    public WebElement WishlistButton;

    @FindBy(xpath = "(//a[text()='Support Tickets']")
    public WebElement SupportTicketsButton;

    @FindBy(xpath = "(//a[text()='Followings']")
    public WebElement FollowingsButton;

    @FindBy(xpath = "(//a[text()='Logout']")
    public WebElement LogoutButton;



}


