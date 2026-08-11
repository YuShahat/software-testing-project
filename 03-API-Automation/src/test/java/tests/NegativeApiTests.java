package tests;

import apiConfig.BaseApi;
import endpoints.Routes;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeApiTests extends BaseApi {

    @Test(description = "Login with missing email")
    public void loginWithMissingEmail() {

        Response response = getRequestSpecification()
                .formParam("password", "test123")
                .when()
                .post(Routes.VERIFY_LOGIN);

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Missing Email Response:");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals(
                response.jsonPath().getInt("responseCode"),
                400
        );
    }

    @Test(description = "Login with missing password")
    public void loginWithMissingPassword() {

        Response response = getRequestSpecification()
                .formParam("email", "test@example.com")
                .when()
                .post(Routes.VERIFY_LOGIN);

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Missing Password Response:");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals(
                response.jsonPath().getInt("responseCode"),
                400
        );
    }

    @Test(description = "Login with invalid credentials")
    public void loginWithInvalidCredentials() {

        Response response = getRequestSpecification()
                .formParam("email", "invalid@example.com")
                .formParam("password", "wrongpassword")
                .when()
                .post(Routes.VERIFY_LOGIN);

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Invalid Login Response:");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals(
                response.jsonPath().getInt("responseCode"),
                404
        );
    }

    @Test(description = "Search product with empty search term")
    public void searchProductWithEmptySearchTerm() {

        Response response = getRequestSpecification()
                .formParam("search_product", "")
                .when()
                .post(Routes.SEARCH_PRODUCT);

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Empty Search Response:");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals(
                response.jsonPath().getInt("responseCode"),
                200
        );
    }
}