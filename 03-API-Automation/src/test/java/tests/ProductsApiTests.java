package tests;

import apiConfig.BaseApi;
import endpoints.Routes;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsApiTests extends BaseApi {

    @Test(description = "Verify products list API")
    public void getProductsList() {

        Response response = getRequestSpecification()
                .when()
                .get(Routes.PRODUCTS_LIST);

        String responseBody = response.getBody().asString();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Products API Response:");
        System.out.println(responseBody);

        // Validate HTTP status
        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Expected HTTP status code 200"
        );

        // Validate API response code
        Assert.assertTrue(
                responseBody.contains("\"responseCode\": 200"),
                "API responseCode should be 200"
        );

        // Validate products object
        Assert.assertTrue(
                responseBody.contains("\"products\""),
                "Response should contain products"
        );

        // Validate product data
        Assert.assertTrue(
                responseBody.contains("\"id\": 1"),
                "Response should contain product ID"
        );

        Assert.assertTrue(
                responseBody.contains("\"name\": \"Blue Top\""),
                "Response should contain product name"
        );

        Assert.assertTrue(
                responseBody.contains("\"price\": \"Rs. 500\""),
                "Response should contain product price"
        );
    }

    @Test(description = "Verify product search API")
    public void searchProduct() {

        Response response = getRequestSpecification()
                .formParam("search_product", "top")
                .when()
                .post(Routes.SEARCH_PRODUCT);

        String responseBody = response.getBody().asString();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Search Product API Response:");
        System.out.println(responseBody);

        // Validate HTTP status
        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Expected HTTP status code 200"
        );

        // Validate API response code
        Assert.assertTrue(
                responseBody.contains("\"responseCode\": 200"),
                "API responseCode should be 200"
        );

        // Validate products object
        Assert.assertTrue(
                responseBody.contains("\"products\""),
                "Search response should contain products"
        );

        // Validate search results
        Assert.assertTrue(
                responseBody.toLowerCase().contains("top"),
                "Search response should contain products related to 'top'"
        );
    }

    @Test(description = "Verify brands list API")
    public void getBrandsList() {

        Response response = getRequestSpecification()
                .when()
                .get(Routes.BRANDS_LIST);

        String responseBody = response.getBody().asString();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Brands API Response:");
        System.out.println(responseBody);

        // Validate HTTP status
        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Expected HTTP status code 200"
        );

        // Validate API response code
        Assert.assertTrue(
                responseBody.contains("\"responseCode\": 200"),
                "API responseCode should be 200"
        );

        // Validate brands object
        Assert.assertTrue(
                responseBody.contains("\"brands\""),
                "Response should contain brands"
        );

        // Validate brand structure
        Assert.assertTrue(
                responseBody.contains("\"id\""),
                "Brands should contain IDs"
        );

        Assert.assertTrue(
                responseBody.contains("\"brand\""),
                "Brands should contain brand names"
        );
    }
}