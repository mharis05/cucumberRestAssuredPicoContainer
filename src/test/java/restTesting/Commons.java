package restTesting;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Commons {

    RequestSpecification commonRequest = RestAssured.with();
    Response commonResponse;

    @Given("^You have set the baseURI and headers for the request$")
    public void youHaveSetTheBaseURIAndHeadersForTheRequestForProductDetails() {
        // Write code here that turns the phrase above into concrete actions
        commonRequest.given().baseUri("http://10.4.10.105/api/v1/")
                .contentType(ContentType.JSON);

    }
}
