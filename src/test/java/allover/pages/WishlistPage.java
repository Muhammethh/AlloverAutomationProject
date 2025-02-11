package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {

    public WishlistPage(){
        PageFactory.initElements(Driver.getDriver(),this);}


    @FindBy(xpath = "//a[@data-title='Add to wishlist']")
    public WebElement AddToWishlist;

    @FindBy(css = "button[title='Quick View']")
    public WebElement QuickView;

    @FindBy(xpath = "//a[contains(@class, 'add_to_cart')]")
    public WebElement AddToCartButton;

    @FindBy(css = "a.remove_from_wishlist")
    public WebElement RemoveFromWishlistButton;

    @FindBy(xpath = "//a[contains(text(), 'Checkout')]")
    public WebElement WishlistCheckout;




}
