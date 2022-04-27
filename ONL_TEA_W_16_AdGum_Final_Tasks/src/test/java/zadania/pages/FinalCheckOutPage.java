package zadania.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class FinalCheckOutPage {

    private static WebDriver driver;

    public FinalCheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class=\"custom-radio\" ] /*[@type=\"radio\"]")
    private List<WebElement> aliasRadioElements;

    @FindBy(xpath = "//*[@class=\"address-alias h4\"]")
    private List<WebElement> aliasSearchingFields;

    public void selectProperAddress(String alias) {
        int properAliasIndex = -1;
        for (int i = 0; i < aliasSearchingFields.size(); i++) {
            String currentAlias = aliasSearchingFields.get(i).getText();
            if (Objects.equals(currentAlias, alias)) {
                properAliasIndex = i;
            }
        }
        aliasRadioElements.get(properAliasIndex).click();
    }

    @FindBy(xpath = "//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")
    private  WebElement continueToShippingMethodButton;

    public void goToShippingMethod(){
        continueToShippingMethodButton.click();
    }

    @FindBy(xpath = "//*[@class=\"h6 carrier-name\"]")
    private List<WebElement> deliverySearchHeaders;

    @FindBy(xpath = "//*[@class=\"col-sm-1\"]/*")
    private List<WebElement> deliveryRadioFields;

    public void selectProperDelivery(String alias) {
        int properDeliveryIndex = -1;
        for (int i = 0; i < deliverySearchHeaders.size(); i++) {
            String currentAlias = deliverySearchHeaders.get(i).getText();
            if (Objects.equals(currentAlias, alias)) {
                properDeliveryIndex = i;
            }
        }
        deliveryRadioFields.get(properDeliveryIndex).click();
    }

    @FindBy(xpath = "//*[@id=\"js-delivery\"]/button")
    WebElement continueToPaymentButton;

    public void goToPayment(){
        continueToPaymentButton.click();
    }

    @FindBy(xpath = "//*[contains(@for,\"payment-option\")]")
    private List<WebElement> paymentSearchHeaders;

    @FindBy(xpath = "//*[@class=\"ps-shown-by-js \"]")
    private List<WebElement> paymentRadioFields;

    public void selectProperPayment(String alias) {
        int properPaymentIndex = -1;
        for (int i = 0; i < paymentSearchHeaders.size(); i++) {
            String currentAlias = paymentSearchHeaders.get(i).getText();
            if (Objects.equals(currentAlias, alias)) {
                properPaymentIndex = i;
            }
        }
        paymentRadioFields.get(properPaymentIndex).click();
    }

    @FindBy(xpath = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")
    private WebElement termsOfServiceBox;

    public void acceptTermsOfService(){
        termsOfServiceBox.click();
    }

    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    private WebElement orderWithAnObligationToPayButton;

    public void confirmOrder(){
        orderWithAnObligationToPayButton.click();
    }

    public void takeScreenShot(String itemName, int quantity, String alias){

        String quant = Integer.toString(quantity);
        //downcast the driver to access TakesScreenshot method
        TakesScreenshot ts = (TakesScreenshot)driver;

        //capture screenshot as output type FILE
        File file = ts.getScreenshotAs(OutputType.FILE);

        try {
            //save the screenshot taken in destination path
            FileUtils.copyFile(file, new File("./ScreenShot_Folder/" + itemName + "-by-" + alias + "-" + quant +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
