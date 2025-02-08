package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Shopping Cart")
    public WebElement shoppingCartText;

    @FindBy(partialLinkText = "Checkout")
    public WebElement checkoutText;

    @FindBy(xpath = "(//table[1]/tbody/tr[1]/td[1])[1]")
    public WebElement firstItemInCart;

    @FindBy(xpath = "(//table[1]/tbody/tr[2]/td[1])[1]")
    public WebElement secondItemInCart;

    @FindBy(xpath = "(//button[@title='Minus'])[1]")
    public WebElement decreaseQuantityInCart;

    @FindBy(xpath = "(//button[@title='Plus'])[1]")
    public WebElement increaseQuantityInCart;

    @FindBy(xpath = "//i[@class='w-icon-long-arrow-left']")
    public WebElement continueShopping;

    @FindBy(partialLinkText = "Clear cart")
    public WebElement clearCartButton;

    @FindBy(partialLinkText = "Update cart")
    public WebElement updateCartButton;

    @FindBy(id = "coupon_code")
    public WebElement couponTextBox;

    @FindBy(partialLinkText = "Apply coupon")
    public WebElement applyCouponButton;

    @FindBy(partialLinkText = " Proceed to checkout ")
    public WebElement proceedToCheckoutButton;





}
