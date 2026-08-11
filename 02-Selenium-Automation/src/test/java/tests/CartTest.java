package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import utils.WaitUtils;

public class CartTest extends BaseTest {

    @Test
    public void testProductInCart() {

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

        WaitUtils.waitForElementToBeVisible(
                driver,
                emailField,
                10
        ).sendKeys("youssefshahat8@gmail.com");

        WaitUtils.waitForElementToBeVisible(
                driver,
                passwordField,
                10
        ).sendKeys("QgsC129*");

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

        System.out.println("LOGIN PASSED");

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

        System.out.println("PRODUCTS PAGE PASSED");

        // 7. Add First Product To Cart
        productsPage.addProductToCart();

        System.out.println("PRODUCT ADDED TO CART");

        // 8. Continue Shopping if modal appears
        productsPage.clickContinueShopping();

        // 9. Open Cart
        productsPage.clickCartIcon();

        // 10. Verify Cart Page
        By cartPage =
                By.xpath("//li[contains(@class,'active') and contains(text(),'Shopping Cart')]");

        Assert.assertTrue(
                WaitUtils.waitForElementToBeVisible(
                        driver,
                        cartPage,
                        10
                ).isDisplayed(),
                "Cart page was not opened!"
        );

        // 11. Verify product exists inside cart
        By cartProduct =
                By.xpath("//table[@id='cart_info_table']//tbody/tr");

        Assert.assertTrue(
                WaitUtils.waitForElementToBeVisible(
                        driver,
                        cartProduct,
                        10
                ).isDisplayed(),
                "Product was not found in cart!"
        );

        System.out.println("CART TEST PASSED");
    }
}