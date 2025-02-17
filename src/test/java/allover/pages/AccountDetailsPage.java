package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDetailsPage {

    public AccountDetailsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h4[text()='Account Details']")
    public WebElement AccountDetailsPageControl;

    @FindBy(id = "account_first_name")
    public WebElement FirstName;

    @FindBy(id = "account_last_name")
    public WebElement LastName;

    @FindBy(id = "account_display_name")
    public WebElement DisplayName;

    @FindBy(id = "account_email")
    public WebElement EmailAddress;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement BiographyTextBox;
    @FindBy(xpath = "//*[@id=\"tinymce\"]/p/text()")
    public WebElement BiographyTextBoxIn;

    //-------------------VisualButton

    @FindBy(id = "user_description-tmce")
    public WebElement BiographyVisualButton;

    @FindBy(id = "mceu_0")
    public WebElement VisualDropDownButton;

    @FindBy(id = "mceu_1-button")
    public WebElement VisualBoldButton;

    @FindBy(id = "mceu_2-button")
    public WebElement VisualItalicButton;

    @FindBy(id = "mceu_3-button")
    public WebElement VisualBulletedListButton;

    @FindBy(id = "mceu_4-button")
    public WebElement VisualNumberedListButton;

    @FindBy(id = "mceu_5-button")
    public WebElement VisualParagrafButton;

    @FindBy(id = "mceu_6-button")
    public WebElement VisualAllignLeftButton;

    @FindBy(id = "mceu_7-button")
    public WebElement VisualAllignCentertButton;

    @FindBy(id = "mceu_8-button")
    public WebElement VisualAllignRightButton;

    @FindBy(id = "mceu_9-button")
    public WebElement VisualInsertButton;

    @FindBy(id = "mceu_10-button")
    public WebElement VisualInsertReadButton;

    @FindBy(id = "mceu_12-button")
    public WebElement VisualFullScreanButton;

    @FindBy(id = "mceu_12-button")
    public WebElement VisualToolbarTagleButton;

    //-------------------textButton
    @FindBy(id = "user_description-html")
    public WebElement BiographyTextButton;

    @FindBy(id = "qt_user_description_strong")
    public WebElement TextBoldButton;

    @FindBy(id = "qt_user_description_em")
    public WebElement TextItalicButton;

    @FindBy(id = "qt_user_description_link")
    public WebElement TextLinkButton;

    @FindBy(id = "qt_user_description_block")
    public WebElement TextBQuoteButton;

    @FindBy(id = "qt_user_description_del")
    public WebElement TextDelButton;

    @FindBy(id = "qt_user_description_ins")
    public WebElement TextInsButton;

    @FindBy(id = "qt_user_description_img")
    public WebElement TextIMGButton;

    @FindBy(id = "qt_user_description_ul")
    public WebElement TextULButton;

    @FindBy(id = "qt_user_description_ul")
    public WebElement TextOLButton;

    @FindBy(id = "qt_user_description_li")
    public WebElement TextLIButton;

    @FindBy(id = "qt_user_description_code")
    public WebElement TextCodeButton;

    @FindBy(id = "qt_user_description_more")
    public WebElement TextMoreButton;

    @FindBy(id = "qt_user_description_close")
    public WebElement TextCloseTagButton;

  @FindBy(id = "password_current")
    public WebElement CurrentPasswordTextBox;

  @FindBy(id = "password_1")
    public WebElement NewPasswordTextBox;

  @FindBy(id = "password_2")
    public WebElement ConfirmPasswordTextBox;

  @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement SaveButton;

@FindBy(xpath = "//div[@role='alert']")
    public WebElement SuccesfullyControl;

@FindBy(xpath = "//li[contains(@class, 'alert-danger')]")
    public WebElement VerifyControl;










}
