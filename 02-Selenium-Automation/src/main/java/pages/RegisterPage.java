package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class RegisterPage {

    private WebDriver driver;

    // Step 1 - New User Signup
    private By nameField = By.name("name");
    private By emailField = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");

    // Step 2 - Account Information
    private By titleMr = By.id("id_gender1");
    private By passwordField = By.id("password");

    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");

    private By newsletterCheckbox = By.id("newsletter");
    private By offersCheckbox = By.id("optin");

    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By addressField = By.id("address1");
    private By address2Field = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");

    private By createAccountButton =
            By.xpath("//button[@data-qa='create-account']");

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Step 1
    public void enterName(String name) {
        WaitUtils.waitForElementToBeVisible(driver, nameField, 10)
                .sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        WaitUtils.waitForElementToBeVisible(driver, emailField, 10)
                .sendKeys(email);
    }

    public void clickSignup() {
        WaitUtils.waitForElementToBeClickable(driver, signupButton, 10)
                .click();
    }

    // Step 2
    public void selectTitle() {
        WaitUtils.waitForElementToBeClickable(driver, titleMr, 10)
                .click();
    }

    public void enterPassword(String password) {
        WaitUtils.waitForElementToBeVisible(driver, passwordField, 10)
                .sendKeys(password);
    }

    public void selectDateOfBirth(String day, String month, String year) {

        driver.findElement(dayDropdown)
                .sendKeys(day);

        driver.findElement(monthDropdown)
                .sendKeys(month);

        driver.findElement(yearDropdown)
                .sendKeys(year);
    }

    public void selectNewsletter() {
        driver.findElement(newsletterCheckbox).click();
    }

    public void selectSpecialOffers() {
        driver.findElement(offersCheckbox).click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterCompany(String company) {
        driver.findElement(companyField).sendKeys(company);
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void enterAddress2(String address2) {
        driver.findElement(address2Field).sendKeys(address2);
    }

    public void selectCountry(String country) {
        driver.findElement(countryDropdown).sendKeys(country);
    }

    public void enterState(String state) {
        driver.findElement(stateField).sendKeys(state);
    }

    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        driver.findElement(zipcodeField).sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }

    public void clickCreateAccount() {
        WaitUtils.waitForElementToBeClickable(
                driver,
                createAccountButton,
                10
        ).click();
    }
}