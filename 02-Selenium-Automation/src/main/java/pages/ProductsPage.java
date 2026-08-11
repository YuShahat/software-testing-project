package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class ProductsPage {

    private WebDriver driver;

    // ==========================================
    // Automation Exercise Locators
    // ==========================================

    private By productsTitle =
            By.xpath("//h2[contains(text(),'All Products')]");

    private By firstProductAddToCart =
            By.xpath("(//a[contains(@class,'add-to-cart')])[1]");

    private By continueShoppingButton =
            By.xpath("//button[contains(text(),'Continue Shopping')]");

    private By cartButton =
            By.xpath("//a[contains(@href,'/view_cart')]");

    // ==========================================
    // Constructor
    // ==========================================

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==========================================
    // Click Products
    // ==========================================

    public void clickProducts() {

        By productsLink =
                By.xpath("//a[@href='/products']");

        WaitUtils.waitForElementToBeClickable(
                driver,
                productsLink,
                10
        ).click();
    }

    // ==========================================
    // Verify Products Page
    // ==========================================

    public String getPageTitleText() {

        return WaitUtils.waitForElementToBeVisible(
                driver,
                productsTitle,
                10
        ).getText();
    }

    // ==========================================
    // Add First Product To Cart
    // ==========================================

    public void addProductToCart() {

        WaitUtils.waitForElementToBeClickable(
                driver,
                firstProductAddToCart,
                10
        ).click();
    }

    // ==========================================
    // Continue Shopping
    // ==========================================

    public void clickContinueShopping() {

        try {

            WaitUtils.waitForElementToBeClickable(
                    driver,
                    continueShoppingButton,
                    5
            ).click();

        } catch (Exception e) {
            // Modal may not appear depending on page state.
        }
    }

    // ==========================================
    // Open Cart
    // ==========================================

    public void clickCartIcon() {

        WaitUtils.waitForElementToBeClickable(
                driver,
                cartButton,
                10
        ).click();
    }
}