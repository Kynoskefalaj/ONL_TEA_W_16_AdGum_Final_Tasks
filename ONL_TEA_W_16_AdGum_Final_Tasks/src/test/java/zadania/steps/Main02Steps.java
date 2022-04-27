package zadania.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Utils;
import zadania.pages.*;


public class Main02Steps {

    private WebDriver driver;
    private double priceBeforeDiscount;
    private double priceAfterDiscount;
    private String orderReference;
    private int quantity;
    private String itemName;
    private String alias;
    private static CreateAddressPage createAddressPage;
    private static UserAddressPage userAddressPage;
    private static UserHomePage userHomePage;
    private static SearchResultsPage searchResultsPage;
    private static ItemPage itemPage;
    private static CheckOutPage checkOutPage;
    private static CartPage cartPage;
    private static FinalCheckOutPage finalCheckOutPage;
    private static OrderConfirmationPage orderConfirmationPage;
    private static OrderHistoryPage orderHistoryPage;


    @Given("user is logged in")
    public void userIsLoggedIn() {
        driver = Utils.createChromeDriver();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        createAddressPage = new CreateAddressPage(driver);
        userAddressPage = new UserAddressPage(driver);
        userHomePage = new UserHomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        itemPage = new ItemPage(driver);
        checkOutPage = new CheckOutPage(driver);
        cartPage = new CartPage(driver);
        finalCheckOutPage = new FinalCheckOutPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
        orderHistoryPage = new OrderHistoryPage(driver);


        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.enterEmail("kwiszatzhaderach@gmail.com");
        authenticationPage.enterPassword("Ghost123");
        authenticationPage.submit();
    }

    @When("user goes to {} page")
    public void userGoesToItemPage(String itemName) {
        userHomePage.searchFor(itemName);
        userHomePage.searchingSubmit();
        searchResultsPage.goToItemPage(itemName);
        this.itemName = itemName;
    }

    @And("user selects {} and {}")
    public void userSelectsPiecesAndSize(int quantity, String size) {
        try {
            itemPage.setSize(size);
        }
        catch (org.openqa.selenium.NoSuchElementException ex) {
            System.out.println("Produkt nie posiada rozmiaru.");
        }
        finally {
            itemPage.setQuantity(quantity);
            this.quantity = quantity;
        }
    }

    @And("user adds items to cart")
    public void userAddsItemsToCart() {
        itemPage.proceedToTheCart();
    }

    @And("discount equals {} in percent")
    public void discountEqualsDiscountInPercent(double discount) {

        priceBeforeDiscount = checkOutPage.getPriceBeforeDiscount();
        priceAfterDiscount = checkOutPage.getPriceAfterDiscount();
        double properPriceAfterDiscount = Utils.round(priceBeforeDiscount * quantity * (100 - discount) / 100, 2);

        if (properPriceAfterDiscount == priceAfterDiscount) {
            System.out.println("Rabat naliczono poprawnie.");

        } else {
            Assert.fail("Rabat nie został naliczony poprawnie. Poprawna cena po zniżce: " +
                    properPriceAfterDiscount + ", cena naliczona: " + priceAfterDiscount);
        }
    }

    @When("user goes to checkout")
    public void userGoesToCheckout() {
        cartPage.goToCheckout();
    }

    @And("user confirms address by {}")
    public void userConfirmsAddress(String alias) {
        finalCheckOutPage.selectProperAddress(alias);
        this.alias = alias;
    }

    @And("user chooses {} method")
    public void userChoosesPickUpMethod(String delivery) {
        finalCheckOutPage.goToShippingMethod();
        finalCheckOutPage.selectProperDelivery(delivery);
    }

    @And("user chooses {} definition")
    public void userChoosesPaymentDefinition(String payment) {
        finalCheckOutPage.goToPayment();
        finalCheckOutPage.selectProperPayment(payment);
    }

    @And("user confirms order")
    public void userConfirmsOrder() {
        finalCheckOutPage.acceptTermsOfService();
        finalCheckOutPage.confirmOrder();
    }

    @Then("screenshot with order confirmation and total cost")
    public void screenshotWithOrderConfirmationAndTotalCost() throws Exception {

        finalCheckOutPage.takeScreenShot(itemName, quantity, alias);
        orderReference = orderConfirmationPage.getOrderReference();
    }

    @And("user goes to order history")
    public void userGoesToOrderHistory() {
        orderConfirmationPage.goToUserHomePage();
        userHomePage.goToHistory();

    }

    @And("check if order is awaiting for {}")
    public void checkIfOrderIsAwaitingForPayment(String payment) {
        orderHistoryPage.checkIfOrderAddedToHistory(orderReference, payment);
        driver.quit();


    }
}
