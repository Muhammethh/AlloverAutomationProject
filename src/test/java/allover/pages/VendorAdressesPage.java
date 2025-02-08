package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorAdressesPage {

    public VendorAdressesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText="Addresses")
    public WebElement adresses;

    @FindBy(partialLinkText="Edit Your Billing Address")
    public WebElement editYourBilling ;

    @FindBy(partialLinkText="Edit Your Shipping Address")
    public WebElement getEditYourShipping ;

    @FindBy(id="billing_first_name")
    public WebElement firstName ;

    @FindBy(id="billing_last_name")
    public WebElement lastName ;

    @FindBy(id="billing_company")
    public WebElement companyName ;

    @FindBy(id="select2-billing_country-container")
    public WebElement country ;

    @FindBy(id="billing_address_1")
    public WebElement streetAdress1 ;

    @FindBy(id="billing_address_2")
    public WebElement streetAdress2 ;

    @FindBy(xpath="//a[@class='wishlist block-type']")
    public WebElement whishlistHead ;

}
