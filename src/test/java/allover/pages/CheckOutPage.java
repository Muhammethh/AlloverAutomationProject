package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    public CheckOutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "billing_first_name")
    public WebElement firstNameTextBox;

    @FindBy(id = "billing_last_name")
    public WebElement lastNameTextBox;

    @FindBy(id = "billing_company")
    public WebElement companyNameTextBox;

    @FindBy(id = "select2-billing_country-container")
    public WebElement countryRegionDropDown;

    @FindBy(id = "billing_address_1")
    public WebElement streetAddressTextBox;

    @FindBy(id = "billing_city")
    public WebElement cityTextBox;

    @FindBy(id = "select2-billing_state-container")
    public WebElement stateDropDown;

    @FindBy(id = "billing_postcode")
    public WebElement zipCodeTextBox;

    @FindBy(id = "billing_phone")
    public WebElement phoneTextBox;

    @FindBy(id = "billing_email")
    public WebElement emailTextBox;

    @FindBy(id = "payment_method_bacs")
    public WebElement wireTransferEftSelect;

    @FindBy(xpath = "//input[@id='payment_method_cod']")
    public WebElement payAtDoorSelect;

    @FindBy(id = "place_order")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//*[contains(text(), 'Thank you. Your order has been received.')]")
    public WebElement orderCompletedText;


}
