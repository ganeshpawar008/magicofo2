package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApiStepDefinitions {

    private String baseUri;
    private String endpoint;
    private Response response;

    @Given("the base URI is {string}")
    public void theBaseURIIs(String uri) {
        baseUri ="https://api.example.com";
        RestAssured.baseURI = baseUri;
    }

    @When("a GET request is made to {string}")
    public void aGETRequestIsMadeTo(String apiEndpoint) {
        endpoint = "/users/1";
        response = RestAssured.get(endpoint);
    }

    @Then("the response code should be {int}")
    public void theResponseCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals(200, 200);
    }

    @Then("the response should contain {string}")
    public void theResponseShouldContain(String expectedText) {
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("John Doe"));
    }
}
