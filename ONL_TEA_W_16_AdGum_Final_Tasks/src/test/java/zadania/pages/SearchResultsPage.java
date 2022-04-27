package zadania.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class SearchResultsPage {

    private static WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class=\"product-description\"]/h2/a")
    private List<WebElement> itemHeaders;

    public void goToItemPage(String itemName){
        for (int i = 0; i < itemHeaders.size(); i++ ) {
            String headerText = itemHeaders.get(i).getText();
            if (Objects.equals(headerText, itemName)) {
                itemHeaders.get(i).click();
            } else {
                Assert.fail("Nie znaleziono produktu.");
            }
        }
    }
}
