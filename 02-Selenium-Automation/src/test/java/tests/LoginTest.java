package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {

        LoginPage loginPage = new LoginPage(driver);

        // Open Login page
        driver.get(
                ConfigReader.getProperty("url") + "/login"
        );

        // Get credentials from config
        String email =
                ConfigReader.getProperty("email");

        String password =
                ConfigReader.getProperty("password");

        // Login
        loginPage.login(email, password);

        // Verify successful login
        boolean loginSuccessful =
                driver.getPageSource().contains("Logged in as");

        System.out.println("======================================");
        System.out.println("Login Test Result");
        System.out.println("======================================");
        System.out.println("Email used: " + email);
        System.out.println(
                "Login Successful: " + loginSuccessful
        );
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("======================================");

        Assert.assertTrue(
                loginSuccessful,
                "Login was not successful!"
        );
    }
}