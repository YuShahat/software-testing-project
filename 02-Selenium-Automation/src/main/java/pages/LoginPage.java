package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;

    // ==========================================
    // Home Page
    // ==========================================

    private By signupLoginButton =
            By.xpath("//a[@href='/login']");

    // ==========================================
    // Login Form
    // ==========================================

    private By emailField =
            By.xpath("//input[@data-qa='login-email']");

    private By passwordField =
            By.xpath("//input[@data-qa='login-password']");

    private By loginButton =
            By.xpath("//button[@data-qa='login-button']");

    // ==========================================
    // Logged In User
    // ==========================================

    private By loggedInUser =
            By.xpath("//a[contains(text(),'Logged in as')]");

    // ==========================================
    // Constructor
    // ==========================================

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==========================================
    // Open Login Page
    // ==========================================

    public void openLoginPage() {

        WaitUtils.waitForElementToBeClickable(
                driver,
                signupLoginButton,
                10
        ).click();
    }

    // ==========================================
    // Enter Email
    // ==========================================

    public void enterEmail(String email) {

        WaitUtils.waitForElementToBeVisible(
                driver,
                emailField,
                10
        ).sendKeys(email);
    }

    // ==========================================
    // Enter Password
    // ==========================================

    public void enterPassword(String password) {

        WaitUtils.waitForElementToBeVisible(
                driver,
                passwordField,
                10
        ).sendKeys(password);
    }

    // ==========================================
    // Click Login
    // ==========================================

    public void clickLogin() {

        WaitUtils.waitForElementToBeClickable(
                driver,
                loginButton,
                10
        ).click();
    }

    // ==========================================
    // Complete Login
    // ==========================================

    public void login(String email, String password) {

        openLoginPage();

        enterEmail(email);

        enterPassword(password);

        clickLogin();
    }

    // ==========================================
    // Verify Login
    // ==========================================

    public boolean isLoggedIn() {

        try {

            WaitUtils.waitForElementToBeVisible(
                    driver,
                    loggedInUser,
                    10
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}