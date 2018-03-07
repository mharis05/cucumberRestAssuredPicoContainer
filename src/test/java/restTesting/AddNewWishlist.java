package restTesting;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import databasePackage.DatabaseConnection;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class AddNewWishlist {

    private RequestSpecification myRequest = RestAssured.with();
    private Response myResponse;
    private JSONObject addNewWishlistJsonObj = new JSONObject();
    private DatabaseConnection myConn = new DatabaseConnection();
    private ResultSet myResultSet;
    private String id = null;




    public AddNewWishlist() throws SQLException, ClassNotFoundException {
    }

    @Given("^API Headers are set$")
    public void apiHeadersAreSet(){
        // Write code here that turns the phrase above into concrete actions

        myRequest.contentType(ContentType.JSON)
                .baseUri("http://10.4.10.105/api/v1/")
                .header("Auth-token","ec6effac-7b12-4021-ba80-c682169cff60");

    }

    @And("^JSON document is ready$")
    public void jsonDocumentIsReady() {
        // Write code here that turns the phrase above into concrete actions
        addNewWishlistJsonObj.put("name","Demo Wishlist");
        addNewWishlistJsonObj.put("isDefault", "false");

        System.out.println("Request: " + addNewWishlistJsonObj.toString());
    }

    @When("^User sends a POST Request to \"([^\"]*)\"$")
    public void userSendsAPOSTRequestTo(String URL) {
        // Write code here that turns the phrase above into concrete actions
        String requestBody = addNewWishlistJsonObj.toString();
        myResponse = myRequest.when().body(requestBody).post(URL);
        System.out.println("Response: " + myResponse.asString());
    }

    @Then("^Validate that response contains correct information$")
    public void validateThatResponseContainsCorrectInformation() {
        // Write code here that turns the phrase above into concrete actions
        //myResponse.then().body("content[0].name",equalTo("Demo Wishlist"));
        id = myResponse.then().extract().path("id").toString();
        System.out.println("Wishlist ID is: " + id);
    }

    @And("^See if database has been updated$")
    public void seeIfDatabaseHasBeenUpdated() throws SQLException, ClassNotFoundException {
        // Write code here that turns the phrase above into concrete actions

        myResultSet = myConn.execute("select name, user_id from wishlist where id =" + id);

        while(myResultSet.next()){
            String result = myResultSet.getString(1);
            String result2 = myResultSet.getString(2);
            System.out.println(result + " and " + result2);
        }

        myConn.closeConnection();

    }
}
