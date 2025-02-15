package step.defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.cucumber.java.en.Then;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

public class IncidentTableSteps {
	
	RequestSpecification request;	
	String request_payload;
	Response response;
	
	@Given("Set the base uri of the service now api")
	public void set_the_base_uri_of_the_service_now_api() {
		request = given().baseUri("https://dev262949.service-now.com");		
	}

	@Given("Set the base path of the service now api")
	public void set_the_base_path_of_the_service_now_api() {
		request.basePath("/api/now/table");		
	}

	@Given("Set the basic Auth of the service now api")
	public void set_the_basic_auth_of_the_service_now_api() {
		request.auth().basic("admin", "vW0eDfd+A0V-");
	}

	@Given("Set the header {string} key and {string} as value")
	public void set_the_header_as_value(String key, String value) {
		request.header(key, value).log().all();
	}

	@When("add the create incident request body as string")
	public void add_the_create_incident_request_body_as_string() {
		request_payload = """
				{
                  "short_description": "APISessionJAN2025",
                  "description": "Adding new record using POST"
                }
				""";
	}

	@When("hit the post http method")
	public void hit_the_post_http_method() {
		response = request.body(request_payload).post("/incident");
	}

	@Then("validate the status code and status line")
	public void validate_the_status_code_and_status_line() {
		response.then()
		        .log().all()
		        .assertThat()
		        .statusCode(201)
		        .statusLine(Matchers.containsString("Created"));
	}
	
}