package zadania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class UserAddressPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@data-link-action=\"add-address\"]")
    private WebElement createNewAddressField;

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement notificationField;

    @FindBy(xpath = "(//*[@class=\"address-footer\"]/*)[last()]")
    private WebElement deleteLastAddressField;

    public boolean isThereCreateNewAddressField() {
        if (Objects.equals(driver.getCurrentUrl(), "https://mystore-testlab.coderslab.pl/index.php?controller=addresses")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAddressCorrectlyAdded() {
        String createNewAddressFieldOutput = createNewAddressField.getText();
        if (Objects.equals(createNewAddressFieldOutput, "Address successfully added!")) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteLastAddress() {
        deleteLastAddressField.click();
    }

    public boolean isAddressCorrectlyDeleted() {
        String createNewAddressFieldOutput = createNewAddressField.getText();
        if (Objects.equals(createNewAddressFieldOutput, "Address successfully deleted!")) {
            return true;
        } else {
            return false;
        }
    }


    public void goToAddressEdition() {
        createNewAddressField.click();
    }

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement confirmationField;

    public boolean isAddressSuccessfullyAdded(){
        if (confirmationField.getText() == "Address succesfully added!") {
            return true;
        } else {
            return false;
        }
    }

    public UserAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
