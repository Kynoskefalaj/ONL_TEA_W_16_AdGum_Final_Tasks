package zadania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {

    private static WebDriver driver;

    @FindBy(xpath = "(//input[@name=\"email\"])[1]")
    private WebElement emailInput;

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    @FindBy(name = "password")
    private WebElement passwordInput;

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    public void submit() {
        signInButton.click();
    }

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
