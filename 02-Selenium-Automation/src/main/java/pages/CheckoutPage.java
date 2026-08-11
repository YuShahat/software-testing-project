package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CheckoutPage {

    private WebDriver driver;

    // ==========================================
    // Checkout Page
    // ==========================================

    private By placeOrderButton =
            By.xpath("//a[contains(text(),'Place Order')]");

    // ==========================================
    // Payment Information
    // ==========================================

    private By cardNameField =
            By.xpath("//input[@data-qa='name-on-card']");

    private By cardNumberField =
            By.xpath("//input[@data-qa='card-number']");

    private By cvcField =
            By.xpath("//input[@data-qa='cvc']");

    private By expiryMonthField =
            By.xpath("//input[@data-qa='expiry-month']");

    private By expiryYearField =
            By.xpath("//input[@data-qa='expiry-year']");

    private By payAndConfirmButton =
            By.xpath("//button[@data-qa='pay-button']");

    // ==========================================
    // Order Confirmation
    // ==========================================

    private By orderSuccessMessage =
            By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");

    // ==========================================
    // Constructor
    // ==========================================

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==========================================
    // Place Order
    // ==========================================

    public void clickPlaceOrder() {

        WaitUtils.waitForElementToBeClickable(
                driver,
                placeOrderButton,
                10
        ).click();
    }

    // ==========================================
    // Enter Card Name
    // ==========================================

    public void enterCardName(String name) {

        WaitUtils.waitForElementToBeVisible(
                driver,
                cardNameField,
                10
        ).sendKeys(name);
    }

    // ==========================================
    // Enter Card Number
    // ==========================================

    public void enterCardNumber(String cardNumber) {

        WaitUtils.waitForElementToBeVisible(
                driver,
                cardNumberField,
                10
        ).sendKeys(cardNumber);
    }

    // ==========================================
    // Enter CVC
    // ==========================================

    public void enterCVC(String cvc) {

        WaitUtils.waitForElementToBeVisible(
                driver,
                cvcField,
                10
        ).sendKeys(cvc);
    }

    // ==========================================
    // Enter Expiry Month
    // ==========================================

    public void enterExpiryMonth(String month) {

        WaitUtils.waitForElementToBeVisible(
                driver,
                expiryMonthField,
                10
        ).sendKeys(month);
    }

    // ==========================================
    // Enter Expiry Year
    // ==========================================

    public void enterExpiryYear(String year) {

        WaitUtils.waitForElementToBeVisible(
                driver,
                expiryYearField,
                10
        ).sendKeys(year);
    }

    // ==========================================
    // Pay And Confirm
    // ==========================================

    public void clickPayAndConfirm() {

        WaitUtils.waitForElementToBeClickable(
                driver,
                payAndConfirmButton,
                10
        ).click();
    }

    // ==========================================
    // Verify Successful Order
    // ==========================================

    public boolean isOrderPlacedSuccessfully() {

        try {

            return WaitUtils.waitForElementToBeVisible(
                    driver,
                    orderSuccessMessage,
                    15
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // ==========================================
    // Get Success Message
    // ==========================================

    public String getSuccessMessage() {

        return WaitUtils.waitForElementToBeVisible(
                driver,
                orderSuccessMessage,
                15
        ).getText();
    }

    // ==========================================
    // Complete Payment
    // ==========================================

    public void placeOrder(
            String cardName,
            String cardNumber,
            String cvc,
            String expiryMonth,
            String expiryYear
    ) {

        clickPlaceOrder();

        enterCardName(cardName);
        enterCardNumber(cardNumber);
        enterCVC(cvc);
        enterExpiryMonth(expiryMonth);
        enterExpiryYear(expiryYear);

        clickPayAndConfirm();
    }
}