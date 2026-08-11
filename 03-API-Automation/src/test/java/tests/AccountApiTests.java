package tests;

import apiConfig.BaseApi;
import endpoints.Routes;
import payloads.PayloadData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountApiTests extends BaseApi {

    @Test(description = "Verify account creation API")
    public void createAccount() {

        Response response = getRequestSpecification()
                .formParam("name", "API Test User")
                .formParam("email", "api.test.user.automation@gmail.com")
                .formParam("password", "Test@12345")
                .formParam("title", "Mr")
                .formParam("birth_date", "15")
                .formParam("birth_month", "5")
                .formParam("birth_year", "1998")
                .formParam("firstname", "API")
                .formParam("lastname", "Test")
                .formParam("company", "Automation Project")
                .formParam("address1", "Test Address")
                .formParam("address2", "Test Address 2")
                .formParam("country", "India")
                .formParam("zipcode", "12345")
                .formParam("state", "Test State")
                .formParam("city", "Test City")
                .formParam("mobile_number", "01000000000")
                .when()
                .post(Routes.CREATE_ACCOUNT);

        String responseBody = response.getBody().asString();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Create Account Response:");
        System.out.println(responseBody);

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Expected HTTP status code 200"
        );

        Assert.assertTrue(
                responseBody.contains("\"responseCode\""),
                "Response should contain responseCode"
        );
    }
}