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

    @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[1]")
    public WebElement addBillingAddress;

    @FindBy(id = "billing_first_name_field")
    public WebElement billingfirstnamefield;


    @FindBy(linkText="Add")
    public WebElement add2;


    @FindBy(id="shipping_first_name")
    public WebElement shippingFirstName;

    @FindBy(id="billing_first_name")
    public WebElement billingFirstName;




    @FindBy(id="shipping_last_name")
    public WebElement shippingLastName;

    @FindBy(id="billing_last_name")
    public WebElement billingLastName;



    @FindBy(id="shipping_company")
    public WebElement shippingCompanyName;

    @FindBy(id="billing_company")
    public WebElement billingCompanyName;



    @FindBy(id="select2-shipping_country-container")
    public WebElement shippingCountry;

    @FindBy(id="select2-billing_country-container")
    public WebElement billingCountry;




    @FindBy(id="shipping_address_1")
    public WebElement shippingAddress;

    @FindBy(id="billing_address_1")
    public WebElement billingAddress;


    @FindBy(id="shipping_address_2")
    public WebElement shippingAddress2;

    @FindBy(id="billing_address_2")
    public WebElement billingAddress2;




    @FindBy(id="select2-shipping_state-container")
    public WebElement shippingState;

    @FindBy(id="billing_state")
    public WebElement billingState;


    @FindBy(id="shipping_postcode")
    public WebElement shippingZipCode;

    @FindBy(id="billing_postcode")
    public WebElement billingZipCode;

    @FindBy(id ="billing_phone")
    public WebElement billingPhone;

    @FindBy(id ="billing_city")
    public WebElement billingCity;




    @FindBy(id="woocommerce-edit-address-nonce")
    public WebElement shippingSaveAdress;

    @FindBy(xpath = "//button[@value='Save address']")
    public WebElement billingSaveAdressButton;

    @FindBy(xpath = "(//input)[3]") public WebElement firstNameAutomatically;
    @FindBy(xpath = "(//input[@class='input-text '])[2]") public WebElement lastNameAutomatically;

    //@FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/address[1]/table[1]/tbody[1]/tr[3]/th[1]")
    //public WebElement writingbillingcity;

    //@FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/address[1]/table[1]/tbody[1]/tr[3]/th[1]")
    //public WebElement writingshippingcity;



}
