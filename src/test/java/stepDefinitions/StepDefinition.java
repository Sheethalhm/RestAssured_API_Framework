package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinition extends Utils {
    RequestSpecification request;
    ResponseSpecification responseBuilder;
    Response response;
    TestDataBuild dataBuild = new TestDataBuild();
    JsonPath jsonPath;
    static String placeId;

    @Given("Add Place Payload with {string} {string} {string}")
    public void addPlacePayloadWith(String name, String language, String address) throws IOException {

        responseBuilder = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        request = given().spec(requestSpecification()).body(dataBuild.getAddPlace(name, language, address));
    }

    @When("user calls {string} with {string} http request")
    public void userCallsWithHttpRequest(String resource, String method) {

        APIResources resourceAPI = APIResources.valueOf(resource);
        if(method.equalsIgnoreCase("POST"))
            response =request.when().post(resourceAPI.getPath());
        else if(method.equalsIgnoreCase("GET"))
            response =request.when().get(resourceAPI.getPath());
        else if(method.equalsIgnoreCase("DELETE"))
            response =request.when().delete(resourceAPI.getPath());

    }
    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1) {
        assertEquals(200, response.getStatusCode());
    }

    @Then("{string} in response body is {string}")
    public void inResponseBodyIs(String keyValue, String expectedValue) {

        assertEquals(getJsonPath(response, keyValue), expectedValue);
    }

    @And("verify place_Id created maps to {string} using {string}")
    public void verifyPlace_IdCreatedMapsToUsing(String name, String resource) throws IOException {
        placeId = getJsonPath(response, "place_id");
        request = given().spec(requestSpecification()).queryParam("place_id", placeId);
        userCallsWithHttpRequest(resource, "GET");
        String actualName = getJsonPath(response, "name");
        assertEquals(name, actualName);

    }

    @Given("Delete Place Payload")
    public void deletePlacePayload() throws IOException {

        request = given().spec(requestSpecification()).body(dataBuild.deletePayload(placeId));

    }
}
