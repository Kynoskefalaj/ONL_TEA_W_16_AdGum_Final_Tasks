package zadania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

private static WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    private WebElement userTagField;

    public void goToUserHomePage(){
        userTagField.click();
    }

    @FindBy(xpath = "//*[@id=\"order-details\"]/ul/li[1]")
    private WebElement orderReferenceElement;

    public String getOrderReference(){
        String innerText = orderReferenceElement.getText();
        String orderReference = innerText.substring(17,innerText.length());
        return orderReference;
    }

}
