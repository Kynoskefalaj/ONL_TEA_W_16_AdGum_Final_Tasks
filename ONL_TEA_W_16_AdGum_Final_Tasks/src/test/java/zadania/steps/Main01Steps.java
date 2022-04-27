package zadania.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Utils;
import zadania.pages.AuthenticationPage;
import zadania.pages.CreateAddressPage;
import zadania.pages.UserAddressPage;
import zadania.pages.UserHomePage;

public class Main01Steps {

    private WebDriver driver;
    private static CreateAddressPage createAddressPage;
    private static UserAddressPage userAddressPage;
    private static UserHomePage userHomePage;

    @Given("user is on login home page")
    public void userIsOnLoginHomePage() {
        driver = Utils.createChromeDriver();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        createAddressPage = new CreateAddressPage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        userAddressPage = new UserAddressPage(driver);
        userHomePage = new UserHomePage(driver);

        authenticationPage.enterEmail("kwiszatzhaderach@gmail.com");
        authenticationPage.enterPassword("Ghost123");
        authenticationPage.submit();
    }

    @When("user clicks +Create new address button")
    public void userClicksCreateNewAddressButton() {
        userHomePage.goToAddresses();
    }

    @When("user fills New address with {}, {}, {}, {}, {}, {}")
    public void userFillsNewAddressWithAliasAddressCityPostalCodeCountryPhone(String alias, String address, String city, String postalCode, String country, String phone) {

        if (userAddressPage.isThereCreateNewAddressField()) {
            userAddressPage.goToAddressEdition();
        }
        createAddressPage.enterAlias(alias);
        createAddressPage.enterAddress(address);
        createAddressPage.enterCity(city);
        createAddressPage.enterPostalCode(postalCode);
        createAddressPage.enterPhone(phone);
        createAddressPage.selectCountry();
        createAddressPage.submit();
    }

    @Then("added address must be added correctly")
    public void addedAddressMustBeAddedCorrectly() {
        if (userAddressPage.isAddressCorrectlyAdded()) {
            Assert.fail("Address was not added");
        }
    }

    @And("added last address is deleted")
    public void addedLastAddressIsDeleted() {
        userAddressPage.deleteLastAddress();
        if (userAddressPage.isAddressCorrectlyDeleted()) {
            Assert.fail("Last address was not deleted");
        }
        driver.quit();
    }
}
