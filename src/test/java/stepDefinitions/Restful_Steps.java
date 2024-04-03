package stepDefinitions;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import payload.RequestBody;

public class Restful_Steps {

	public int statusCode;
	public RequestSpecification request;
	public static Response response;
	@SuppressWarnings("rawtypes")
	public ResponseBody body;
	static String id;

	@Given("I hit the url of get products api endpoints")
	public void i_hit_the_url_of_get_products_api_endpoints() {
		RestAssured.baseURI = "https://api.restful-api.dev";
	}

	@When("I pass the url of products in the request")
	public void i_pass_the_url_of_products_in_the_request() {
		request = RestAssured.given();
		response = request.get("/objects");
	}

	@Then("I receive the response code as {int}")
	public void i_receive_the_response_code_as(int int1) {
		statusCode = response.getStatusCode();
		assertEquals(statusCode, 200);
	}

	@Then("I verify that the capacity of the first product is {string}")
	public void i_verify_that_the_capacity_of_the_first_product_is(String FirstProductCapacity) {
		body = response.getBody();

		// convert response body to string
		@SuppressWarnings("unused")
		String responseBody = body.asString();

		// JSON Representation from Response Body
		JsonPath jsonPath = response.jsonPath();

		String s = jsonPath.getJsonObject("data[0].capacity").toString();

		assertEquals(FirstProductCapacity, s);

	}

	@Given("I hit the url of post product api endpoint")
	public void i_hit_the_url_of_post_product_api_endpoint() {

		RestAssured.baseURI = "https://api.restful-api.dev";

	}

	@When("I pass the request body of the device")
	public void i_pass_the_request_body_of_device_name() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.body(RequestBody.postBody()).post("/objects");

	}

	@Then("I receive the response body with id")
	public static void i_receive_the_response_body_with_id() {
		response.prettyPrint();
		id = response.jsonPath().get("id");

	}

	@Given("I hit the url of put product api endpoint")
	public void i_hit_the_url_of_put_product_api_endpoint() {
		RestAssured.baseURI = "https://api.restful-api.dev";
	}

	@When("I pass the request body of put api and pass the url of products in the request with id")
	public void i_pass_the_request_body_of_put_api_and_pass_the_url_of_products_in_the_request_with_id() {

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.body(RequestBody.updateBody()).put("/objects/" + id);

	}

	@When("I pass the url of device in the request with id")
	public void i_pass_the_url_of_device_in_the_request_with_id() {
		request = RestAssured.given();

		response = request.get("/objects/" + id);
	}

	@Then("I verify the values are updated")
	public void i_verify_the_values_are_updated() {
		response = request.get("/objects/" + id);
		response.prettyPrint();

	}

	@Given("I hit the url of delete request api endpoints")
	public void i_hit_the_url_of_delete_request_api_endpoints() {
		RestAssured.baseURI = "https://api.restful-api.dev";
	}

	@When("I pass the delete request of device in the request with id")
	public void i_pass_the_delete_request_of_device_in_the_request_with_id() {
		request = RestAssured.given();

		response = request.delete("/objects/" + id);
	}

	@Then("I receive the response code as {int} and response body")
	public void i_receive_the_response_code_as_and_response_body(Integer int1) {
		statusCode = response.getStatusCode();

		assertEquals(statusCode, 200);

		response.prettyPrint();
	}

}
