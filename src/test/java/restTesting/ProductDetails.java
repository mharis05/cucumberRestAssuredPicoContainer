package restTesting;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import databasePackage.DatabaseConnection;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class ProductDetails {

    private Commons myCommon = new Commons();
    private DatabaseConnection myConnection = new DatabaseConnection();
    public ProductDetails(Commons myCommon) throws SQLException, ClassNotFoundException {this.myCommon = myCommon;}
    private String skuFromResponse, idFromResponse=null;


    //RequestSpecification myRequest = RestAssured.with();
    Response myResponse;



    @When("^You send the request for Product Details$")
    public void youSendTheRequest() {
        // Write code here that turns the phrase above into concrete actions
        myResponse = myCommon.commonRequest.when().get("products/em1-Embellished round frame acetate and gold tone sunglasses");
        String theResponse = myResponse.asString();
        System.out.println("Response is: " + theResponse);

        //System.out.println("When: Response: " + productListingResponse.asString());

    }


    @Then("^Status code returned by API is one of these$")
    public void statusCodeReturnedByAPIIsOneOfThese(DataTable endpointTable) {
        // Write code here that turns the phrase above into concrete actions

        List<List<String>> data = endpointTable.raw();

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i + 1).get(0));
        }

    }

    @Then("^Status code returned by Product Details API is (\\d+)$")
    public void statusCodeReturnedByAPIIs(int code) {
        // Write code here that turns the phrase above into concrete actions
        myResponse.then().statusCode(code);
    }



    @And("^Response body contains the required product name$")
    public void responseBodyContainsTheRequiredProductName(DataTable endpointTable){
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> data = endpointTable.raw();

        idFromResponse = myResponse.then().extract().path(data.get(0).get(0),data.get(0).get(1));
        skuFromResponse = myResponse.then().extract().path(data.get(1).get(0),data.get(1).get(1));
        myResponse.then().body(data.get(2).get(0),equalTo(data.get(2).get(1)));

        //String myValue = productListingResponse.then().extract().path(data.get(1).get(0));
        //assertEquals(myValue,data.get(1).get(1));
    }

    @Then("^Validate the ([^\"]*) and ([^\"]*)$")
    public void useTheFollowingCodesAlsoOppo(int one, String two) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("runs for: " + one + two);
    }



}

