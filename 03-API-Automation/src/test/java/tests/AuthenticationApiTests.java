package tests;

import apiConfig.BaseApi;
import endpoints.Routes;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationApiTests extends BaseApi {

    @Test(description = "Verify login with invalid credentials")
    public void verifyLoginWithInvalidCredentials() {

        Response response = getRequestSpecification()
                .formParam("email", "invalid@example.com")
                .formParam("password", "wrongPassword")
                .when()
                .post(Routes.VERIFY_LOGIN);

        String responseBody = response.getBody().asString();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Invalid Login Response:");
        System.out.println(responseBody);

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Expected HTTP status code 200"
        );

        Assert.assertTrue(
                responseBody.contains("\"responseCode\": 404"),
                "Expected API responseCode 404 for invalid credentials"
        );

        Assert.assertTrue(
                responseBody.contains("User not found!"),
                "Expected 'User not found!' message"
        );
    }

    @Test(description = "Verify login with missing email")
    public void verifyLoginWithMissingEmail() {

        Response response = getRequestSpecification()
                .formParam("password", "test123")
                .when()
                .post(Routes.VERIFY_LOGIN);

        String responseBody = response.getBody().asString();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Missing Email Response:");
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

    @Test(description = "Verify login with missing password")
    public void verifyLoginWithMissingPassword() {

        Response response = getRequestSpecification()
                .formParam("email", "test@example.com")
                .when()
                .post(Routes.VERIFY_LOGIN);

        String responseBody = response.getBody().asString();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Missing Password Response:");
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