package zadania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAddressPage {

    private static WebDriver driver;

    @FindBy(xpath = "//*[@data-link-action=\"add-address\"]")
    private WebElement createNewAddressField;

    public void goToAddressEdition() {
        createNewAddressField.click();
    }

    @FindBy(name = "alias")
    private WebElement aliasInput;

    public void enterAlias(String alias) {
        aliasInput.sendKeys(alias);
    }

    @FindBy(name = "address1")
    private WebElement addressInput;

    public void enterAddress(String address) {
        addressInput.sendKeys(address);
    }

    @FindBy(name = "city")
    private WebElement cityInput;

    public void enterCity(String city) {
        cityInput.sendKeys(city);
    }

    @FindBy(name = "postcode")
    private WebElement postalCodeInput;

    public void enterPostalCode(String postcode) {
        postalCodeInput.sendKeys(postcode);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select/option[2]")
    private WebElement countrySelection;

    public void selectCountry() {
        countrySelection.click();
    }

    @FindBy(name = "phone")
    private WebElement phoneInput;

    public void enterPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement submitButton;

    public void submit() {
        submitButton.click();
    }


    public CreateAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
