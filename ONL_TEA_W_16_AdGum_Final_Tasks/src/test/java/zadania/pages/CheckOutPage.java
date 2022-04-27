package zadania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    private static WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[1]/span[1]")
    private WebElement priceBeforeDiscount;

    public double getPriceBeforeDiscount(){
        String stringValue = priceBeforeDiscount.getText();
        String stringValueWithoutEuro = stringValue.substring(1,stringValue.length());
        double doubleValueWithoutEuro = Double.parseDouble(stringValueWithoutEuro);
        return doubleValueWithoutEuro;

    }

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[1]/div[2]/div[1]/span[2]")
    private WebElement priceAfterDiscount;

    public double getPriceAfterDiscount(){
        String  stringValue = priceAfterDiscount.getText();
        String stringValueWithoutEuro = stringValue.substring(1,stringValue.length());
        double doubleValueWithoutEuro = Double.parseDouble(stringValueWithoutEuro);
        return doubleValueWithoutEuro;
    }
}
