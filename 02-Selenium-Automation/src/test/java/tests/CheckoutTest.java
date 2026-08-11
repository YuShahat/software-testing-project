package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCompleteCheckout() {

        // ==========================================
        // 1. Open Login Page
        // ==========================================

        driver.get("https://www.automationexercise.com/login");

        // ==========================================
        // 2. Login
        // ==========================================

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "youssefshahat8@gmail.com",
                "QgsC129*"
        );

        // ==========================================
        // 3. Verify Login
        // ==========================================

        Assert.assertTrue(
                loginPage.isLoggedIn(),
                "Login Failed!"
        );

        System.out.println("LOGIN PASSED");

        // ==========================================
        // 4. Open Products
        // ==========================================

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.clickProducts();

        Assert.assertEquals(
                productsPage.getPageTitleText().trim(),
                "ALL PRODUCTS",
                "Products page was not opened!"
        );

        System.out.println("PRODUCTS PAGE PASSED");

        // ==========================================
        // 5. Add First Product To Cart
        // ==========================================

        productsPage.addProductToCart();

        System.out.println("PRODUCT ADDED TO CART");

        // ==========================================
        // 6. Continue Shopping
        // ==========================================

        productsPage.clickContinueShopping();

        // ==========================================
        // 7. Open Cart
        // ==========================================

        productsPage.clickCartIcon();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(
                cartPage.isCartPageDisplayed(),
                "Cart page was not opened!"
        );

        System.out.println("CART PAGE PASSED");

        // ==========================================
        // 8. Proceed To Checkout
        // ==========================================

        cartPage.clickProceedToCheckout();

        System.out.println("CHECKOUT PAGE OPENED");

        // ==========================================
        // 9. Place Order
        // ==========================================

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.placeOrder(
                "Youssef Shahat",
                "4111111111111111",
                "123",
                "12",
                "2028"
        );

        // ==========================================
        // 10. Verify Order
        // ==========================================

        Assert.assertTrue(
                checkoutPage.isOrderPlacedSuccessfully(),
                "Checkout was not completed successfully!"
        );

        System.out.println("CHECKOUT TEST PASSED");
    }
}