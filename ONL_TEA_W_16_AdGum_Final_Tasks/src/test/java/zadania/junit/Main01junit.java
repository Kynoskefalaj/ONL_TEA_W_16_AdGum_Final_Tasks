package zadania.junit;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import utils.Utils;
import zadania.pages.AuthenticationPage;
import zadania.pages.CreateAddressPage;
import zadania.pages.UserAddressPage;
import zadania.pages.UserHomePage;

public class Main01junit {

    //Zadanie pierwsze wykonane przy uyciu Page Object Pattern,
    //PageFactory oraz JUnit

    private static WebDriver driver;
    private static CreateAddressPage createAddressPage;
    private static AuthenticationPage authenticationPage;
    private static UserAddressPage userAddressPage;

    @BeforeAll
    public static void setUp() {
        driver = Utils.createChromeDriver();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        createAddressPage = new CreateAddressPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        userAddressPage = new UserAddressPage(driver);
    }

    @AfterAll
    public static void ending() {
        driver.quit();
    }

    @Test
    public void login() {
        authenticationPage.enterEmail("kwiszatzhaderach@gmail.com");
        authenticationPage.enterPassword("Ghost123");
        authenticationPage.submit();
    }

    @Test
    public void goToAddresses() {
        login();
        UserHomePage userHomePage = new UserHomePage(driver);
        userHomePage.goToAddresses();
    }

    @Test
    public void createAddress() {
        goToAddresses();
        if (userAddressPage.isThereCreateNewAddressField()) {
            userAddressPage.goToAddressEdition();
        }
        createAddressPage.enterAlias("The Bastard");
        createAddressPage.enterAddress("Winterfell 9/19");
        createAddressPage.enterCity("Winterfell");
        createAddressPage.enterPostalCode("00-001");
        createAddressPage.enterPhone("123 567 864");
        createAddressPage.selectCountry();
        createAddressPage.submit();

        if (userAddressPage.isAddressCorrectlyAdded()) {
            Assert.fail("Address was not added");
        }
    }

}
