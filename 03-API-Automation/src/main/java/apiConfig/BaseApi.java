package apiConfig;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

    protected static final String BASE_URL =
            "https://automationexercise.com";

    protected RequestSpecification getRequestSpecification() {

        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .header("Accept", "application/json");
    }
}