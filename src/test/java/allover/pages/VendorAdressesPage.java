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

    @FindBy(xpath="//a[text()='Edit Your Billing Address']")
    public WebElement editYourBilling ;

    @FindBy(xpath = "//a[text()='Edit Your Shipping Address']")
    public WebElement getEditYourShipping ;

    @FindBy(id="billing_first_name")
    public WebElement firstName ;

    @FindBy(id="billing_last_name")
    public WebElement lastName ;

    @FindBy(id="billing_company")
    public WebElement companyName ;

    @FindBy(id="billing_country")
    public WebElement country ;


    @FindBy(id="billing_address_1")
    public WebElement streetAdress1 ;

    @FindBy(id="billing_address_2")
    public WebElement streetAdress2 ;

    @FindBy(id="billing_city")
    public WebElement townCity;


    @FindBy(id="billing_state")
    public WebElement state;


    @FindBy(id="billing_postcode")
    public WebElement zipCode;


    @FindBy(id="billing_phone")
    public WebElement phone;


    @FindBy(xpath="//input[@id='billing_email']")
    public WebElement email;


    @FindBy(name="save_address")
    public WebElement saveButton;


    @FindBy(css="div[role='alert']")
    public WebElement changedSuccessfully;




    @FindBy(css="li.alert.alert-danger")
    public WebElement zipcodeverfy;

    @FindBy(xpath="(//table)[1]")
    public WebElement verfyEmail;

    @FindBy(xpath="(//table)[1]")
    public WebElement verfyName;

    /////////////

    @FindBy(id="shipping_first_name")
    public WebElement shippingfirstName ;

    @FindBy(id="shipping_last_name")
    public WebElement shippinglastName ;

    @FindBy(id="shipping_company")
    public WebElement shippingcompanyName ;

    @FindBy(id="shipping_country")
    public WebElement shippingcountry ;


    @FindBy(id="shipping_address_1")
    public WebElement shippingstreetAdress1 ;

    @FindBy(id="shipping_address_2")
    public WebElement shippingstreetAdress2 ;

    @FindBy(id="shipping_city")
    public WebElement shippingtownCity;


    @FindBy(id="shipping_state")
    public WebElement shippingstate;


    @FindBy(id="shipping_postcode")
    public WebElement shippingzipCode;


    @FindBy(id="shipping_phone")
    public WebElement shippingphone;

}
