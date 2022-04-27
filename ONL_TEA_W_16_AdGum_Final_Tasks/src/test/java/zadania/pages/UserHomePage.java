package zadania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {

    private static WebDriver driver;

    @FindBy(xpath = "(//*[@class=\"link-item\"])[2]/*")
    private WebElement addressesTile;

    public void goToAddresses() {
        addressesTile.click();
    }

    @FindBy(name = "s")
    private WebElement searchInput;

    public void searchFor(String itemName) {
        searchInput.sendKeys(itemName);
    }

    public void searchingSubmit() {
        searchInput.submit();
    }

    public UserHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"history-link\"]/span/i")
    private WebElement historyTile;

    public void goToHistory(){
        historyTile.click();
    }
}
