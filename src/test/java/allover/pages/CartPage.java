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

    //Sağda çıkan küçük sepet penceresinde ki View cart butonu
    @FindBy(xpath = "//a[@class='button wc-forward']")
    public WebElement ViewCartButton;

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

    @FindBy(xpath = "//button[@name='apply_coupon']")
    public WebElement applyCouponButton;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    public WebElement proceedToCheckoutButton;

    @FindBy(css = "#quantity_67aca7c11c18d")
    public WebElement quantityofItem;

    @FindBy(xpath = "//li[@class=' alert alert-simple alert-icon alert-close-top alert-danger']")
    public WebElement couponAlertMessage;

    @FindBy(xpath = "(//table)[2]")
    public WebElement totalverify;



    @FindBy(xpath = "//h2[text()='Order details']")
    public WebElement orderdetails;







}
