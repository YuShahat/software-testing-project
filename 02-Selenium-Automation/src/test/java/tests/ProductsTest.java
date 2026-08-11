package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import utils.WaitUtils;

public class ProductsTest extends BaseTest {

    @Test
    public void testAddProductToCart() {

        // 1. Open Automation Exercise
        driver.get("https://www.automationexercise.com/");

        // 2. Open Login Page
        By loginLink = By.xpath("//a[@href='/login']");

        WaitUtils.waitForElementToBeClickable(
                driver,
                loginLink,
                10
        ).click();

        // 3. Login
        By emailField =
                By.xpath("//input[@data-qa='login-email']");

        By passwordField =
                By.xpath("//input[@data-qa='login-password']");

        By loginButton =
                By.xpath("//button[@data-qa='login-button']");

        WebElement email =
                WaitUtils.waitForElementToBeVisible(
                        driver,
                        emailField,
                        10
                );

        WebElement password =
                WaitUtils.waitForElementToBeVisible(
                        driver,
                        passwordField,
                        10
                );

        email.sendKeys("youssefshahat8@gmail.com");
        password.sendKeys("QgsC129*");

        WaitUtils.waitForElementToBeClickable(
                driver,
                loginButton,
                10
        ).click();

        // 4. Verify Login
        By loggedInUser =
                By.xpath("//a[contains(text(),'Logged in as')]");

        Assert.assertTrue(
                WaitUtils.waitForElementToBeVisible(
                        driver,
                        loggedInUser,
                        10
                ).isDisplayed(),
                "Login Failed!"
        );

        System.out.println("LOGIN TEST PASSED");

        // 5. Open Products
        ProductsPage productsPage =
                new ProductsPage(driver);

        productsPage.clickProducts();

        // 6. Verify Products Page
        Assert.assertEquals(
                productsPage.getPageTitleText().trim(),
                "ALL PRODUCTS",
                "Products page was not opened!"
        );

        System.out.println("PRODUCTS PAGE TEST PASSED");

        // 7. Add First Product
        productsPage.addProductToCart();

        // 8. Continue Shopping
        productsPage.clickContinueShopping();

        // 9. Open Cart
        productsPage.clickCartIcon();

        // 10. Verify Cart Page
        By cartPageTitle =
                By.xpath("//li[contains(@class,'active') and contains(text(),'Shopping Cart')]");

        Assert.assertTrue(
                WaitUtils.waitForElementToBeVisible(
                        driver,
                        cartPageTitle,
                        10
                ).isDisplayed(),
                "Cart page was not opened!"
        );

        System.out.println("PRODUCT TEST PASSED");
    }
}