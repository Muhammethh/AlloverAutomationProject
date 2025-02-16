package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAddressesPage {

    public UserAddressesPage() {PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText="Addresses")
    public WebElement adresses;

    @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]")
    public WebElement addShippingAddress2;


    @FindBy(linkText="Add")
    public WebElement add2;


    @FindBy(id="shipping_first_name")
    public WebElement shippingFirstName;


    @FindBy(id="shipping_last_name")
    public WebElement shippingLastName;



    @FindBy(id="shipping_company")
   public WebElement shippingCompanyName;

    @FindBy(id="select2-shipping_country-container")
    public WebElement shippingCountry;


    @FindBy(id="shipping_address_1")
    public WebElement shippingAddress;


    @FindBy(id="shipping_address_2")
    public WebElement shippingAddress2;

    @FindBy(id="select2-shipping_state-container")
    public WebElement shippingState;


    @FindBy(id="shipping_postcode")
    public WebElement shippingZipCode;

    @FindBy(id="woocommerce-edit-address-nonce")
    public WebElement shippingSaveAdress;

}
