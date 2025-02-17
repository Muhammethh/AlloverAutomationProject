package allover.pages;

import allover.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SampleItemsPage {

    public SampleItemsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Searchboxda herhangi bişey aratıldıktan sonra ki ilk ürün
    @FindBy(xpath = "//ul[@data-col-list=' row cols-sm-1 cols-2']/li[1]")
    public WebElement firstItemAfterSearch;

    //Searchboxda herhangi bişey aratıldıktan sonra ki ikinci ürün
    @FindBy(xpath = "//ul[@data-col-list=' row cols-sm-1 cols-2']/li[2]")
    public WebElement secondItemAfterSearch;

    //Searchboxda herhangi bişey aratıldıktan sonra ki üçüncü ürün
    @FindBy(xpath = "//ul[@data-col-list=' row cols-sm-1 cols-2']/li[3]")
    public WebElement thirdItemAfterSearch;

    //Searchboxda herhangi bişey aratıldıktan sonra ki dördüncü ürün
    @FindBy(xpath = "//ul[@data-col-list=' row cols-sm-1 cols-2']/li[4]")
    public WebElement fourthItemAfterSearch;

    //Searchboxda herhangi bişey aratıldıktan sonra ki beşinci ürün
    @FindBy(xpath = "//ul[@data-col-list=' row cols-sm-1 cols-2']/li[5]")
    public WebElement fifthItemAfterSearch;

    //Searchboxda herhangi bişey aratıldıktan sonra ki altıncı ürün
    @FindBy(xpath = "//ul[@data-col-list=' row cols-sm-1 cols-2']/li[6]")
    public WebElement sixthItemAfterSearch;

    //ilk ürünün üzerine gelince çıkan sepete ekle butonu
    @FindBy(xpath = "(//div[@class='product-action-vertical']/a)[1]")
    public WebElement addFirstItemInCart;

    //Geçersiz ürün girildiğinde çıkan No products were found yazısı
    @FindBy(xpath = "//p[@class='alert alert-light alert-info woocommerce-info']")
    public WebElement noProductWereFoundWriting;

    // Compare button on the product page


    @FindBy(xpath ="(//a[@title='Compare'])[1]" )
    public WebElement compareButton1;

    @FindBy(xpath ="(//a[@title='Compare'])[2]")
    public WebElement compareButton2;

    @FindBy(css ="body > div:nth-child(10) > main:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > figure:nth-child(1) > div:nth-child(3) > a:nth-child(3)")
    public WebElement compareButton3;

    @FindBy(css ="body > div:nth-child(10) > main:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(4) > div:nth-child(1) > figure:nth-child(1) > div:nth-child(3) > a:nth-child(3)")
    public WebElement compareButton4;

    // Start compare button in the pop-up window
    @FindBy(xpath= "//a[contains(@class,'btn btn-dark btn-rounded')]")
    public WebElement startCompareButton;
@FindBy(xpath= "//a[contains(@class,'compare-clean')]")
    public WebElement cleanAllCompareButton;

}
