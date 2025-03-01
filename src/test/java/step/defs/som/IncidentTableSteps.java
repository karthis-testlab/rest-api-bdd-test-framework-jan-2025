package step.defs.som;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import service.now.pojos.model.IncidentRequestPayload;
import service.now.som.with.restassured.base.IncidentService;

import static io.restassured.RestAssured.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncidentTableSteps {

	String payload;	
	IncidentRequestPayload incident = new IncidentRequestPayload();
	
	IncidentService incidentService = new IncidentService();
	RequestSpecBuilder request = new RequestSpecBuilder();

	@Given("Set the base uri of the service now api")
	public void set_the_base_uri_of_the_service_now_api() {
		//request = given().baseUri("https://dev262949.service-now.com");
		request.setBaseUri("https://dev262949.service-now.com");
	}

	@Given("Set the base path of the service now api")
	public void set_the_base_path_of_the_service_now_api() {
		//request.basePath("/api/now/table");
		request.setBasePath("/api/now/table");
	}

	@Given("Set the basic Auth of the service now api")
	public void set_the_basic_auth_of_the_service_now_api() {
		//request.auth().basic("admin", "vW0eDfd+A0V-");
		request.setAuth(basic("admin", "vW0eDfd+A0V-"));
	}

	@Given("Set the header {string} key and {string} as value")
	public void set_the_header_as_value(String key, String value) {
		//request.header(key, value);
		request.addHeader(key, value);
	}

	@When("hit the get http method")
	public void hit_the_get_http_method() {
		//response = request.get("/incident");
		incidentService.getIncident(request);
	}

	@When("hit the get http method with non existence sys_id {string}")
	public void hit_the_get_http_method_with_non_existence_sys_id(String sysId) {
		//response = request.get("/incident/" + sysId);
		incidentService.getIncident(request, sysId);
	}

	@When("validate the status code and status line of non existing sys id")
	public void validate_the_status_code_and_status_line_of_non_existing_sys_id() {
		//response.then().statusCode(404).statusLine(Matchers.containsString("Not Found"));
	    incidentService.validateResponse(404, "Not Found", "application/json");
	}

	@Then("validate the status code and status line of GET method")
	public void validate_the_status_code_and_status_line_of_get_method() {
		//response.then().statusCode(200).statusLine(Matchers.containsString("OK"));
		incidentService.validateResponse(200, "OK", "application/json");
	}

	@When("add the create incident request body as string")
	public void add_the_create_incident_request_body_as_string() {
		payload = """
				{
				 "short_description": "APISessionJAN2025",
				 "description": "Adding new record using POST"
				}
				""";
	}

	@When("hit the post http method")
	public void hit_the_post_http_method() {
		//response = request.body(request_payload).post("/incident");
		incidentService.createIncident(request, payload);
	}

	@When("/^create the incident record with description (.*) in the request body$/")
	public void addDescriptionInBody(String description) {
		System.out.println(description);
		incident.setDescription(description);
	}

	@When("/^create the incident record with shaort description (.*) in the request body$/")
	public void addShortDescriptionInBody(String short_description) {
		System.out.println(short_description);
		incident.setShort_description(short_description);
	}

	@When("hit the post http method with request body as the pojo object")
	public void hit_the_post_http_method_with_request_body_as_the_pojo_object() {
		//response = request.body(incident).post("/incident");
		incidentService.createIncident(request, incident);
	}
	
	@When("Set the header key and header value")
	public void set_the_header_key_and_header_value(DataTable dataTable) {
		List<List<String>> headers = dataTable.asLists(String.class);
		System.out.println(dataTable.asMaps(String.class, String.class));
		Map<String, String> map = new HashMap<String, String>();		
		for (int i = 1; i <= headers.size()-1; i++) {
			map.put(headers.get(i).get(0), headers.get(i).get(1));
		}
		//request.headers(map).log().all();
		request.addHeaders(map);
	}

	@Then("validate the status code and status line")
	public void validate_the_status_code_and_status_line() {
		//response.then().assertThat().statusCode(201).statusLine(Matchers.containsString("Created"));
		incidentService.validateResponse(201, "Created", "application/json");
	}

}