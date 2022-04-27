package zadania.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class OrderHistoryPage {

    private static WebDriver driver;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    private WebElement userTagField;

    public void goToUserHomePage() {
        userTagField.click();
    }

    @FindBy(xpath = "//*[@scope=\"row\"]")
    private List<WebElement> referencesFields;

    @FindBy(xpath = "//*[@class=\"label label-pill bright\"]")
    private List<WebElement> paymentStatusesFields;

    public void checkIfOrderAddedToHistory(String orderReference, String payment) {
        int properOrderIndex = -1;
        for (int i = 0; i < referencesFields.size(); i++) {
            String currentOrderReference = referencesFields.get(i).getText();
            if (Objects.equals(currentOrderReference, orderReference)) {
                properOrderIndex = i;
            }
        }
        String orderStatus = paymentStatusesFields.get(properOrderIndex).getText();
        if (Objects.equals(payment, "Pay by bank wire")) {
            if (Objects.equals(orderStatus, "Awaiting bank wire payment")) {
                System.out.println("Zamówienie dodano do historii.");
                System.out.println("Status płatności zamówienia jest prawidłowy.");
                System.out.println("Status płatności: " + orderStatus);
            }
            else if (Objects.equals(orderStatus, "Awaiting check payment")) {
                System.out.println("Zamówienie dodano do historii.");
                System.out.println("Status płatności zamówienia jest prawidłowy.");
                System.out.println("Status płatności: " + orderStatus);
            } else {
                Assert.fail("Zamówienie nie zostało poprawnie dodane do historii zamówień!");
            }
        }
    }
}
