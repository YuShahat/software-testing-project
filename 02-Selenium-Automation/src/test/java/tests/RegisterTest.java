package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void testUserRegistration() throws InterruptedException {

        RegisterPage registerPage = new RegisterPage(driver);

        // ==========================================
        // 1. Open Automation Exercise
        // ==========================================
        driver.get("https://automationexercise.com/login");

        System.out.println("======================================");
        System.out.println("START REGISTRATION TEST");
        System.out.println("======================================");

        // ==========================================
        // 2. Generate unique registration data
        // ==========================================
        String timestamp = String.valueOf(System.currentTimeMillis());

        String name = "Youssef";
        String email = "youssef" + timestamp + "@example.com";
        String password = "SecurePass123";

        System.out.println("Registration Email: " + email);

        // ==========================================
        // 3. New User Signup
        // ==========================================
        registerPage.enterName(name);
        registerPage.enterSignupEmail(email);
        registerPage.clickSignup();

        // ==========================================
        // 4. Account Information
        // ==========================================
        registerPage.selectTitle();

        registerPage.enterPassword(password);

        registerPage.selectDateOfBirth(
                "10",
                "May",
                "1998"
        );

        registerPage.selectNewsletter();
        registerPage.selectSpecialOffers();

        registerPage.enterFirstName("Youssef");
        registerPage.enterLastName("Shahat");

        registerPage.enterCompany("E-Commerce Testing");

        registerPage.enterAddress("Cairo");
        registerPage.enterAddress2("Nasr City");

        registerPage.selectCountry("India");

        registerPage.enterState("Cairo");
        registerPage.enterCity("Cairo");
        registerPage.enterZipcode("11765");
        registerPage.enterMobileNumber("01012345678");

        // ==========================================
        // 5. Create Account
        // ==========================================
        registerPage.clickCreateAccount();

        // Give website time to process
        Thread.sleep(3000);

        // ==========================================
        // 6. Registration Result
        // ==========================================
        String currentUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();
        String pageSource = driver.getPageSource();

        boolean accountCreated =
                pageSource.contains("ACCOUNT CREATED!");

        System.out.println();
        System.out.println("======================================");
        System.out.println("REGISTRATION RESULT");
        System.out.println("======================================");

        System.out.println("Email Used: " + email);
        System.out.println("Current URL: " + currentUrl);
        System.out.println("Page Title: " + pageTitle);
        System.out.println(
                "ACCOUNT CREATED Found: " + accountCreated
        );

        System.out.println("======================================");

        // IMPORTANT:
        // No Assert for now.
        // We are only checking what the website returns.
    }
}