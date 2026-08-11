package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CartPage {

    private WebDriver driver;

    // ==========================================
    // Cart Page - Automation Exercise
    // ==========================================

    private By cartPageTitle =
            By.xpath("//li[contains(@class,'active') and contains(text(),'Shopping Cart')]");

    private By proceedToCheckoutButton =
            By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    // ==========================================
    // Constructor
    // ==========================================

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==========================================
    // Verify Cart Page
    // ==========================================

    public boolean isCartPageDisplayed() {

        try {

            return WaitUtils.waitForElementToBeVisible(
                    driver,
                    cartPageTitle,
                    10
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // ==========================================
    // Proceed To Checkout
    // ==========================================

    public void clickProceedToCheckout() {

        WaitUtils.waitForElementToBeClickable(
                driver,
                proceedToCheckoutButton,
                10
        ).click();
    }

    // ==========================================
    // Complete Cart Step
    // ==========================================

    public void proceedToCheckout() {

        clickProceedToCheckout();
    }
}