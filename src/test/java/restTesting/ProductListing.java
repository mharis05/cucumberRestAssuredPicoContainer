package restTesting;


import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class ProductListing {

    private Commons myCommon = new Commons();
    public ProductListing(Commons myCommon){this.myCommon = myCommon;}

    //private RequestSpecification myRequest = RestAssured.with();
    private Response myResponse;



    @When("^You send the request for Product Listing$")
    public void youSendTheRequestForProductListing() {
        // Write code here that turns the phrase above into concrete actions

        myResponse = myCommon.commonRequest.when().get("/products/");
        System.out.println("Response is: " + myResponse.asString());

    }

    @Then("^Status code returned by Product Listing API is (\\d+)$")
    public void statusCodeReturnedByAPIIs(int code) {
        // Write code here that turns the phrase above into concrete actions
        myResponse.then().statusCode(code);
    }




}
