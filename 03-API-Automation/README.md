# E-Commerce API Automation Framework

API automation testing framework built using **Java, REST Assured, TestNG, and Maven**.

## Tech Stack

- Java 21
- REST Assured
- TestNG
- Maven
- ExtentReports
- GitHub Actions

## API Test Coverage

- Authentication APIs
- Account APIs
- Products APIs
- Product Search
- Brands APIs
- Positive & Negative Testing
- Response & Status Code Validation

## Test Results

| Metric | Result |
|---|---:|
| Total Tests | 11 |
| Passed | 11 |
| Failed | 0 |
| Skipped | 0 |
| Pass Rate | 100% |

**BUILD SUCCESS ✅**

## Reports & Documentation

- Extent HTML Report
- Test Cases
- Bug Report
- Test Summary

## Run Tests

```bash
mvn clean test

## CI/CD

GitHub Actions automatically runs the API test suite on every push to the `main` branch.

## Postman Collection

You can find the ready-to-use Postman Collection for manual testing and validation in the project repository:
- **Collection File:** `[Path to your json file, e.g., Postman/Automation_Exercise.json]`
- **How to Use:** 
  1. Open Postman.
  2. Click on **Import** and select the JSON file from the project.
  3. Run and test all endpoints directly!