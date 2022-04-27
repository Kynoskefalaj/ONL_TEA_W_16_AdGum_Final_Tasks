package zadania.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class ItemPage {

    private static WebDriver driver;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class=\"form-control form-control-select\"]/*")
    private List<WebElement> sizeDropDownElements;


    @FindBy(xpath = "//*[@id=\"group_1\"]")
    private WebElement sizeDropDown;


    public void setSize(String size){
        sizeDropDown.click();
        sizeDropDown.sendKeys(size);
    }
//    public void setSize(String size) {
//        String selectedSize = "";
//        try {
//            for (int i = 0; i < sizeDropDownElements.size(); i++) {
//                String sizeText = sizeDropDownElements.get(i).getText();
//
//                if (Objects.equals(sizeText, size)) {
//                    //                System.out.println("udalo sie");
//                    //                sizeDropDown.click();
//                    sizeDropDownElements.get(i).click();
//                    selectedSize = sizeText;
//                }}
//                sizeDropDownElements.get(0);
//                if (Objects.equals(selectedSize, "")) {
//                    Assert.fail("Nie znaleziono produktu.");
//                }
//        } catch (IndexOutOfBoundsException exception1) {
//            System.out.println("Ten produkt nie posiada rozmiaru");
//        }
//    }

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    private WebElement quantityInput;

    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    private WebElement addToCartButton;

    public void setQuantity(int quantity) {
        quantityInput.click();
//        quantityInput.clear(); czemu clear --> sendkeys nie działa?
        quantityInput.sendKeys("\b" + Integer.toString(quantity));
        addToCartButton.click();
    }

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement proceedToCheckOutButton;

    public void proceedToTheCart() {
        proceedToCheckOutButton.click();
    }

}
